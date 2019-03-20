package com.tourism.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("wifi信息实体类")
class Wifi {

	@ApiModelProperty("wifi名称")
	private String name;
	@ApiModelProperty("wifi密码,或登录方式")
	private String password;
	@ApiModelProperty("覆盖区域")
	private String coverageArea;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCoverageArea() {
		return coverageArea;
	}

	public void setCoverageArea(String coverageArea) {
		this.coverageArea = coverageArea;
	}

	@Override
	public String toString() {
		return "Wifi{" +
				"name='" + name + '\'' +
				", password='" + password + '\'' +
				", coverageArea='" + coverageArea + '\'' +
				'}';
	}


}
