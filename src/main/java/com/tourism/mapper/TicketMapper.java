package com.tourism.mapper;

import com.tourism.entity.deal.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    Ticket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);

	List<Ticket> selectByScenicId(Integer scenicId);
}