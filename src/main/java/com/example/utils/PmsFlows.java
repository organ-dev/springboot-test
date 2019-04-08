package com.example.utils;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


@Component
public class PmsFlows<T extends Object, S extends Object> {

	private static final Logger logger = LoggerFactory.getLogger(PmsFlows.class);

	ApplicationEventPublisher publisher;

	PlatformTransactionManager transactionManager;

	private List<Function<T, PmsProcessResult>> start = new ArrayList<Function<T, PmsProcessResult>>();

	//	private List<Consumer<PmsProcessResult>> flows = new ArrayList<Consumer<PmsProcessResult>>();
	private List flows = new ArrayList();

	private List<Consumer<PmsProcessResult>> finalFlows = new ArrayList<Consumer<PmsProcessResult>>();

	private List<Function<PmsProcessResult, S>> end = new ArrayList<Function<PmsProcessResult, S>>();

	private Switch switchBean;

	private Transaction transactionBean;

	public PmsFlows<T, S> start(Function<T, PmsProcessResult> func) {
		start.add(func);
		return this;
	}

	public PmsFlows<T, S> end(Function<PmsProcessResult, S> func) {
		end.add(func);
		return this;
	}

	public PmsFlows<T, S> addFlow(Consumer<PmsProcessResult> func) {
		flows.add(func);
		return this;
	}

	public PmsFlows<T, S> addFlow(BiConsumer<PmsProcessResult, String[]> func, String... para) {
		flows.add(new BiFlow(func, para));
		return this;
	}

	public PmsFlows<T, S> addFlow(BiConsumer<PmsProcessResult, Object[]> func, Object... para) {
		flows.add(new BiFlow(func, para));
		return this;
	}


	public PmsFlows<T, S> publishEvent(ApplicationEventPublisher publisher,
									   Class<? extends ApplicationEvent> eventClasz) {
		this.publisher = publisher;
		flows.add(new Event(eventClasz));
		return this;
	}

	public PmsFlows<T, S> _switch(Function<PmsProcessResult, String> func) {
		flows.add(new Switch(func));
		return this;
	}


	public PmsFlows<T, S> _case(Boolean value, Consumer<PmsProcessResult> func) {
		flows.add(new Case(func,value));
		return this;
	}

	public PmsFlows<T, S> _case(String value, Consumer<PmsProcessResult> func) {
		flows.add(new Case(func,value));
		return this;
	}


	public PmsFlows<T, S> _case(String[] value, Consumer<PmsProcessResult> func) {
		flows.add(new Case(func,value));
		return this;
	}


	public PmsFlows<T, S> _case(String value, BiConsumer<PmsProcessResult,Object[]> func,Object... para) {
		BiFlow flow = new BiFlow(func, para);
		flows.add(new BiCase(flow,value));
		return this;
	}

	public PmsFlows<T, S> _case(String[] value, BiConsumer<PmsProcessResult,Object[]> func,Object... para) {
		BiFlow flow = new BiFlow(func, para);
		flows.add(new BiCase(flow,value));
		return this;
	}

	public PmsFlows<T, S> _caseNullOrBlank(Consumer<PmsProcessResult> func) {
		flows.add(new CaseNullOrBlank(func));
		return this;
	}


	public PmsFlows<T, S> _default(BiConsumer<PmsProcessResult,Object[]> func,Object... para) {
		BiFlow flow = new BiFlow(func, para);
		flows.add(new BiDefault(flow));
		return this;
	}

	public PmsFlows<T, S> append(PmsFlows otherFlows){
		List otherFlowList = otherFlows.getFlowList();
		this.flows.addAll(otherFlowList);
		return this;
	}

	public List getFlowList() {
		return flows;
	}

	public PmsFlows<T, S> _alwaysDo(Consumer<PmsProcessResult> func) {
		finalFlows.add(func);
		return this;
	}


