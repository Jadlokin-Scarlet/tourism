package com.tourism.api.deal;

import com.tourism.entity.deal.Ticket;
import com.tourism.entity.deal.Ticket;
import com.tourism.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@Api("TicketApi")
@RequestMapping("api/scenic/{scenicId}/ticket")
@Validated
public class TicketController {

	private TicketService ticketService;

	@Autowired
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@GetMapping("")
	@ApiOperation("根据景区id获取门票列表")
	@ApiImplicitParam(name = "scenicId", value = "景区id", required = true, dataType = "int", paramType = "path")
	public ResponseEntity<List<Ticket>> getAllTicketByHotelId(@PathVariable @Min(1) Integer scenicId){
		return ResponseEntity.ok(ticketService.getAllTicketByScenicId(scenicId));
	}

	@PostMapping(value = "",produces = "application/json")
	@ApiOperation(value = "批量新建或修改门票信息",produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "scenicId", value = "景区id", required = true, dataType = "int", paramType = "path"),
		@ApiImplicitParam(name = "tickets",value = "门票列表",dataTypeClass = Ticket.class,paramType = "body",allowMultiple=true)
	})
	public ResponseEntity<List<Ticket>> createOrUpdateHotel(
			@PathVariable@Min(0) Integer scenicId,
			@RequestBody@NotNull List<Ticket> tickets
	){
		if(tickets.isEmpty())return ResponseEntity.ok(tickets);
		return ResponseEntity.ok(ticketService.createOrUpdateTickets(scenicId,tickets));
	}

	@DeleteMapping("/{ticketId}")
	@ApiOperation("删除门票 by id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "scenicId", value = "景区id", required = true, dataType = "int", paramType = "path"),
			@ApiImplicitParam(name = "ticketId",value = "景区id",required = true,dataType = "int",paramType = "path"),
	})
	public ResponseEntity<Integer> deleteScenic(
			@PathVariable@Min(0) Integer scenicId,
			@PathVariable@Min(1) Integer ticketId
	){
		return ResponseEntity.ok(ticketService.deleteTicketById(ticketId));
	}

}
