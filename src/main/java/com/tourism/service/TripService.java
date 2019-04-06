package com.tourism.service;

import com.tourism.entity.Business;
import com.tourism.entity.DaoDto.Trip;
import com.tourism.entity.DaoDto.TripDetail;
import com.tourism.mapper.ScenicMapper;
import com.tourism.mapper.TripDetailMapper;
import com.tourism.mapper.TripMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class TripService {
	private TripMapper tripMapper;
	private TripDetailMapper tripDetailMapper;

	@Autowired
	public TripService(TripMapper tripMapper, TripDetailMapper tripDetailMapper) {
		this.tripMapper = tripMapper;
		this.tripDetailMapper = tripDetailMapper;
	}
	@Transactional
	public List<Trip> getTripByKey(Integer page, Integer pageSize, String fuzzyKey, String sortKey) {
		List<Trip> trips = tripMapper.selectBySelectiveAndPage(fuzzyKey, sortKey, page, pageSize);
		trips.forEach(trip ->{
			trip.setTripItems(tripDetailMapper.selectByTripId(trip.getId()));
			trip.getTripItems().forEach(tripDetail->
					tripDetail.setBusiness(new Business())
			);
		});
		return trips;
	}
	@Transactional
	public Trip getTripById(Integer tripId) {
		Trip trip = tripMapper.selectByPrimaryKey(tripId);
		List<TripDetail> tripDetails = tripDetailMapper.selectByTripId(tripId);
		if(tripDetails.isEmpty()){
			tripDetails.add(new TripDetail());
		}
		trip.setTripItems(tripDetails);
		trip.getTripItems().forEach(tripDetail->
			tripDetail.setBusiness(new Business())
		);
		return trip;
	}
	@Transactional
	public Trip createOrUpdateTrip(Trip trip) {
		if(trip.getId() == 0){
			tripMapper.insertSelective(trip);
			trip.getTripItems().forEach(tripDetail -> {
				tripDetail.setTripId(trip.getId());
			});
		}else {
			tripMapper.updateByPrimaryKeySelective(trip);
		}
		deleteAndUpdateTripDetail(trip);
		return getTripById(trip.getId());
	}
	@Transactional
	public void deleteAndUpdateTripDetail(Trip trip){
		deleteTripDetail(trip.getId());
		trip.getTripItems().sort(Comparator.comparing(TripDetail::getUseTime));
		trip.getTripItems().forEach(tripDetail ->
			tripDetailMapper.insertSelective(tripDetail)
		);
		trip.setTripItems(tripDetailMapper.selectByTripId(trip.getId()));
	}

	@Transactional
	public Integer deleteTripDetail(Integer tripId){
		List<TripDetail> tripDetails = tripDetailMapper.selectByTripId(tripId);
		tripDetails.forEach(tripDetail ->
			tripDetailMapper.deleteByPrimaryKey(tripDetail.getId())
		);
		return 0;
	}
	@Transactional
	public Integer deleteTripById(Integer tripId) {
		Integer tripDetailFlag = deleteTripDetail(tripId);
		int tripFlag = 1-tripMapper.deleteByPrimaryKey(tripId);
		return tripDetailFlag+tripFlag;
	}
}
