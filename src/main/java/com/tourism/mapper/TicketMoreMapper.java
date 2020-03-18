package com.tourism.mapper;

import com.tourism.entity.DaoDto.TicketMore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketMoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketMore record);

    int insertSelective(TicketMore record);

    TicketMore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketMore record);

    int updateByPrimaryKey(TicketMore record);

    List<TicketMore> selectByTicketId(Integer hotelId);
}