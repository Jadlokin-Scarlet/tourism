package com.tourism.api.deal;

import com.tourism.entity.business.Restaurant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Api("RestaurantApi")
@RequestMapping("api/restaurant")
public class RestaurantController {

	@GetMapping("")
	@ApiOperation(value = "查询餐馆信息列表",notes = "可选分页参数page和pageSize,")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page",value = "第几页",defaultValue = "1",dataType = "int",paramType = "query"),
		@ApiImplicitParam(name = "pageSize",value = "每页数量",defaultValue = "10",dataType = "int",paramType = "query")
	})
	public ResponseEntity<List<Restaurant>> getRestaurantByPage(
			@RequestParam(required = false,defaultValue = "1") Integer page,
			@RequestParam(required = false,defaultValue = "10") Integer areaSize
//			@RequestParam(required = false,defaultValue = "") String foodType
	){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping("/restaurantName/{restaurantName}")
	@ApiOperation("根据餐馆名查询单个餐馆")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "areaName",value = "地名",required = true,dataType = "String",paramType = "path"),
			@ApiImplicitParam(name = "restaurantName",value = "餐馆名称",required = true,dataType = "String",paramType = "path")
	})
	public ResponseEntity<Restaurant> getRestaurantByName(@PathVariable String areaName,@PathVariable String restaurantName){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping("/{restaurantId}")
	@ApiOperation("根据餐馆id查询单个餐馆")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "areaName", value = "地名", required = true, dataType = "String", paramType = "path"),
			@ApiImplicitParam(name = "restaurantId", value = "餐馆id", required = true, dataType = "int", paramType = "path")
	})
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable String areaName,@PathVariable Integer restaurantId){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

}
