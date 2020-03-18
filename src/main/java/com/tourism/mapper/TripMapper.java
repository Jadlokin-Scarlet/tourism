package com.tourism.mapper;

import com.tourism.entity.DaoDto.Trip;
import com.tourism.entity.Deal;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TripMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Trip record);

	int insertSelective(Trip record);

	Trip selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Trip record);

	int updateByPrimaryKey(Trip record);

	List<Trip> selectBySelectiveAndPage(
			@Param("fuzzyKey") String fuzzyKey,
			@Param("sortKey") String sortKey,
			@Param("currPage")Integer page,
			@Param("pageSize")Integer pageSize);

//	List<Trip> selectByTime(
//			@Param("userId") Integer userId,
//			@Param("useTime") Date date);

//	Trip selectTheNew(
//			@Param("userTime") Integer userId
//	);
}