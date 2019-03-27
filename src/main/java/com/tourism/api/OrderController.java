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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Api("OrderApi")
@RequestMapping("/api/user/{userId}/order")
public class OrderController {

	@GetMapping("")
	@ApiOperation(value = "获取用户的所有订单",notes = "是所有哦")
	@ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "int",paramType = "path")
	public ResponseEntity<List<Order>> getUserAllOrder(@PathVariable Integer userId){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping(value = "",params = "orderType")
	@ApiOperation(value = "获取用户某一种类的订单",notes = "需要参数orderType")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "int",paramType = "path"),
		@ApiImplicitParam(name = "orderType",value = "订单种类",required = true,dataType = "String",paramType = "query")
	})
	public ResponseEntity<List<Order>> getUserOrderByType(@PathVariable Integer userId,@PathVariable String orderType){
		//TODO
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}



}
