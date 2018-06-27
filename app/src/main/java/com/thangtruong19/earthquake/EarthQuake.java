package com.thangtruong19.earthquake;

/**
 * Created by User on 13/06/2018.
 */

public class EarthQuake {
    private Double mMagnitude;
    private String mLocation;
    private Long mDate;

    public EarthQuake(Double mMagnitude,String mLocation,Long mDate) {
        this.mMagnitude = mMagnitude;
        this.mLocation=mLocation;
        this.mDate=mDate;
    }

    public Double getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public Long getmDate() {
        return mDate;
    }
}
