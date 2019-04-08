package com.example.service.impl;

import com.example.domain.Pay;
import com.example.domain.PmsResultVo;
import com.example.utils.PmsProcessResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ld
 * @Date: 2019/4/8 16:28
 * @Param ${tags}
 * @Description:
 */
@Component
public class PmsServiceImpl {
	public PmsProcessResult initOrder(Pay pay) {
		PmsProcessResult result = new PmsProcessResult();
		System.out.println("包装订单");
		return result;
	}

	public void checkOrder(PmsProcessResult result) {
		System.out.println("检查订单");
	}

	public void saveOrder(PmsProcessResult result) {
		System.out.println("保存订单");
	}

	public void handleTransResult(PmsProcessResult result) {
		System.out.println("操作订单");
	}

	public PmsResultVo buildRtn(PmsProcessResult result) {
		PmsResultVo pmsResultVo = new PmsResultVo();
		System.out.println("结算订单，返回结果");
		return pmsResultVo;
	}
}
