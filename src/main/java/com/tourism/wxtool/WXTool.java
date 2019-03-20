package com.tourism.wxtool;

import com.tourism.wxtool.apiBind.WxApi;
import com.tourism.wxtool.dto.WxCodeDto;
import com.tourism.wxtool.dto.WxCodeResultDto;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:WxApi.yml")
public class WXTool {

	@Value("${appId}")
	private String appId;

	@Value("${secret}")
	private String secret;

	public WxCodeResultDto getUserOpenIdAndSessionKeyByCode(String code){
		WxApi action = Feign.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.options(new Request.Options(1000, 3500))
				.retryer(new Retryer.Default(5000, 5000, 3))
				.target(
						WxApi.class,
						"https://api.weixin.qq.com"
//						"http://10.210.96.229:8080"
				);
		return action.jscode2session(new WxCodeDto(
				appId,
				secret,
				code,
				"authorization_code"
		));
//		return action.setUserByCode(code);
	}

}
