package com.tourism.api;

import com.tourism.entity.Scenic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("scenicApi")
@RestController
@RequestMapping("/api/scenic")
public class ScenicController {


	@GetMapping("{areaName}")
	@ApiOperation(value = "根据地区名称获取当地热门景区信息",notes = "")
	@ApiImplicitParam(name = "areaName",value = "地区名称",required = true,dataType = "String",paramType = "path")
	public ResponseEntity<List<Scenic>> getScenicTop(@PathVariable String areaName){
		//TODO
		return null;
	}

	@GetMapping("{areaName}/key/{key}")
	@ApiOperation(value = "根据关键词查询某地景区信息")
	@ApiImplicitParam(name = "areaName",value = "地区名称",required = true,dataType = "String",paramType = "path")
	public ResponseEntity<Scenic> getScenicByKey(@PathVariable String areaName,@PathVariable String key){
		//TODO
		return null;
	}

}
