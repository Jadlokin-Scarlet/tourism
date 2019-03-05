package com.tourism.mapper;

import com.tourism.entity.Deal;

public interface DealMapper {
    int deleteByPrimaryKey(Integer dealId);

    int insert(Deal record);

    int insertSelective(Deal record);

    Deal selectByPrimaryKey(Integer dealId);

    int updateByPrimaryKeySelective(Deal record);

    int updateByPrimaryKey(Deal record);
}