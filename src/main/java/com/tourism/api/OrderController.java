package com.tourism.api;

import com.tourism.entity.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Api("OrderApi")
@RequestMapping("/api/user/{userId}/order")
public class OrderController {

	@GetMapping("")
	@ApiOperation(value = "获取用户的所有订单",notes = "是所有哦")
	@ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "Integer",paramType = "path")
	public ResponseEntity<List<Order>> getUserAllOrder(){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping(value = "?orderType={orderType}",params = "orderType")
	@ApiOperation("获取用户某一种类的订单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "Integer",paramType = "path"),
		@ApiImplicitParam(name = "orderType",value = "订单种类",required = true,dataType = "String",paramType = "path")
	})
	public ResponseEntity<List<Order>> getUserOrderByType(){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}



}
