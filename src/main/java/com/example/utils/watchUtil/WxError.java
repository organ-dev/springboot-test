package com.example.utils.watchUtil;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Auther: ld
 * @Date: 2019/7/25 14:04
 * @Param ${tags}
 * @Description:
 */
public class WxError {
	@JsonProperty("errcode")
	private int errorCode;

	@JsonProperty("errmsg")
	private String errorMsg;
	private String json;

	public static WxError fromJson(String json) {
		WxError wxError = JsonMapper.defaultMapper().fromJson(json, WxError.class);
		wxError.setJson(json);
		return wxError;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
}
