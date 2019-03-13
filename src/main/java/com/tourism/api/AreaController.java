package com.tourism.api;

import com.tourism.entity.Area;
import com.tourism.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("areaApi")
@RestController
@RequestMapping("/api/area")
public class AreaController {

	private AreaService areaService;

	@Autowired
	public AreaController(AreaService areaService) {
		Assert.notNull(areaService,areaService.getClass()+"areaService in "+this.getClass()+" is null");
		this.areaService = areaService;
	}

	@GetMapping("/{areaName}")
	@ApiOperation(value = "根据地区名称获取地区信息")
	@ApiImplicitParam(paramType = "path",name = "areaName",value = "地名",required = true,dataType = "String")
	public ResponseEntity<Area> getAreaByPhone(@PathVariable String areaName){
		return ResponseEntity.ok().build();
	}

}
