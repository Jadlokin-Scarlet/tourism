package com.tourism.api.business;

import com.tourism.entity.business.Hotel;
import com.tourism.entity.deal.Room;
import com.tourism.exception.ServletRequestOutOfBoundsException;
import com.tourism.service.HotelService;
import com.tourism.util.ExceptionUtil;
import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.*;
import java.util.List;

@Controller
@Api(value = "HotelApi",produces = "application/json")
@RequestMapping(value = "api/hotel",produces = "application/json")
@Validated
@Slf4j
public class HotelController {

	private HotelService hotelService;

	@Autowired
	public HotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@GetMapping(value = "",produces = "application/json")
	@ApiOperation(value = "查询酒店信息列表",notes = "可选分页参数page和pageSize,fuzzyKey,money,lever",produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page",value = "第几页",defaultValue = "1",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "pageSize",value = "每页长度",defaultValue = "10",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "fuzzyKey",value = "模糊查询关键词",defaultValue = "杭州",dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "sortKey",value = "排序的列",defaultValue = "score",dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "moneyMin",value = "价格下限",defaultValue = "1",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "moneyMax",value = "价格上限",defaultValue = "1000000000",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "leverList",value = "星级列表",defaultValue = "1,2,3,4,5",dataType = "int",paramType = "query",type = "array",collectionFormat = "csv",allowMultiple=true),
//			@ApiImplicitParam(name = "leverMax",value = "星级上限",defaultValue = "5",dataType = "int",paramType = "query")
	})
	public ResponseEntity<List<Hotel>> getHotelByKey(
			@RequestParam(required = false,defaultValue = "1")@Min(value = 1,message = "page应为正数") Integer page,
			@RequestParam(required = false,defaultValue = "10")@Min(value = 1,message = "pageSize应为正数") Integer pageSize,
			@RequestParam(required = false,defaultValue = "")@NotNull String fuzzyKey,
			@RequestParam(required = false,defaultValue = "score")@NotBlank String sortKey,
			@RequestParam(required = false,defaultValue = "1")@Min(value = 0,message = "moneyMin应为正数") Integer moneyMin,
			@RequestParam(required = false,defaultValue = "1000000000") Integer moneyMax,
			@RequestParam(required = false,defaultValue = "1,2,3,4,5")@NotEmpty List<Integer> leverList
//			@RequestParam(required = false,defaultValue = "5")@Max(value = 5,message = "leverMax应小于等于5") Integer leverMax
	) throws ServletRequestOutOfBoundsException {
		ExceptionUtil.isMaxAreMax(moneyMin,moneyMax,"价格");
//		ExceptionUtil.isMaxAreMax(leverMin,leverMax,"星级");
		log.info(leverList.toString());
		List<Hotel> hotels = hotelService.getHotelsByKey(page, pageSize, fuzzyKey,sortKey, moneyMax, moneyMin, leverList);
		log.info(fuzzyKey+" "+hotels);
		return ResponseEntity.ok(hotels);
	}


	@GetMapping("/{hotelId}")
	@ApiOperation("根据酒店id查询单个酒店")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hotelId", value = "酒店id", required = true, dataType = "int", paramType = "path")
	})
	public ResponseEntity<Hotel> getHotelById(@PathVariable@Min(1) Integer hotelId){
		return ResponseEntity.ok(hotelService.getHotelById(hotelId));
	}

	@PostMapping(value = "",produces = "application/json")
	@ApiOperation(value = "新建或修改酒店",produces = "application/json")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "hotel",value = "酒店", required = true,dataType = "Hotel",paramType = "body"),
//			@ApiImplicitParam(name = "name",value = "名字", required = true,dataType = "String",paramType = "query"),
//			@ApiImplicitParam(name = "briefIntroduce",value = "简介", required = true,dataType = "String",paramType = "query"),
//			@ApiImplicitParam(name = "address",value = "地址", required = true,dataType = "String",paramType = "query")
//	})
	public ResponseEntity<Hotel> createOrUpdateHotel(@RequestBody @NotNull Hotel hotel){
		return ResponseEntity.ok(hotelService.createOrUpdateHotel(hotel));
	}

	@DeleteMapping("/{hotelId}")
	@ApiOperation("删除酒店 by id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "hotelId",value = "景区id",required = true,dataType = "int",paramType = "path"),
	})
	public ResponseEntity<Integer> deleteScenic(@PathVariable@Min(1) Integer hotelId){
		return ResponseEntity.ok(hotelService.deleteScenic(hotelId));
	}

}
