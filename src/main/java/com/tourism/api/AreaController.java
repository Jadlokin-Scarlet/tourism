package com.tourism.api;

import com.tourism.entity.Area;
import com.tourism.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api("areaApi")
@RestController
@RequestMapping("/api/area")
public class AreaController {

//	private AreaService areaService;
//
//	@Autowired
//	public AreaController(AreaService areaService) {
//		Assert.notNull(areaService,areaService.getClass()+" in "+this.getClass()+" is null");
////		Assert.notNull(areaService);
//		this.areaService = areaService;
//	}

	@GetMapping(value = "")
	@ApiOperation(value = "获取地区列表")
	public ResponseEntity<List<Area>> getAreaAll(){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping(value = "",params = "fuzzyKey")
	@ApiOperation(value = "模糊查询匹配的地区列表",notes = "需要参数fuzzyKey,可选参数number")
	@ApiImplicitParams ({
		@ApiImplicitParam(name = "fuzzyKey",value = "模糊查询关键字",required = true,dataType = "String",paramType = "query"),
		@ApiImplicitParam(name = "number",value = "查询数量",defaultValue = "10",dataType = "int",paramType = "query")
	})
	public ResponseEntity<List<Area>> getAreaByKey(
			@RequestParam String fuzzyKey,
			@RequestParam(required = false,defaultValue = "10") Integer number){
		//TODO
		System.out.println(number);
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping("/{areaName}")
	@ApiOperation(value = "根据地区名称获取地区信息")
	@ApiImplicitParam(name = "areaName",value = "地名",required = true,dataType = "String",paramType = "path")
	public ResponseEntity<Area> getAreaByPhone(@PathVariable String areaName){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping(value = "{areaName}/childArea")
	@ApiOperation("根据地区名称查询当热门地区")
	@ApiImplicitParam(name = "areaName",value = "地名",required = true,dataType = "String",paramType = "path")
	public ResponseEntity<List<Area>> getAreaByParentName(@PathVariable String areaName){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}
}
