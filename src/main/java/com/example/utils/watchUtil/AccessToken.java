package com.example.utils.watchUtil;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Auther: ld
 * @Date: 2019/7/25 13:55
 * @Param ${tags}
 * @Description:
 */
public class AccessToken {
	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("expires_in")
	private long expiresIn;

	public AccessToken() {

	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	@Override
	public String toString() {
		return "AccessToken{" +
				"accessToken='" + accessToken + '\'' +
				", expiresIn=" + expiresIn +
				'}';
	}
}
