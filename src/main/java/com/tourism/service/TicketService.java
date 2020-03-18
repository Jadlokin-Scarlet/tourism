package com.tourism.service;

import com.tourism.entity.DaoDto.TicketMore;
import com.tourism.entity.business.Scenic;
import com.tourism.entity.deal.Ticket;
import com.tourism.entity.deal.TicketEveryDay;
import com.tourism.mapper.ScenicMapper;
import com.tourism.mapper.TicketMapper;
import com.tourism.mapper.TicketMoreMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TicketService {
	private TicketMapper ticketMapper;
	private TicketMoreMapper ticketMoreMapper;
	private ScenicMapper scenicMapper;
	@Autowired
	public TicketService(TicketMapper ticketMapper, TicketMoreMapper ticketMoreMapper, ScenicMapper scenicMapper) {
		this.ticketMapper = ticketMapper;
		this.ticketMoreMapper = ticketMoreMapper;
		this.scenicMapper = scenicMapper;
	}
	@Transactional
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
	@Transactional
	public List<Ticket> createOrUpdateTickets(Integer scenicId,List<Ticket> tickets) {
		log.warn(tickets.toString());
		deleteAllTicket(scenicId);
		tickets.forEach(ticket-> {
			ticket.setScenicId(scenicId);
			if (ticket.getId() != 0) {
				ticket.setId(0);
			}
			ticketMapper.insertSelective(ticket);
			ticket.getTimes().stream()
					.map(ticketTime -> new TicketMore(0,ticket.getId(),ticketTime.getUseTime(),ticketTime.getPrice(),ticketTime.getBalance()))
					.forEach(ticketMore -> ticketMoreMapper.insertSelective(ticketMore));

		});
		tickets = getAllTicketByScenicId(scenicId);
		Scenic scenic = scenicMapper.selectByPrimaryKey(scenicId);
		int moneyMin = tickets.stream()
				.mapToInt(Ticket::getPrice)
				.min().orElse(0);
		if(scenic.getMoneyMin()<moneyMin){
			scenic.setMoneyMin(moneyMin);
			scenicMapper.updateByPrimaryKeySelective(scenic);
		}
		log.warn(tickets.toString());
		return tickets;
	}
	@Transactional
	public Integer deleteTicketById(Integer ticketId) {
		ticketMoreMapper.selectByTicketId(ticketId).stream()
				.map(TicketMore::getId)
				.forEach(ticketMoreId -> ticketMoreMapper.deleteByPrimaryKey(ticketMoreId));
		ticketMapper.deleteByPrimaryKey(ticketId);
		return 0;
	}

	@Transactional
	public void deleteAllTicket(Integer scenicId){
		List<Ticket> tickets = getAllTicketByScenicId(scenicId);
		tickets.stream()
				.map(ticket -> ticketMoreMapper.selectByTicketId(ticket.getId()))
				.forEach(ticketMores -> ticketMores.forEach(
						ticketMore -> ticketMoreMapper.deleteByPrimaryKey(ticketMore.getId())
				));
		tickets.forEach(ticket -> ticketMapper.deleteByPrimaryKey(ticket.getId()));

	}

}
