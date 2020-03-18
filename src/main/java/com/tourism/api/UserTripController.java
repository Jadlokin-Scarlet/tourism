package com.tourism.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.tourism.entity.Business;
import com.tourism.entity.DaoDto.Trip;
import com.tourism.entity.DaoDto.TripDetail;
import com.tourism.entity.business.Order;
import com.tourism.service.UserTripService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

@Controller
@Api(value = "UserTripApi",produces = "application/json")
@RequestMapping(value = "/api/user/{userId}/trip",produces = "application/json")
@Validated
@Slf4j
//@JsonView(UserTripController.TripAndBusinessDto.class)
public class UserTripController {

//	interface TripAndBusinessDto extends Trip.TripDto,Business.BusinessBaseDto {}

	private UserTripService userTripService;

	@Autowired
	public UserTripController(UserTripService userTripService) {
		this.userTripService = userTripService;
	}

	@GetMapping("")
	@ApiOperation("获取用户的所有历史路线")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType = "path"),
			@ApiImplicitParam(name = "page", value = "第几页", defaultValue = "1", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pageSize", value = "每页长度", defaultValue = "10", dataType = "int", paramType = "query")
	})
	public ResponseEntity<List<Order>> getUserAllTrip(
			@PathVariable@Min(0) Integer userId,
			@RequestParam(required = false,defaultValue = "1")@Min(value = 1,message = "page应为正数") Integer page,
			@RequestParam(required = false,defaultValue = "10")@Min(value = 1,message = "pageSize应为正数") Integer pageSize
	){
		return ResponseEntity.ok(userTripService.getTripByKey(page,pageSize,userId));
	}

	@GetMapping(value = "/nowTrip")
	@ApiOperation("获取用户当前行程")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "int",paramType = "path"),
	})
	public ResponseEntity<Order> getUserTrip(@PathVariable@Min(1) Integer userId){
		Order userTrip = userTripService.getUserTrip(userId);
		return ResponseEntity.ok(userTrip);
	}

	@PostMapping("/nowTrip/trip/{tripId}/useTime/{useTime}")
	@ApiOperation("添加路线至行程")
//	@JsonView(UserTripController.TripAndBusinessDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "int",paramType = "path"),
			@ApiImplicitParam(name = "tripId",value = "路线id",required = true,dataType = "int",paramType = "path"),
			@ApiImplicitParam(name = "useTime",value = "出游时间",required = true,dataType = "Date",paramType = "path")
	})
	public ResponseEntity<Order> setUserTrip(
			@PathVariable@Min(1) Integer userId,
			@PathVariable@Min(1) int tripId,
			@PathVariable@DateTimeFormat(pattern = "yyyy-MM-dd") Date useTime
	){
//		log.warn(userId+" choose "+tripId);
		return ResponseEntity.ok(userTripService.changeTripToUserTrip(userId,tripId,useTime));
	}

	@DeleteMapping("/nowTrip")
	@ApiOperation("清空行程")
	public ResponseEntity<Integer> deleteUserTrip(
			@PathVariable@Min(1) Integer userId
	){
		Integer res = userTripService.deleteUserTrip(userId);
		return ResponseEntity.ok(res);
	}

	@PostMapping(value = "/nowTrip/tripItem/{businessType}/{businessId}/{dealId}/{useTime}",produces = "application/json")
	@ApiOperation(value = "添加行程条目",produces = "application/json")
	public ResponseEntity<Order> addItemToUserTrip(
			@PathVariable@Min(1) Integer userId,
			@PathVariable String businessType,
			@PathVariable@Min(1) Integer businessId,
			@PathVariable@Min(1) Integer dealId,
			@PathVariable@DateTimeFormat(pattern = "yyyy-MM-dd") Date useTime
	){
		Order order = userTripService.addTripItemToUserTrip(userId, businessType, businessId, dealId, useTime);
		return ResponseEntity.ok(order);
	}

	@DeleteMapping("/nowTrip/tripItem/{tripItemId}")
	@ApiOperation("删除行程条目")
	public ResponseEntity<Order> deleteItemToUserTrip(
			@PathVariable Integer userId,
			@PathVariable Integer tripItemId
	){
		Order order = userTripService.deleteItemToUserTrip(userId, tripItemId);
		return ResponseEntity.ok(order);
	}



}
