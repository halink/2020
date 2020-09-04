package com.halink.decorator;

public class Home implements IHome {

    private Integer area;

    private Integer aestheticMeasure;

    @Override
    public Integer getArea() {
        return this.area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @Override
    public Integer getAestheticMeasure() {
        return this.aestheticMeasure;
    }

    public void setAestheticMeasure(Integer aestheticMeasure) {
        this.aestheticMeasure = aestheticMeasure;
    }
}
