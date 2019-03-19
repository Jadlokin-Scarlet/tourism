package com.tourism.wxtool.apiBind;

import com.tourism.wxtool.dto.WxCodeDto;
import com.tourism.wxtool.dto.WxCodeResultDto;
import feign.RequestLine;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(url = "api.weixin.qq.com",name = "WxApi")
//@FeignClient(url = "http://10.210.96.229:8080")
public interface WxApi {

	@RequestLine("GET /sns/jscode2session")
	WxCodeResultDto jscode2session(
			@RequestBody WxCodeDto wxCodeDto
	);
//	@RequestLine("POST /api/user/userCode")
//	public User setUserByCode(@RequestParam("code") String code);

}
