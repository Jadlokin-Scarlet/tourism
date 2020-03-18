package com.tourism.mapper;

import com.tourism.entity.DaoDto.TripDetail;
import com.tourism.entity.deal.Room;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TripDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TripDetail record);

    int insertSelective(TripDetail record);

    TripDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TripDetail record);

    int updateByPrimaryKey(TripDetail record);

    List<TripDetail> selectByTripId(Integer tripId);


}