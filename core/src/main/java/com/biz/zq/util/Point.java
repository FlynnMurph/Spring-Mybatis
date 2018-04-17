package com.biz.zq.util;

import java.io.Serializable;

public class Point implements Serializable {

    private double lat;

    private double lon;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
