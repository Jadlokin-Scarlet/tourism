package com.tourism.api.business;

import com.tourism.entity.business.Restaurant;
import com.tourism.service.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller
@Api("RestaurantApi")
@RequestMapping("api/restaurant")
@Validated
@Slf4j
public class RestaurantController {

	private RestaurantService restaurantService;

	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@GetMapping("")
	@ApiOperation("获取热门餐馆列表信息, 可选筛选参数type, 可选分页参数")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page",value = "第几页",defaultValue = "1",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "pageSize",value = "每页长度",defaultValue = "10",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "sortKey",value = "排序的列",defaultValue = "score",dataType = "String",paramType = "query"),
	})
	public ResponseEntity<List<Restaurant>> getRestaurantServiceHotByPage(
			@RequestParam(required = false,defaultValue = "1")@Min(value = 1,message = "page应为正数") Integer page,
			@RequestParam(required = false,defaultValue = "10")@Min(value = 1,message = "pageSize应为正数") Integer pageSize,
			@RequestParam(required = false,defaultValue = "score")@NotBlank String sortKey
	){
		return ResponseEntity.ok(restaurantService.getRestaurantServiceHotByPage(page,pageSize,sortKey));
	}

	@GetMapping("{restaurantId}")
	@ApiOperation("查询景区 by id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "restaurantId",value = "餐馆id",required = true,dataType = "int",paramType = "path"),
	})
	public ResponseEntity<Restaurant> getScenicFuzzy(@PathVariable @Min(1) Integer restaurantId){
		return ResponseEntity.ok(restaurantService.getScenicById(restaurantId));
	}
}
