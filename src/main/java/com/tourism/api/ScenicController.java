package com.tourism.api;

import com.tourism.entity.Scenic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("scenicApi")
@RestController
@RequestMapping("/api/area/{areaName}/scenic")
public class ScenicController {

	@GetMapping("")
	@ApiOperation(value = "根据地区名称获取当地热门景区列表信息",notes = "")
	@ApiImplicitParam(name = "areaName",value = "地区名称",required = true,dataType = "String",paramType = "path")
	public ResponseEntity<List<Scenic>> getScenicTop(@PathVariable String areaName){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping(value = "?fuzzyKey={fuzzyKey}&number={number}",params = "fuzzyKey")
	@ApiOperation("模糊查询匹配的景区列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "fuzzyKey",value = "模糊查询关键字",required = true,dataType = "String",paramType = "path"),
			@ApiImplicitParam(name = "number",value = "查询数量",defaultValue = "10",dataType = "Integer",paramType = "path"),
			@ApiImplicitParam(name = "areaName",value = "地名",required = true,dataType = "String",paramType = "path")
	})
	public ResponseEntity<List<Scenic>> getScenicFuzzy(@PathVariable String areaName,@PathVariable String fuzzyKey,@PathVariable(required = false) Integer number){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}



}
