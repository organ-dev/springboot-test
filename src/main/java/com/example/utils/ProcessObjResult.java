package com.example.utils;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ld
 * @Date: 2019/4/8 16:18
 * @Param ${tags}
 * @Description:
 */
public class ProcessObjResult implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final boolean PROCESS_STATUS_SUCCESS = true;
	public static final boolean PROCESS_STATUS_FAIL = false;
	private boolean processStatus = true;
	private String rtnCode = "";
	private String rtnMsg = "";
	@Valid
	private Object paramObj;
	private Object rtnObj;
	@NotEmpty(
			message = "消息ID不允许为空"
	)
	private String msgId;
	private String orgiMsgId;
	@NotNull(
			message = "消息发送时间不允许为空"
	)
	private Date msgCreateTime;
	@NotEmpty(
			message = "发送方不允许为空"
	)
	private String sender;
	@NotEmpty(
			message = "接收方不允许为空"
	)
	@Size
	private String receiver;
	private String channel;
	private List<?> dataList;
	private Map<String, Object> contextMap = new HashMap();
	private Map<String, Object> reqParaMap = new HashMap();
	private Map<String, Object> rtnInfoMap = new HashMap();
	private boolean lockFlag = false;
	private boolean isFailNotBack = false;
	private Pageable pageable;
	private int curPage;
	private int pageSize;
	private int totalPage;
	private long totalSize;

	public ProcessObjResult() {
		this.setProcessStatus(true);
	}

	public ProcessObjResult(boolean processStatus) {
		this.setProcessStatus(processStatus);
	}

	public void setRtnCodeAndMsg(String rtnCode, String rtnMsg) {
		this.setRtnCode(rtnCode);
		this.setRtnMsg(rtnMsg);
	}

	public void setReqParaMap(Map<String, Object> reqParaMap) {
		this.reqParaMap = reqParaMap;
	}

	public void setRtnInfoMap(Map<String, Object> rtnInfoMap) {
		this.rtnInfoMap = rtnInfoMap;
	}

	public boolean isSuccess() {
		return this.processStatus;
	}

	public boolean isFail() {
		return !this.processStatus;
	}

	public void success() {
		this.setProcessStatus(true);
	}

	public void success(String rtnCode, String rtnMsg) {
		this.setProcessStatus(true);
		this.setRtnCode(rtnCode);
		this.setRtnMsg(rtnMsg);
	}

	public void fail() {
		this.setProcessStatus(false);
	}

	public void fail(String rtnCode, String rtnMsg) {
		this.setProcessStatus(false);
		this.setRtnCode(rtnCode);
		this.setRtnMsg(rtnMsg);
	}

	public void setTotalPageAndTotalSize(Page<?> page) {
		this.totalPage = page.getTotalPages();
		this.totalSize = page.getTotalElements();
	}

	public void setToRtnInfoMap(String aKey, Object aValue) {
		this.rtnInfoMap.put(aKey, aValue);
	}

	public Object getFromRtnInfoMap(String aKey, Object aDefault) {
		Object objRtn = this.rtnInfoMap.get(aKey);
		if (objRtn == null) {
			objRtn = aDefault;
		}

		return objRtn;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n").append("ProcessObjResult is ");
		if (this.isSuccess()) {
			sb.append("Success");
		} else {
			sb.append("Fail");
		}

		sb.append("\n");
		sb.append("Msg Id : ").append(this.msgId).append("\n");
		sb.append("Rtn Cod: ").append(this.getRtnCode()).append("\n");
		sb.append("Rtn Msg: ").append(this.getRtnMsg()).append("\n");
		sb.append("Req Para: ").append(this.reqParaMap).append("\n");
		sb.append("Context : ").append(this.contextMap).append("\n");
		sb.append("Rtn Data: ").append(this.rtnInfoMap).append("\n");
		sb.append("par Obj: ").append(this.paramObj).append("\n");
		sb.append("rtn Obj: ").append(this.rtnObj).append("\n");
		return sb.toString();
	}

	public Object getFromRtnInfoMap(String aKey) {
		return this.getFromRtnInfoMap(aKey, (Object)null);
	}

	public String getStringFromRtnInfoMap(String aKey, String aDefault) {
		Object obj = this.rtnInfoMap.get(aKey);
		return obj != null ? String.valueOf(obj) : aDefault;
	}

	public String getStringFromRtnInfoMap(String aKey) {
		return this.getStringFromRtnInfoMap(aKey, (String)null);
	}

	public void setToReqParaMap(String aKey, Object aValue) {
		this.reqParaMap.put(aKey, aValue);
	}

	public Object getFromReqParaMap(String aKey, Object aDefault) {
		Object objRtn = this.reqParaMap.get(aKey);
		if (objRtn == null) {
			objRtn = aDefault;
		}

		return objRtn;
	}

	public Object getFromReqParaMap(String aKey) {
		return this.getFromReqParaMap(aKey, (Object)null);
	}

	public String getStringFromReqParaMap(String aKey, String aDefault) {
		Object obj = this.reqParaMap.get(aKey);
		return obj != null ? String.valueOf(obj) : aDefault;
	}

	public String getStringFromReqParaMap(String aKey) {
		return this.getStringFromReqParaMap(aKey, (String)null);
	}

	public void setToContextMap(String aKey, Object aValue) {
		this.contextMap.put(aKey, aValue);
	}

	public Object getFromContextMap(String aKey, Object aDefault) {
		Object objRtn = this.contextMap.get(aKey);
		if (objRtn == null) {
			objRtn = aDefault;
		}

		return objRtn;
	}

	public Object getFromContextMap(String aKey) {
		return this.getFromContextMap(aKey, (Object)null);
	}

	public String getStringFromContextMap(String aKey, String aDefault) {
		Object obj = this.getFromContextMap(aKey);
		return obj != null ? String.valueOf(obj) : aDefault;
	}

	public String getStringFromContextMap(String aKey) {
		return this.getStringFromContextMap(aKey, (String)null);
	}

	public boolean getProcessStatus() {
		return this.processStatus;
	}

	public void setProcessStatus(boolean processStatus) {
		this.processStatus = processStatus;
	}

	public String getRtnCode() {
		return this.rtnCode;
	}

	public void setRtnCode(String rtnCode) {
		this.rtnCode = rtnCode;
	}

	public String getRtnMsg() {
		return this.rtnMsg;
	}

	public void setRtnMsg(String rtnMsg) {
		this.rtnMsg = rtnMsg;
	}

	public Map<String, Object> getRtnInfoMap() {
		return this.rtnInfoMap;
	}

	public Map<String, Object> getReqParaMap() {
		return this.reqParaMap;
	}

	public void setReqClassAndMethodName(String className, String methodName) {
		this.setReqClassName(className);
		this.setReqMethodName(methodName);
	}

	public String getReqClassName() {
		return this.getStringFromContextMap("INTERNAL_REQ_CLASS_NAME");
	}

	public void setReqClassName(String reqClassName) {
		this.setToContextMap("INTERNAL_REQ_CLASS_NAME", reqClassName);
	}

	public String getReqMethodName() {
		return this.getStringFromContextMap("INTERNAL_REQ_METHOD_NAME");
	}

	public void setReqMethodName(String reqMethodName) {
		this.setToContextMap("INTERNAL_REQ_METHOD_NAME", reqMethodName);
	}

	public Map<String, Object> getContextMap() {
		return this.contextMap;
	}

	public void setContextMap(Map<String, Object> contextMap) {
		this.contextMap = contextMap;
	}

	public Object getParamObj() {
		return this.paramObj;
	}

	public void setParamObj(Object paramObj) {
		this.paramObj = paramObj;
	}

	public Object getRtnObj() {
		return this.rtnObj;
	}

	public void setRtnObj(Object rtnObj) {
		this.rtnObj = rtnObj;
	}

	public boolean isLockFlag() {
		return this.lockFlag;
	}

	public void setLockFlag(boolean lockFlag) {
		this.lockFlag = lockFlag;
	}

	public boolean isFailNotBack() {
		return this.isFailNotBack;
	}

	public void setFailNotBack(boolean isFailNotBack) {
		this.isFailNotBack = isFailNotBack;
	}

	public Pageable getPageable() {
		return (Pageable)(null == this.pageable && this.pageSize != 0 ? new PageRequest(this.curPage, this.pageSize) : this.pageable);
	}

	public void setPageable(Pageable pageable) {
		this.curPage = pageable.getPageNumber() - 1;
		this.pageSize = pageable.getPageSize();
	}

	public void setPageable(int page, int size) {
		this.curPage = page;
		this.pageSize = size;
	}

	public boolean getIsFailNotBack() {
		return this.isFailNotBack;
	}

	public void setIsFailNotBack(boolean isFailNotBack) {
		this.isFailNotBack = isFailNotBack;
	}

	public String getMsgId() {
		return this.msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getOrgiMsgId() {
		return this.orgiMsgId;
	}

	public void setOrgiMsgId(String orgiMsgId) {
		this.orgiMsgId = orgiMsgId;
	}

	public Date getMsgCreateTime() {
		return this.msgCreateTime;
	}

	public void setMsgCreateTime(Date msgCreateTime) {
		this.msgCreateTime = msgCreateTime;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getCurPage() {
		return this.pageable != null ? this.pageable.getPageNumber() + 1 : this.curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return this.pageable != null ? this.pageable.getPageSize() : this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return this.totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalSize() {
		return this.totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public List<?> getDataList() {
		return this.dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}
}
