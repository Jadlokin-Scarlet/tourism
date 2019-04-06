package com.tourism.api.deal;

import com.tourism.entity.business.Hotel;
import com.tourism.entity.deal.Room;
import com.tourism.service.RoomService;
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
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@Api("RoomApi")
@RequestMapping("api/hotel/{hotelId}/room")
@Validated
@Slf4j
public class RoomController {

	private RoomService roomService;

	@Autowired
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}

	@GetMapping("")
	@ApiOperation("根据酒店id获取房间列表")
	@ApiImplicitParam(name = "hotelId", value = "酒店id", required = true, dataType = "int", paramType = "path")
	public ResponseEntity<List<Room>> getAllRoomByHotelId(@PathVariable@Min(1) Integer hotelId){
		return ResponseEntity.ok(roomService.getAllRoomByHotelId(hotelId));
	}

	@PostMapping(value = "",produces = "application/json")
	@ApiOperation(value = "批量新建或修改酒店",produces = "application/json")
	public ResponseEntity<List<Room>> createOrUpdateHotel(@PathVariable@Min(0) Integer hotelId,@RequestBody @NotNull List<Room> rooms){
		log.debug(rooms.toString());
		rooms.forEach(room -> room.setHotelId(hotelId));
		return ResponseEntity.ok(roomService.createOrUpdateHotels(rooms));
	}

	@DeleteMapping("/{roomId}")
	@ApiOperation("删除房间 by id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "roomId",value = "景区id",required = true,dataType = "int",paramType = "path"),
	})
	public ResponseEntity<Integer> deleteScenic(@PathVariable@Min(1) Integer roomId){
		return ResponseEntity.ok(roomService.deleteRoomById(roomId));
	}

}