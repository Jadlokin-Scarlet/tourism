package com.tourism.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.tourism.util.MyUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;

@ApiModel("商家(酒店卖房间,景区卖门票,车店借车,餐馆卖吃的)实体类")
@Getter
@Setter
@ToString
public class Business {

	public interface BusinessBaseDto {}

	@JsonView(BusinessBaseDto.class)
	@ApiModelProperty(value = "id",example = "0")
	private int id;

	@JsonView(BusinessBaseDto.class)
	@ApiModelProperty("类别")
	private String type = MyUtil.getEnd(this.getClass().getName().split("\\.")).toLowerCase();

	@JsonView(BusinessBaseDto.class)
	@ApiModelProperty("名字")
	private String name = "";
	@JsonView(BusinessBaseDto.class)
	@ApiModelProperty("简介")
	private String briefIntroduce = "暂无";
	@JsonView(BusinessBaseDto.class)
	@ApiModelProperty("商家电话号码")
	private String phone = "";
	@JsonView(BusinessBaseDto.class)
	@ApiModelProperty("封面uri")
	private String imgUrl;

	@JsonView(BusinessBaseDto.class)
	@ApiModelProperty("地址")
	private String address = "杭州";
	@JsonView(BusinessBaseDto.class)
	@ApiModelProperty(value = "评分",example = "0")
	private Double score;

	@JsonIgnore
	@ApiModelProperty(hidden = true,example = "false")
	private boolean isClose = false;

	@ApiModelProperty("纬度")
	private Double latitude;

	@ApiModelProperty("经度")
	private Double longitude;
}
