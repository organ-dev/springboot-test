package com.example.service;

import com.example.domain.Pay;
import com.example.domain.PmsResultVo;
import com.example.repository.PmsRepository;
import com.example.utils.pms.PmsFlows;
import com.example.utils.pms.PmsFlowsConstans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Auther: ld
 * @Date: 2019/4/8 16:09
 * @Param ${tags}
 * @Description:
 */
@Service
@Component
public class PmsServer implements PmsRepository {
	@Autowired
	PmsFlowsConstans flows;

	@Override
	public PmsResultVo queryPayList(Pay pay) {
		return new PmsFlows<Pay, PmsResultVo>()
				.start(flows.CASH_COLLECT_INIT_ORDER)
				.addFlow(flows.CASH_COLLECT_CHECK_ORDER)
				.addFlow(flows.COMM_ORDER_SAVE_ORDER)
				._alwaysDo(flows.COMM_ORDER_HANDLE_TRANS_RESULT)
				.end(flows.COMM_ORDER_BUILD_RTN)
				.execute(pay);
	}
}
