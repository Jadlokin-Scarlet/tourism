package com.tourism.api.business;

import com.tourism.entity.business.Hotel;
import com.tourism.exception.ServletRequestOutOfBoundsException;
import com.tourism.service.HotelService;
import com.tourism.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@Api("HotelApi")
@RequestMapping("api/hotel")
@Validated
public class HotelController {

	private HotelService hotelService;

	@Autowired
	public HotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@GetMapping("")
	@ApiOperation(value = "查询酒店信息列表",notes = "可选分页参数page和pageSize,fuzzyKey,money,lever")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page",value = "第几页",defaultValue = "1",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "pageSize",value = "每页长度",defaultValue = "10",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "fuzzyKey",value = "模糊查询关键词",dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "moneyMin",value = "价格下限",defaultValue = "1",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "moneyMax",value = "价格上限",defaultValue = "1000000000",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "leverMin",value = "星级下限",defaultValue = "1",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "leverMax",value = "星级上限",defaultValue = "5",dataType = "int",paramType = "query")
	})
	public ResponseEntity<List<Hotel>> getHotelByKey(
			@RequestParam(required = false,defaultValue = "1")@Min(value = 1,message = "page应为正数") Integer page,
			@RequestParam(required = false,defaultValue = "10")@Min(value = 1,message = "pageSize应为正数") Integer pageSize,
			@RequestParam(required = false,defaultValue = "")@NotNull String fuzzyKey,
			@RequestParam(required = false,defaultValue = "1")@Min(value = 0,message = "moneyMin应为正数") Integer moneyMin,
			@RequestParam(required = false,defaultValue = "1000000000") Integer moneyMax,
			@RequestParam(required = false,defaultValue = "1")@Min(value = 1,message = "leverMin应大于等于1") Integer leverMin,
			@RequestParam(required = false,defaultValue = "5")@Max(value = 5,message = "leverMax应小于等于5") Integer leverMax
	) throws ServletRequestOutOfBoundsException {
		ExceptionUtil.isMaxAreMax(moneyMin,moneyMax,"价格");
		ExceptionUtil.isMaxAreMax(leverMin,leverMax,"星级");
		LoggerFactory.getLogger(HotelController.class).debug(fuzzyKey);
		return ResponseEntity.ok(hotelService.getHotelsByKey(page,pageSize,fuzzyKey,moneyMax,moneyMin,leverMax,leverMin));
	}


//	@GetMapping("/hotelName/{hotelName}")
//	@ApiOperation("根据酒店名查询单个酒店")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "areaName",value = "地名",required = true,dataType = "String",paramType = "path"),
//			@ApiImplicitParam(name = "hotelName",value = "酒店名称",required = true,dataType = "String",paramType = "path")
//	})
//	public ResponseEntity<HotelMapper> getHotelByName(@PathVariable String areaName,@PathVariable String hotelName){
//		//TODO
//		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
//	}

	@GetMapping("/{hotelId}")
	@ApiOperation("根据酒店id查询单个酒店")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hotelId", value = "酒店id", required = true, dataType = "int", paramType = "path")
	})
	public ResponseEntity<Hotel> getHotelById(@PathVariable@Min(1) Integer hotelId){
		return ResponseEntity.ok(hotelService.getHotelById(hotelId));
	}

}
