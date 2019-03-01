package com.tourism.entity;

public class Area {
    private String areaName;
    private String areaIntroduce;
    private String areaFolkCustom;

    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaIntroduce() {
        return areaIntroduce;
    }
    public void setAreaIntroduce(String areaIntroduce) {
        this.areaIntroduce = areaIntroduce;
    }

    public String getAreaFolkCustom() {
        return areaFolkCustom;
    }
    public void setAreaFolkCustom(String areaFolkCustom) {
        this.areaFolkCustom = areaFolkCustom;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaName='" + areaName + '\'' +
                ", areaIntroduce='" + areaIntroduce + '\'' +
                ", areaFolkCustom='" + areaFolkCustom + '\'' +
                '}';
    }

}
