package com.tourism.service;

import com.tourism.entity.deal.Room;
import com.tourism.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

	private RoomMapper roomMapper;

	@Autowired
	public RoomService(RoomMapper roomMapper) {
		this.roomMapper = roomMapper;
	}

	public List<Room> getAllRoomByHotelId(Integer hotelId){
		return roomMapper.selectByHotelId(hotelId);
	}

}
