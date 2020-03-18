package com.tourism.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.tourism.entity.Business;
import com.tourism.entity.DaoDto.Trip;
import com.tourism.entity.DaoDto.TripDetail;
import com.tourism.entity.Deal;
import com.tourism.exception.EntityNotFoundException;
import com.tourism.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TripService {
	private TripMapper tripMapper;
	private TripDetailMapper tripDetailMapper;

	private HotelMapper hotelMapper;
	private ScenicMapper scenicMapper;
	private RestaurantMapper restaurantMapper;

	private RoomMapper roomMapper;
	private TicketMapper ticketMapper;

	@Autowired
	public TripService(TripMapper tripMapper, TripDetailMapper tripDetailMapper, HotelMapper hotelMapper, ScenicMapper scenicMapper, RestaurantMapper restaurantMapper, RoomMapper roomMapper, TicketMapper ticketMapper) {
		this.tripMapper = tripMapper;
		this.tripDetailMapper = tripDetailMapper;
		this.hotelMapper = hotelMapper;
		this.scenicMapper = scenicMapper;
		this.restaurantMapper = restaurantMapper;
		this.roomMapper = roomMapper;
		this.ticketMapper = ticketMapper;
	}

	public List<Trip> getTripByKey(Integer page, Integer pageSize, String fuzzyKey, String sortKey) {
		List<Trip> trips = tripMapper.selectBySelectiveAndPage(fuzzyKey, sortKey, page, pageSize);
		trips.forEach(trip -> {
			trip.setTripItems(tripDetailMapper.selectByTripId(trip.getId()));
			trip.getTripItems().forEach(tripDetail ->
					tripDetail.setBusiness(getBusiness(tripDetail.getBusinessType(),tripDetail.getBusinessId())));
		});
		return trips;
	}

	@Transactional
	public Trip getTripById(Integer tripId) throws NullPointerException {
		Trip trip = tripMapper.selectByPrimaryKey(tripId);
		log.warn(trip.toString());
		trip.setTripItems(tripDetailMapper.selectByTripId(tripId));
		trip.getTripItems().forEach(tripDetail ->
				tripDetail.setBusiness(getBusiness(tripDetail.getBusinessType(),tripDetail.getBusinessId())));
		return trip;
	}

//	@Transactional
//	public Trip getUserTrip(Integer userId) {
//		List<Trip> trips = tripMapper.selectByTime(userId, new Date());
//		if(trips.isEmpty()){
//			return new Trip();
//		}else if(trips.size() > 1){
//			throw new NullPointerException(trips.toString());
//		}
//		Trip trip = trips.get(0);
//		trip.setTripItems(tripDetailMapper.selectByTripId(trip.getId()));
//		trip.getTripItems().forEach(tripDetail ->
//				tripDetail.setBusiness(getBusiness(tripDetail.getBusinessType(),tripDetail.getBusinessId()))
//		);
//		return trip;
//	}

	@Transactional
	public Trip createOrUpdateTrip(Trip trip) {
		if (trip.getId() == 0) {
			tripMapper.insertSelective(trip);
			trip.getTripItems().forEach(tripDetail ->
				tripDetail.setTripId(trip.getId())
			);
		} else {
			tripMapper.updateByPrimaryKeySelective(trip);
		}
		deleteAndUpdateTripDetail(trip);
		return getTripById(trip.getId());
	}

	@Transactional
	public void deleteAndUpdateTripDetail(Trip trip) {
		deleteTripDetail(trip.getId());
		trip.getTripItems().sort(Comparator.comparing(TripDetail::getUseTime));
		trip.getTripItems().forEach(tripDetail ->
				tripDetailMapper.insertSelective(tripDetail));
		trip.setTripItems(tripDetailMapper.selectByTripId(trip.getId()));
		getTripById(trip.getId());
	}

	@Transactional
	public void deleteTripDetail(Integer tripId) {
		List<TripDetail> tripDetails = tripDetailMapper.selectByTripId(tripId);
		tripDetails.forEach(tripDetail ->
				tripDetailMapper.deleteByPrimaryKey(tripDetail.getId()));
	}

	@Transactional
	public Integer deleteTripById(Integer tripId) {
//		deleteTripDetail(tripId);
		Trip trip = getTripById(tripId);
		trip.setDelete(true);
		tripMapper.updateByPrimaryKeySelective(trip);
		return 0;
	}

//	@Transactional
//	public Trip changeTripToUserTrip(Integer userId, Integer tripId, Date date) {
//		Trip trip = getTripById(tripId);
//		trip.setUserId(userId);
//		trip.setId(0);
//		if(!trip.getTripItems().isEmpty()){
//			long dTime = date.getTime()-trip.getTripItems().get(0).getUseTime().getTime();
//			trip.getTripItems().forEach(tripDetail ->{
//				tripDetail.setId(0);
//				tripDetail.setTripId(trip.getId());
//				tripDetail.setUseTime(new Date(tripDetail.getUseTime().getTime()+dTime));
//			});
//		}
//		return createOrUpdateTrip(trip);
//	}
//	@Transactional
//	public Trip addTripItemToUserTrip(Integer userId, TripDetail tripItem) {
//		Trip trip = getUserTrip(userId);
//		trip.getTripItems().add(tripItem);
//		return deleteAndUpdateTripDetail(trip);
//	}
//
//	public Trip deleteItemToUserTrip(Integer userId, Integer tripItemId) {
//		tripDetailMapper.deleteByPrimaryKey(tripItemId);
//		return getUserTrip(userId);
//	}
//
//	public Integer deleteUserTrip(Integer userId) {
//		Trip trip = getUserTrip(userId);
//		deleteTripDetail(trip.getId());
//		return getUserTrip(userId).getTripItems().size();
//	}

	public Business getBusiness(String businessType,Integer businessId){
		Business business = null;
		switch (businessType) {
			case "scenic":
				business = scenicMapper.selectByPrimaryKey(businessId);
				break;
			case "hotel":
				business = hotelMapper.selectByPrimaryKey(businessId);
				break;
			case "restaurant":
				business = restaurantMapper.selectByPrimaryKey(businessId);
				break;
		}
		if(business == null){
			business = new Business();
		}
		return business;
	}

	public Deal getDeal(String businessType, Integer dealId){
		Deal deal = null;
		switch (businessType) {
			case "scenic":
				deal = ticketMapper.selectByPrimaryKey(dealId);
				break;
			case "hotel":
				deal = roomMapper.selectByPrimaryKey(dealId);
				break;
		}
		if(deal == null){
			deal = new Deal();
		}
		return deal;
	}

}