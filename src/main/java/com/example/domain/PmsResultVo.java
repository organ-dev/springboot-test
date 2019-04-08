package com.example.domain;

import java.io.Serializable;

/**
 * @Auther: ld
 * @Date: 2019/4/8 16:38
 * @Param ${tags}
 * @Description:
 */
public class PmsResultVo implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -1118975388407528983L;

	/**
	 * 返回码
	 */
	private String rtnCode;

	/**
	 * 返回消息
	 */
	private String rtnMsg;

	/**
	 * 交易流水号
	 */
	private String refNo;

	/**
	 * 发送方订单号
	 */
	private String orderNo;

	/**
	 * 订单状态
	 * 00 待处理,  01 处理中,  02 支付成功,  03 支付失败,  08 支付中待PFA异步通知
	 */
	private String orderState;

	/**
	 * 返回字符串（某些系统返回值为字符串）
	 */
	private String rtnStr;

	public PmsResultVo() {}

	public PmsResultVo(String refNo,String orderNo,String rtnCode,String rtnMsg){
		this.refNo = refNo;
		this.orderNo = orderNo;
		this.rtnCode = rtnCode;
		this.rtnMsg = rtnMsg;
	}

	public PmsResultVo(String rtnCode,String rtnMsg) {
		this.rtnCode = rtnCode;
		this.rtnMsg = rtnMsg;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(String rtnCode) {
		this.rtnCode = rtnCode;
	}

	public String getRtnMsg() {
		return rtnMsg;
	}

	public void setRtnMsg(String rtnMsg) {
		this.rtnMsg = rtnMsg;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getRtnStr() {
		return rtnStr;
	}

	public void setRtnStr(String rtnStr) {
		this.rtnStr = rtnStr;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	@Override
	public String toString() {
		return "PmsResultVo [rtnCode=" + rtnCode + ", rtnMsg=" + rtnMsg + ", refNo=" + refNo + ", orderNo=" + orderNo+ "]+"+rtnStr+"";
	}

}
