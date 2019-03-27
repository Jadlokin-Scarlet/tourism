package com.tourism.api.deal;

import com.tourism.entity.deal.Room;
import com.tourism.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Min;
import java.util.List;

@Controller
@Api("RoomApi")
@RequestMapping("api/hotel/{hotelId}/room")
@Validated
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

}