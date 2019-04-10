package com.tourism.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.tourism.entity.Business;
import com.tourism.entity.DaoDto.Trip;
import com.tourism.entity.DaoDto.TripDetail;
import com.tourism.service.TripService;
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
@JsonView(UserTripController.TripAndBusinessDto.class)
public class UserTripController {

	interface TripAndBusinessDto extends Trip.TripDto,Business.BusinessBaseDto {}

	private TripService tripService;

	@Autowired
	public UserTripController(TripService tripService) {
		this.tripService = tripService;
	}

	@GetMapping("")
	@ApiOperation("获取用户的所有历史路线")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "int", paramType = "path"),
			@ApiImplicitParam(name = "page", value = "第几页", defaultValue = "1", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "pageSize", value = "每页长度", defaultValue = "10", dataType = "int", paramType = "query")
	})
	public ResponseEntity<List<Trip>> getUserAllTrip(
			@PathVariable@Min(0) Integer userId,
			@RequestParam(required = false,defaultValue = "1")@Min(value = 1,message = "page应为正数") Integer page,
			@RequestParam(required = false,defaultValue = "10")@Min(value = 1,message = "pageSize应为正数") Integer pageSize
	){
		return ResponseEntity.ok(tripService.getTripByKey(page,pageSize,"","id",userId));
	}

	@GetMapping(value = "/nowTrip")
	@ApiOperation("获取用户当前行程")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "int",paramType = "path"),
	})
	public ResponseEntity<Trip> getUserTrip(@PathVariable@Min(1) Integer userId){
		Trip trip = tripService.getUserTrip(userId);
		return ResponseEntity.ok(trip);
	}

	@PostMapping("/nowTrip/trip/{tripId}/useTime/{useTime}")
	@ApiOperation("添加路线至行程")
//	@JsonView(UserTripController.TripAndBusinessDto.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "int",paramType = "path"),
			@ApiImplicitParam(name = "tripId",value = "路线id",required = true,dataType = "int",paramType = "path"),
			@ApiImplicitParam(name = "useTime",value = "出游时间",required = true,dataType = "Date",paramType = "path")
	})
	public ResponseEntity<Trip> setUserTrip(
			@PathVariable@Min(1) Integer userId,
			@PathVariable@Min(1) int tripId,
			@PathVariable@DateTimeFormat(pattern = "yyyy-MM-dd") Date useTime
	){
//		log.warn(userId+" choose "+tripId);
		return ResponseEntity.ok(tripService.changeTripToUserTrip(userId,tripId,useTime));
	}

	@DeleteMapping("/nowTrip")
	@ApiOperation("清空行程")
	public ResponseEntity<Integer> deleteUserTrip(
			@PathVariable@Min(1) Integer userId
	){
		Integer res = tripService.deleteUserTrip(userId);
		return ResponseEntity.ok(res);
	}

	@PostMapping("/nowTrip/tripItem")
	@ApiOperation("添加行程条目")
	@JsonView(UserTripController.TripAndBusinessDto.class)
	public ResponseEntity<Trip> addItemToUserTrip(
			@PathVariable Integer userId,
			@PathVariable TripDetail tripItem
	){
		Trip trip = tripService.addTripItemToUserTrip(userId, tripItem);
		return ResponseEntity.ok(trip);
	}

	@DeleteMapping("/nowTrip/tripItem")
	@ApiOperation("删除行程条目")
	public ResponseEntity<Trip> deleteItemToUserTrip(
			@PathVariable Integer userId,
			@PathVariable Integer tripItemId
	){
		Trip trip = tripService.deleteItemToUserTrip(userId, tripItemId);
		return ResponseEntity.ok(trip);
	}



}
