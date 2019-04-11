package com.example.utils.pms;

import com.example.domain.Pay;
import com.example.domain.PmsResultVo;
import com.example.service.impl.PmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Auther: ld
 * @Date: 2019/4/8 16:25
 * @Param ${tags}
 * @Description:
 */
@Component
public class PmsFlowsConstans {
	@Autowired
	PmsServiceImpl pmsService;
	public Function<Pay, PmsProcessResult> CASH_COLLECT_INIT_ORDER;
	public Consumer<PmsProcessResult> CASH_COLLECT_CHECK_ORDER;
	public Consumer<PmsProcessResult> COMM_ORDER_SAVE_ORDER;
	public Consumer<PmsProcessResult> COMM_ORDER_HANDLE_TRANS_RESULT;
	public Function<PmsProcessResult, PmsResultVo> COMM_ORDER_BUILD_RTN;

	@PostConstruct
	private void init() {
		CASH_COLLECT_INIT_ORDER = pmsService::initOrder;
		CASH_COLLECT_CHECK_ORDER = pmsService::checkOrder;
		COMM_ORDER_SAVE_ORDER = pmsService::saveOrder;
		COMM_ORDER_HANDLE_TRANS_RESULT = pmsService::handleTransResult;
		COMM_ORDER_BUILD_RTN = pmsService::buildRtn;
	}
}
