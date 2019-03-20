package com.tourism.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;
@ApiModel("景点(门票)实体类")
public class Scenic extends Deal{
	@ApiModelProperty("所在地区名称")
	private String areaName;

	@ApiModelProperty("评分")
	private Double score;

	@ApiModelProperty("每日开始时间")
	private Date everyDayStartTime;
	@ApiModelProperty("每日结束时间")
	private Date everyDayEndTime;

	@ApiModelProperty("wifi们的信息")
	private List<Wifi> wifi;
	@ApiModelProperty("停车场们的信息")
	private List<Parking> parking;
	@ApiModelProperty("厕所介绍")
	private String WC;

	@ApiModelProperty("介绍地址")
	private String introductionUrl;

	@ApiModelProperty(value = "票的类型",example = "成人票,儿童票")
	private String scenicType;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Date getEveryDayStartTime() {
		return everyDayStartTime;
	}

	public void setEveryDayStartTime(Date everyDayStartTime) {
		this.everyDayStartTime = everyDayStartTime;
	}

	public Date getEveryDayEndTime() {
		return everyDayEndTime;
	}

	public void setEveryDayEndTime(Date everyDayEndTime) {
		this.everyDayEndTime = everyDayEndTime;
	}

	public List<Wifi> getWifi() {
		return wifi;
	}

	public void setWifi(List<Wifi> wifi) {
		this.wifi = wifi;
	}

	public List<Parking> getParking() {
		return parking;
	}

	public void setParking(List<Parking> parking) {
		this.parking = parking;
	}

	public String getWC() {
		return WC;
	}

	public void setWC(String WC) {
		this.WC = WC;
	}

	public String getIntroductionUrl() {
		return introductionUrl;
	}

	public void setIntroductionUrl(String introductionUrl) {
		this.introductionUrl = introductionUrl;
	}

	public String getScenicType() {
		return scenicType;
	}

	public void setScenicType(String scenicType) {
		this.scenicType = scenicType;
	}
}
