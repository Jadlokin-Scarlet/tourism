package com.tourism.wxtool.dto;

public class WxCodeDto {
	private String appId;
	private String secret;
	private String js_code;
	private String grant_type;

	public WxCodeDto(String appId, String secret, String js_code, String grant_type) {
		this.appId = appId;
		this.secret = secret;
		this.js_code = js_code;
		this.grant_type = grant_type;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getJs_code() {
		return js_code;
	}

	public void setJs_code(String js_code) {
		this.js_code = js_code;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	@Override
	public String toString() {
		return "WxCodeDto{" +
				"appId='" + appId + '\'' +
				", secret='" + secret + '\'' +
				", js_code='" + js_code + '\'' +
				", grant_type='" + grant_type + '\'' +
				'}';
	}
}