	public S execute(T vo) {
		S rtnVo = null;
		try {
			PmsProcessResult result = new PmsProcessResult();
			for (Function<T, PmsProcessResult> fun : start) {
				if (result.isSuccess()) {
					result = fun.apply(vo);
				}
			}

			for (Object obj : flows) {
				if (result.isFail()) {
					break;
				}
				if (obj instanceof Consumer) {
					Consumer<PmsProcessResult> fun = (Consumer<PmsProcessResult>) obj;
					fun.accept(result);
				}
				if (obj instanceof PmsFlows.BiFlow) {
					PmsFlows.BiFlow bean = (PmsFlows.BiFlow) obj;
					bean.execute(result);
				}

				if (obj instanceof PmsFlows.Switch) {
					switchBean = (PmsFlows.Switch) obj;
					switchBean.execute(result);
				}
				if (obj instanceof PmsFlows.Case) {
					PmsFlows.Case caseBean = (PmsFlows.Case) obj;
					caseBean.execute(result);
				}
				if (obj instanceof PmsFlows.BiCase) {
					PmsFlows.BiCase caseBean = (PmsFlows.BiCase) obj;
					caseBean.execute(result);
				}
				if (obj instanceof PmsFlows.CaseNullOrBlank) {
					PmsFlows.CaseNullOrBlank caseBean = (PmsFlows.CaseNullOrBlank) obj;
					caseBean.execute(result);
				}


				if (obj instanceof PmsFlows.Event) {

					PmsFlows.Event eventBean = (PmsFlows.Event) obj;
					Class eventClasz = eventBean.get();
					Constructor c = eventClasz.getDeclaredConstructors()[0];
					ApplicationEvent event = (PmsEvent.BaseEvent) c.newInstance(result);
					System.out.println(publisher);
					System.out.println(event);
					publisher.publishEvent(event);
				}

				if (obj instanceof PmsFlows.Transaction) {
					transactionBean = (PmsFlows.Transaction) obj;
					transactionBean.execute();
				}
				if (obj instanceof PmsFlows.Commit) {
					PmsFlows.Commit commitBean = (PmsFlows.Commit) obj;
					commitBean.execute(transactionBean);
				}
			}
			for(Consumer<PmsProcessResult> fun:finalFlows) {
				fun.accept(result);
			}
			for (Function<PmsProcessResult, S> fun : end) {
				rtnVo = fun.apply(result);
			}
		} catch (Exception e) {
			logger.error("PmsFlows Exception");
			logger.error(e.getMessage(), e);

			if(transactionBean!=null) {
				transactionBean.rollback();
			}
		}

		return rtnVo;
	}

	class Event {
		private Class<? extends ApplicationEvent> eventClasz;

		public Event(Class<? extends ApplicationEvent> eventClasz) {
			this.eventClasz = eventClasz;
		}

		public Class<? extends ApplicationEvent> get() {
			return eventClasz;
		}
	}


	class BiFlow<T> {
		private BiConsumer<PmsProcessResult, T[]> func;
		private T[] para;

		public BiFlow(BiConsumer<PmsProcessResult, T[]> func, T... para) {
			this.func = func;
			this.para = para;
		}

		public void execute(PmsProcessResult result) {
			func.accept(result, para);
		}
	}

	class Switch {

		private Function<PmsProcessResult, String> func;
		private Object value;
		private boolean caseExecuteFlag = false; // 是否有case被执行

		public Switch(Function<PmsProcessResult, String> func) {
			this.func = func;
		}

		public void execute(PmsProcessResult result) {
			this.value = func.apply(result);
		}

		public Object get() {
			return value;
		}

		public void caseExecute() {
			caseExecuteFlag = true;
		}

		public boolean hasCaseExecute() {
			return caseExecuteFlag;
		}

	}

	class Case {

		private Object[] values;
		private Consumer<PmsProcessResult> func;

		public Case(Consumer<PmsProcessResult> func,Object... values) {
			this.func = func;
			this.values = values;
		}

		public void execute(PmsProcessResult result) {
			for(Object value:values) {
				if (switchBean.get().equals(value)) {
					switchBean.caseExecute();
					func.accept(result);
					break;
				}
			}
		}
	}

	class CaseNullOrBlank{

		private Consumer<PmsProcessResult> func;

		public CaseNullOrBlank(Consumer<PmsProcessResult> func) {
			this.func = func;
		}

		public void execute(PmsProcessResult result) {
			if (switchBean.get() == null || switchBean.get().equals("")) {
				switchBean.caseExecute();
				func.accept(result);
			}
		}
	}

	class BiCase {

		protected Object[] values;
		protected BiFlow func;


		public BiCase() {
		}

		public BiCase(BiFlow func,Object... values) {
			this.func = func;
			this.values = values;
		}

		public void execute(PmsProcessResult result) {
			for(Object value:values) {
				if (switchBean.get().equals(value)) {
					switchBean.caseExecute();
					func.execute(result);
					break;
				}
			}
		}
	}

	class BiDefault extends BiCase {

		public BiDefault(BiFlow func) {
			super.func = func;
		}

		public void execute(PmsProcessResult result) {
			if (!switchBean.hasCaseExecute()) {
				func.execute(result);
			}
		}
	}

	class Transaction {
		TransactionStatus transactionStatus;

		public void execute() {
			DefaultTransactionDefinition def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
			this.transactionStatus = transactionManager.getTransaction(def);
		}

//		public TransactionStatus fetch() {
//			return this.transactionStatus;
//		}

		public void commit() {
			transactionManager.commit(transactionStatus);
		}

		public void rollback() {
			if(transactionStatus!=null) {
				transactionManager.rollback(transactionStatus);
			}
		}


	}

	class Commit {
		public void execute(Transaction transactionBean) {
			transactionBean.commit();
		}
	}

	public static void main(String[] args) {}

}
