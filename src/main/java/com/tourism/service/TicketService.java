package com.tourism.service;

import com.tourism.entity.deal.Ticket;
import com.tourism.entity.deal.TicketEveryDay;
import com.tourism.mapper.TicketMapper;
import com.tourism.mapper.TicketMoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
	private TicketMapper ticketMapper;
	private TicketMoreMapper ticketMoreMapper;

	@Autowired
	public TicketService(TicketMapper ticketMapper, TicketMoreMapper ticketMoreMapper) {
		this.ticketMapper = ticketMapper;
		this.ticketMoreMapper = ticketMoreMapper;
	}

	public List<Ticket> getAllTicketByScenicId(Integer scenicId) {
		List<Ticket> tickets = ticketMapper.selectByScenicId(scenicId);
		tickets.forEach(ticket ->
				ticket.setTimes(
						ticketMoreMapper.selectByTicketId(ticket.getId()).stream().map(
								ticketMore -> new TicketEveryDay(ticketMore.getUseTime(),ticketMore.getPrice(),ticketMore.getBalance())
						).collect(Collectors.toList())
				)
		);
		return tickets;
	}
}
