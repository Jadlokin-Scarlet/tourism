package com.tourism.api.business;

import com.tourism.entity.business.Scenic;
import com.tourism.service.ScenicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api("scenicApi")
@RestController
@RequestMapping("/api/scenic")
public class ScenicController {

	ScenicService scenicService;

	@Autowired
	public ScenicController(ScenicService scenicService) {
		this.scenicService = scenicService;
	}

	@GetMapping("")
	@ApiOperation("获取热门景区列表信息, 可选筛选参数fuzzyKey, 可选分页参数")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page",value = "第几页",defaultValue = "1",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "pageSize",value = "每页长度",defaultValue = "10",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "fuzzyKey",value = "模糊查询关键词",dataType = "String",paramType = "query"),
	})
	public ResponseEntity<List<Scenic>> getScenicTop(
			@RequestParam(required = false,defaultValue = "1")@Min(value = 1,message = "page应为正数") Integer page,
			@RequestParam(required = false,defaultValue = "10")@Min(value = 1,message = "pageSize应为正数") Integer pageSize,
			@RequestParam(required = false,defaultValue = "")@NotNull String fuzzyKey
	){
		return ResponseEntity.ok(scenicService.getScenicByKey(page,pageSize,fuzzyKey));
	}

	@GetMapping("/{scenicId}")
	@ApiOperation("查询景区 by id")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "scenicId",value = "景区id",required = true,dataType = "int",paramType = "path"),
	})
	public ResponseEntity<Scenic> getScenicFuzzy(@PathVariable@Min(1) Integer scenicId){
		return ResponseEntity.ok(scenicService.getScenicById(scenicId));
	}



}
