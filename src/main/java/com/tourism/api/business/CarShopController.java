package com.tourism.api.business;

import com.tourism.entity.business.CarShop;
import com.tourism.exception.ServletRequestOutOfBoundsException;
import com.tourism.service.CarShopService;
import com.tourism.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@Api(value = "CarShopApi",produces = "application/json")
@RequestMapping(value = "api/carShop",produces = "application/json")
@Validated
@Slf4j
public class CarShopController {

	private CarShopService carShopService;

	@Autowired
	public CarShopController(CarShopService carShopService) {
		this.carShopService = carShopService;
	}
	
	@GetMapping(value = "",produces = "application/json")
	@ApiOperation(value = "查询租车店信息列表",notes = "可选分页参数page和pageSize,fuzzyKey,money,lever",produces = "application/json")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page",value = "第几页",defaultValue = "1",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "pageSize",value = "每页长度",defaultValue = "10",dataType = "int",paramType = "query"),
			@ApiImplicitParam(name = "address",value = "取车地点",defaultValue = "杭州",dataType = "String",paramType = "query"),
			@ApiImplicitParam(name = "sortKey",value = "排序的列",defaultValue = "score",dataType = "String",paramType = "query"),
//			@ApiImplicitParam(name = "moneyMin",value = "价格下限",defaultValue = "0",dataType = "int",paramType = "query"),
//			@ApiImplicitParam(name = "moneyMax",value = "价格上限",defaultValue = "1000000000",dataType = "int",paramType = "query"),
//			@ApiImplicitParam(name = "leverList",value = "星级列表",defaultValue = "0,1,2,3,4,5",dataType = "int",paramType = "query",type = "array",collectionFormat = "csv",allowMultiple=true),
//			@ApiImplicitParam(name = "leverMax",value = "星级上限",defaultValue = "5",dataType = "int",paramType = "query")
	})
	public ResponseEntity<List<CarShop>> getCarShopByKey(
			@RequestParam(required = false,defaultValue = "1")@Min(value = 1,message = "page应为正数") Integer page,
			@RequestParam(required = false,defaultValue = "10")@Min(value = 1,message = "pageSize应为正数") Integer pageSize,
			@RequestParam(required = false,defaultValue = "")@NotNull String address,
			@RequestParam(required = false,defaultValue = "score")@NotBlank String sortKey
//			@RequestParam(required = false,defaultValue = "0")@Min(value = 0,message = "moneyMin应为正数") Integer moneyMin,
//			@RequestParam(required = false,defaultValue = "1000000000") Integer moneyMax,
//			@RequestParam(required = false,defaultValue = "0,1,2,3,4,5")@NotEmpty List<Integer> leverList
//			@RequestParam(required = false,defaultValue = "5")@Max(value = 5,message = "leverMax应小于等于5") Integer leverMax
	) throws ServletRequestOutOfBoundsException {
//		ExceptionUtil.isMaxAreMax(moneyMin,moneyMax,"价格");
//		ExceptionUtil.isMaxAreMax(leverMin,leverMax,"星级");
//		log.info(leverList.toString());
		List<CarShop> carShops = carShopService.getCarShopByKey(page, pageSize, address,sortKey);
//		log.info(fuzzyKey+" "+carShops);
		return ResponseEntity.ok(carShops);
	}


	@GetMapping("/{carShopId}")
	@ApiOperation("根据租车店id查询单个租车店")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "carShopId", value = "租车店id", required = true, dataType = "int", paramType = "path")
	})
	public ResponseEntity<CarShop> getCarShopById(@PathVariable @Min(1) Integer carShopId){
		return ResponseEntity.ok(carShopService.getCarShopById(carShopId));
	}

	@PostMapping(value = "",produces = "application/json")
	@ApiOperation(value = "新建或修改租车店",produces = "application/json")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "carShop",value = "租车店", required = true,dataType = "CarShop",paramType = "body"),
//			@ApiImplicitParam(name = "name",value = "名字", required = true,dataType = "String",paramType = "query"),
//			@ApiImplicitParam(name = "briefIntroduce",value = "简介", required = true,dataType = "String",paramType = "query"),
//			@ApiImplicitParam(name = "address",value = "地址", required = true,dataType = "String",paramType = "query")
//	})
	public ResponseEntity<CarShop> createOrUpdateCarShop(
			@RequestBody @NotNull CarShop carShop
	){
		return ResponseEntity.ok(carShopService.createOrUpdateCarShop(carShop));
	}

	@DeleteMapping("/{carShopId}")
	@ApiOperation("删除租车店 by id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "carShopId",value = "景区id",required = true,dataType = "int",paramType = "path"),
	})
	public ResponseEntity<Integer> deleteScenic(@PathVariable@Min(1) Integer carShopId){
		return ResponseEntity.ok(carShopService.deleteScenic(carShopId));
	}

}
