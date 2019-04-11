package com.example.utils.pms;

import com.example.utils.pms.PmsProcessResult;
import org.springframework.context.ApplicationEvent;

/**
 * @Auther: ld
 * @Date: 2019/4/8 16:21
 * @Param ${tags}
 * @Description:
 */
public class PmsEvent {
	public static abstract class BaseEvent<T> extends ApplicationEvent {
		private static final long serialVersionUID = 895628808370649881L;
		protected T eventData;

		public BaseEvent(T eventData) {
			super(eventData);
			this.eventData = eventData;
		}

		public T getEventData() {
			return eventData;
		}

		public void setEventData(T eventData) {
			this.eventData = eventData;
		}
	}

	public static class TestEvent extends BaseEvent<PmsProcessResult> {
		public TestEvent(PmsProcessResult result) {
			super(result);
		}
	}


	public static class ReturnRemittanceFinishEvent extends BaseEvent<PmsProcessResult> {
		public ReturnRemittanceFinishEvent(PmsProcessResult result) {
			super(result);
		}
	}

}
