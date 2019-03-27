package com.tourism.service;

import com.tourism.entity.deal.Ticket;
import com.tourism.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
	private TicketMapper ticketMapper;

	@Autowired
	public TicketService(TicketMapper ticketMapper) {
		this.ticketMapper = ticketMapper;
	}

	public List<Ticket> getAllTicketByScenicId(Integer scenicId) {
		return ticketMapper.selectByScenicId(scenicId);
	}
}
