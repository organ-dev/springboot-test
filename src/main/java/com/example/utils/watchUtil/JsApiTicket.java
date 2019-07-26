package com.example.utils.watchUtil;

import java.io.Serializable;

/**
 * @Auther: ld
 * @Date: 2019/7/25 17:11
 * @Param ${tags}
 * @Description:
 */
public class JsApiTicket implements Serializable {
	private String ticket;
	// 凭证有效期，单位：秒
	private int expiresIn;

	public JsApiTicket() {

	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	@Override
	public String toString() {
		return "JsApiTicket{" +
				"ticket='" + ticket + '\'' +
				", expiresIn=" + expiresIn +
				'}';
	}
}
