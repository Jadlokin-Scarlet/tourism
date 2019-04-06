package com.tourism.service;

import com.tourism.entity.business.Hotel;
import com.tourism.entity.deal.Room;
import com.tourism.mapper.RoomMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoomService {

	private RoomMapper roomMapper;

	@Autowired
	public RoomService(RoomMapper roomMapper) {
		this.roomMapper = roomMapper;
	}
	@Transactional
	public List<Room> getAllRoomByHotelId(Integer hotelId){
		return roomMapper.selectByHotelId(hotelId);
	}
	@Transactional
	public List<Room> createOrUpdateHotels(List<Room> rooms) {
		log.warn(rooms.toString());
		rooms.forEach(room-> {
			room.setCreateTime(null);
			room.setUpdateTime(new Date());
			if (room.getId() == 0) {
				roomMapper.insertSelective(room);
			} else {
				roomMapper.updateByPrimaryKeySelective(room);
			}
		});
		return rooms.stream().map(room -> roomMapper.selectByPrimaryKey(room.getId())).collect(Collectors.toList());
	}
	@Transactional
	public Integer deleteRoomById(Integer roomId) {
		return 1-roomMapper.deleteByPrimaryKey(roomId);
	}
}
