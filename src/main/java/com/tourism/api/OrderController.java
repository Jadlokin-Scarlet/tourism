package com.tourism.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.tourism.entity.Business;
import com.tourism.entity.DaoDto.Trip;
import com.tourism.entity.deal.OrderDetail;
import com.tourism.service.OrderService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Controller
@Api("UserTripApi")
@RequestMapping(value = "/api/order",produces = "application/json")
@Validated
@Slf4j
//@JsonView(OrderController.OrderAndBusinessDto.class)
public class OrderController {

//	interface OrderAndBusinessDto extends Trip.OrderDto, Business.BusinessBaseDto {}

	private OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("")
	@ApiOperation("获得订单列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page",value = "第几页",defaultValue = "1",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "pageSize",value = "每页长度",defaultValue = "10",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "dealName",value = "商品名称",defaultValue = "桔子",dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "dealType",value = "商品类型",defaultValue = "hotel",dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "deliverType",value = "发货方式",defaultValue = "电子票",dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "deliverState",value = "发货状态",defaultValue = "已发货",dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "startDate",value = "下单时间下限",defaultValue = "2019-04-01 12:29:35",dataType = "Date",paramType = "query"),
			@ApiImplicitParam(name = "endDate",value = "下单时间上限",defaultValue = "2019-04-20 12:29:35",dataType = "Date",paramType = "query"),
			@ApiImplicitParam(name = "userName",value = "用户名称",defaultValue = "一",dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "userId",value = "用户id",defaultValue = "1",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "phone",value = "手机号",defaultValue = "11111111111",dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "ticketBusiness",value = "票务名称",defaultValue = "二",dataType = "String",paramType = "query"),
	})
	public ResponseEntity<List<OrderDetail>> getAllOrderByKey(
			@RequestParam(required = false,defaultValue = "1")@Min(value = 1,message = "page应为正数") Integer page,
			@RequestParam(required = false,defaultValue = "10")@Min(value = 1,message = "pageSize应为正数") Integer pageSize,
			@RequestParam(required = false,defaultValue = "")@NotNull String dealName,
			@RequestParam(required = false,defaultValue = "")@NotNull String dealType,
			@RequestParam(required = false,defaultValue = "")@NotNull String deliverType,
			@RequestParam(required = false,defaultValue = "")@NotNull String deliverState,
			@RequestParam(required = false,defaultValue = "1900-01-01 00:00:00")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
			@RequestParam(required = false,defaultValue = "2050-01-01 00:00:00")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate,
			@RequestParam(required = false,defaultValue = "")@NotNull String userName,
			@RequestParam(required = false,defaultValue = "0") Integer userId,
			@RequestParam(required = false,defaultValue = "")@NotNull String phone,
			@RequestParam(required = false,defaultValue = "")@NotNull String ticketBusiness
	){
		log.warn(userId.toString());
		List<OrderDetail> tripDetails = orderService.getAllOrderByKey(dealName,dealType,deliverType,deliverState,startDate,endDate,userName,userId,phone,ticketBusiness,page,pageSize);
		return ResponseEntity.ok(tripDetails);
	}

}
