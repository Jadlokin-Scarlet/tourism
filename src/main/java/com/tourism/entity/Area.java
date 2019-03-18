package com.tourism.entity;

public class Area {
    private Integer areaId;

    private String areaName;

    private String areaIntroduce;

    private String areaFolkCustom;

    private String parentName;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAreaIntroduce() {
        return areaIntroduce;
    }

    public void setAreaIntroduce(String areaIntroduce) {
        this.areaIntroduce = areaIntroduce == null ? null : areaIntroduce.trim();
    }

    public String getAreaFolkCustom() {
        return areaFolkCustom;
    }

    public void setAreaFolkCustom(String areaFolkCustom) {
        this.areaFolkCustom = areaFolkCustom == null ? null : areaFolkCustom.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", areaId=").append(areaId);
        sb.append(", areaName=").append(areaName);
        sb.append(", areaIntroduce=").append(areaIntroduce);
        sb.append(", areaFolkCustom=").append(areaFolkCustom);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Area other = (Area) that;
        return (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getAreaName() == null ? other.getAreaName() == null : this.getAreaName().equals(other.getAreaName()))
            && (this.getAreaIntroduce() == null ? other.getAreaIntroduce() == null : this.getAreaIntroduce().equals(other.getAreaIntroduce()))
            && (this.getAreaFolkCustom() == null ? other.getAreaFolkCustom() == null : this.getAreaFolkCustom().equals(other.getAreaFolkCustom()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getAreaName() == null) ? 0 : getAreaName().hashCode());
        result = prime * result + ((getAreaIntroduce() == null) ? 0 : getAreaIntroduce().hashCode());
        result = prime * result + ((getAreaFolkCustom() == null) ? 0 : getAreaFolkCustom().hashCode());
        return result;
    }
}