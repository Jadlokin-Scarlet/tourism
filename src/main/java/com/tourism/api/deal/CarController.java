package com.tourism.api.deal;

import com.tourism.entity.deal.Car;
import com.tourism.service.CarService;
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
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@Api("CarApi")
@RequestMapping("api/carShop/{carShopId}/car")
@Validated
@Slf4j
public class CarController {

	private CarService carService;

	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("")
	@ApiOperation("根据租车店id获取车辆列表")
	@ApiImplicitParam(name = "carShopId", value = "租车店id", required = true, dataType = "int", paramType = "path")
	public ResponseEntity<List<Car>> getAllCarByCarShopId(@PathVariable @Min(1) Integer carShopId){
		return ResponseEntity.ok(carService.getAllCarByCarShopId(carShopId));
	}

	@PostMapping(value = "",produces = "application/json")
	@ApiOperation(value = "批量新建或修改租车店",produces = "application/json")
	public ResponseEntity<List<Car>> createOrUpdateCarShop(@PathVariable@Min(0) Integer carShopId,@RequestBody @NotNull List<Car> cars){
		log.debug(cars.toString());
		cars.forEach(car -> car.setCarShopId(carShopId));
		return ResponseEntity.ok(carService.createOrUpdateCar(cars));
	}

	@DeleteMapping("/{carId}")
	@ApiOperation("删除车辆 by id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "carId",value = "车id",required = true,dataType = "int",paramType = "path"),
	})
	public ResponseEntity<Integer> deleteScenic(@PathVariable@Min(1) Integer carId){
		return ResponseEntity.ok(carService.deleteCarById(carId));
	}

}
