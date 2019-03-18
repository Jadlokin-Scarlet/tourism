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
@RequestMapping("/api/scenic")
public class ScenicController {

	@GetMapping(value = "/list/{fuzzyKey}")
	@ApiOperation("模糊查询匹配的景区")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "fuzzyKey",value = "模糊查询关键字",required = true,dataType = "String",paramType = "path"),
			@ApiImplicitParam(name = "number",value = "查询数量",defaultValue = "10",dataType = "Integer",paramType = "query")
	})
	public ResponseEntity<List<Scenic>> getScenicAll(@PathVariable String fuzzyKey,@RequestParam(required = false,defaultValue = "10") Integer number){
		//TODO
//		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		return null;
	}

	@GetMapping("{areaName}")
	@ApiOperation(value = "根据地区名称获取当地热门景区信息",notes = "")
	@ApiImplicitParam(name = "areaName",value = "地区名称",required = true,dataType = "String",paramType = "path")
	public ResponseEntity<List<Scenic>> getScenicTop(@PathVariable String areaName){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping("{areaName}/key/{key}")
	@ApiOperation(value = "根据关键词查询某地景区信息")
	@ApiImplicitParam(name = "areaName",value = "地区名称",required = true,dataType = "String",paramType = "path")
	public ResponseEntity<Scenic> getScenicByKey(@PathVariable String areaName,@PathVariable String key){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

}
