package com.tourism.service;

import com.tourism.util.wxtool.WXTool;
import org.junit.Test;

public class UserServiceTest {

//	public User WxCodeTest(){
//		WxApi action = Feign.builder()
//				.encoder(new JacksonEncoder())
//				.decoder(new JacksonDecoder())
//				.options(new Request.Options(1000, 3500))
//				.retryer(new Retryer.Default(5000, 5000, 3))
//				.target(
//						WxApi.class,
//						"http://10.210.96.229:8080"
//				);
//		return action.setUserByCode("123");
//	}

	@Test
	public void test1() {
		System.out.println(new WXTool().getUserOpenIdAndSessionKeyByCode("123"));
	}
}