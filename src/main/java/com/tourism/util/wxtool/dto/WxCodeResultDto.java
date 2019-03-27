package com.tourism.util.wxtool.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@Setter
@ToString(callSuper = true)
public class WxCodeResultDto implements Serializable {

	private String openId;
	private String sessionKey;
	private String unionid;
	private Integer errcode;
	private String errmsg;

}
