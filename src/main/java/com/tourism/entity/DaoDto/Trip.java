package com.tourism.entity.DaoDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ApiModel(value = "行程实体类")
@Getter
@Setter
@ToString(callSuper = true)
public class Trip {

//    public interface BaseDto {}
//    public interface TripDto extends BaseDto {}
//    public interface OrderDto extends BaseDto {}

//    @JsonView(BaseDto.class)
    private Integer id;

//    @JsonView(TripDto.class)
    @ApiModelProperty("行程名称")
    private String name;

//    @JsonView(TripDto.class)
    @ApiModelProperty("图片地址")
    private String imgUrl;

//    @JsonView(BaseDto.class)
    @ApiModelProperty("行程列表")
    private List<TripDetail> tripItems;

    @ApiModelProperty(hidden = true,example = "false")
    private boolean isDelete;

}