package com.tourism.api.business;

import com.tourism.entity.business.Restaurant;
import com.tourism.entity.business.Restaurant;
import com.tourism.exception.ServletRequestOutOfBoundsException;
import com.tourism.service.RestaurantService;
import com.tourism.service.RestaurantService;
import com.tourism.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

	@GetMapping(value = "",produces = "application/json")
	@ApiOperation(value = "查询餐饮店信息列表",notes = "可选分页参数page和pageSize,fuzzyKey",produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page",value = "第几页",defaultValue = "1",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "pageSize",value = "每页长度",defaultValue = "10",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "sortKey",value = "排序的列",defaultValue = "score",dataType = "String",paramType = "query"),
	})
	public ResponseEntity<List<Restaurant>> getRestaurantByKey(
			@RequestParam(required = false,defaultValue = "1")@Min(value = 1,message = "page应为正数") Integer page,
			@RequestParam(required = false,defaultValue = "10")@Min(value = 1,message = "pageSize应为正数") Integer pageSize,
			@RequestParam(required = false,defaultValue = "score")@NotBlank String sortKey
	) throws ServletRequestOutOfBoundsException {
		List<Restaurant> restaurants = restaurantService.getRestaurantsByKey(page, pageSize,sortKey);
		return ResponseEntity.ok(restaurants);
	}


	@GetMapping("/{restaurantId}")
	@ApiOperation("根据餐饮店id查询单个餐饮店")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "restaurantId", value = "餐饮店id", required = true, dataType = "int", paramType = "path")
	})
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable@Min(1) Integer restaurantId){
		return ResponseEntity.ok(restaurantService.getRestaurantById(restaurantId));
	}

	@PostMapping(value = "",produces = "application/json")
	@ApiOperation(value = "新建或修改餐饮店",produces = "application/json")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "restaurant",value = "餐饮店", required = true,dataType = "Restaurant",paramType = "body"),
//			@ApiImplicitParam(name = "name",value = "名字", required = true,dataType = "String",paramType = "query"),
//			@ApiImplicitParam(name = "briefIntroduce",value = "简介", required = true,dataType = "String",paramType = "query"),
//			@ApiImplicitParam(name = "address",value = "地址", required = true,dataType = "String",paramType = "query")
//	})
	public ResponseEntity<Restaurant> createOrUpdateRestaurant(
			@RequestBody @NotNull Restaurant restaurant
	){
		return ResponseEntity.ok(restaurantService.createOrUpdateRestaurant(restaurant));
	}

	@DeleteMapping("/{restaurantId}")
	@ApiOperation("删除餐饮店 by id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "restaurantId",value = "餐饮店id",required = true,dataType = "int",paramType = "path"),
	})
	public ResponseEntity<Integer> deleteScenic(@PathVariable@Min(1) Integer restaurantId){
		return ResponseEntity.ok(restaurantService.deleteScenic(restaurantId));
	}



//	@GetMapping("")
//	@ApiOperation("获取热门餐馆列表信息, 可选筛选参数type, 可选分页参数")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "page",value = "第几页",defaultValue = "1",dataType = "int",paramType = "query"),
//			@ApiImplicitParam(name = "pageSize",value = "每页长度",defaultValue = "10",dataType = "int",paramType = "query"),
//			@ApiImplicitParam(name = "sortKey",value = "排序的列",defaultValue = "score",dataType = "String",paramType = "query"),
//	})
//	public ResponseEntity<List<Restaurant>> getRestaurantServiceHotByPage(
//			@RequestParam(required = false,defaultValue = "1")@Min(value = 1,message = "page应为正数") Integer page,
//			@RequestParam(required = false,defaultValue = "10")@Min(value = 1,message = "pageSize应为正数") Integer pageSize,
//			@RequestParam(required = false,defaultValue = "score")@NotBlank String sortKey
//	){
//		return ResponseEntity.ok(restaurantService.getRestaurantServiceHotByPage(page,pageSize,sortKey));
//	}
//
//	@GetMapping("{restaurantId}")
//	@ApiOperation("查询景区 by id")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "restaurantId",value = "餐馆id",required = true,dataType = "int",paramType = "path"),
//	})
//	public ResponseEntity<Restaurant> getScenicFuzzy(@PathVariable @Min(1) Integer restaurantId){
//		return ResponseEntity.ok(restaurantService.getScenicById(restaurantId));
//	}
}
