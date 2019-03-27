package com.tourism.api.deal;

import com.tourism.entity.deal.Room;
import com.tourism.entity.deal.Ticket;
import com.tourism.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Min;
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
	public ResponseEntity<List<Ticket>> getAllRoomByHotelId(@PathVariable @Min(1) Integer scenicId){
		return ResponseEntity.ok(ticketService.getAllTicketByScenicId(scenicId));
	}

}
