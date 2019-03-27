package com.tourism.util.wxtool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class WxCodeDto {
	private String appId;
	private String secret;
	private String js_code;
	private String grant_type;
}
