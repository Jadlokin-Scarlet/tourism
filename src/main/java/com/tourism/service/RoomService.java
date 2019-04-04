package com.tourism.service;

import com.tourism.entity.business.Hotel;
import com.tourism.entity.deal.Room;
import com.tourism.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<Room> createOrUpdateHotels(List<Room> rooms) {
		rooms.forEach(room-> {
			if (room.getId() == 0) {
				roomMapper.insertSelective(room);
			} else {
				roomMapper.updateByPrimaryKeySelective(room);
			}
		});
		return rooms.stream().map(room -> roomMapper.selectByPrimaryKey(room.getId())).collect(Collectors.toList());
	}

	public Integer deleteRoomById(Integer roomId) {
		return 1-roomMapper.deleteByPrimaryKey(roomId);
	}
}
