package com.tourism.util.wxtool;

import com.tourism.util.wxtool.apiBind.WxApi;
import com.tourism.util.wxtool.dto.WxCodeDto;
import com.tourism.util.wxtool.dto.WxCodeResultDto;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:WxApi.yml")
@Slf4j
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
		WxCodeResultDto wxCodeResultDto = action.jscode2session(new WxCodeDto(
				appId,
				secret,
				code,
				"authorization_code"
		));
		log.info("code: "+code+" become resultDto: "+wxCodeResultDto);
		return wxCodeResultDto;
	}

}
