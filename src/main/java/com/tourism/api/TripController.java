package com.tourism.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.tourism.entity.Business;
import com.tourism.entity.DaoDto.Trip;
import com.tourism.entity.DaoDto.TripDetail;
import com.tourism.entity.Deal;
import com.tourism.entity.business.Hotel;
import com.tourism.exception.ServletRequestOutOfBoundsException;
import com.tourism.service.TripService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@Api(value = "TripApi",produces = "application/json")
@RequestMapping(value = "api/trip",produces = "application/json")
@Validated
@Slf4j
public class TripController {
	public interface TripAndBusinessDto extends Trip.TripDto,Business.BusinessBaseDto {}
	private TripService tripService;

	@Autowired
	public TripController(TripService tripService) {
		this.tripService = tripService;
	}

	@GetMapping(value = "",produces = "application/json")
	@JsonView(TripAndBusinessDto.class)
	@ApiOperation(value = "查询行程信息列表",notes = "可选分页参数page和pageSize,fuzzyKey",produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page",value = "第几页",defaultValue = "1",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "pageSize",value = "每页长度",defaultValue = "10",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "fuzzyKey",value = "模糊查询关键词",dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "sortKey",value = "排序的列",defaultValue = "id",dataType = "String",paramType = "query"),
	})
	public ResponseEntity<List<Trip>> getTripByKey(
			@RequestParam(required = false,defaultValue = "1")@Min(value = 1,message = "page应为正数") Integer page,
			@RequestParam(required = false,defaultValue = "10")@Min(value = 1,message = "pageSize应为正数") Integer pageSize,
			@RequestParam(required = false,defaultValue = "")@NotNull String fuzzyKey,
			@RequestParam(required = false,defaultValue = "id")@NotBlank String sortKey
	){
		return ResponseEntity.ok(tripService.getTripByKey(page,pageSize,fuzzyKey,sortKey));
	}

	@GetMapping("/{tripId}")
	@ApiModelProperty("查询行程 by id")
	@ApiImplicitParam(name = "tripId", value = "行程id", required = true, dataType = "int", paramType = "path")
	public ResponseEntity<Trip> getTripById(@PathVariable@Min(1) Integer tripId){
		Trip trip;
		try{
			trip = tripService.getTripById(tripId);
		}catch (NullPointerException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(trip);
	}

	@PostMapping("")
	@ApiOperation("新增或修改行程")
	public ResponseEntity<Trip> createOrUpdateTrip(@RequestBody@NotNull Trip trip){
		trip.setDelete(false);
		trip.getTripItems().forEach(tripDetail -> {
			if(trip.getId() !=0){
				tripDetail.setTripId(trip.getId());
			}
			tripDetail.setBusinessId(tripDetail.getBusiness().getId());
			tripDetail.setBusinessType(tripDetail.getBusiness().getType());
		});
		log.warn(trip.toString());
		Trip newTrip = tripService.createOrUpdateTrip(trip);
		return ResponseEntity.ok(newTrip);
	}

	@DeleteMapping("/{tripId}")
	@ApiOperation("删除行程 by id")
	@ApiImplicitParam(name = "tripId", value = "行程id", required = true, dataType = "int", paramType = "path")
	public ResponseEntity<Integer> deleteTripById(@PathVariable@Min(1) Integer tripId){
		Integer flag = tripService.deleteTripById(tripId);
		return ResponseEntity.ok(flag);
	}

}
