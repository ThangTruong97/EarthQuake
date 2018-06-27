package com.thangtruong19.earthquake;

/**
 * Created by User on 13/06/2018.
 */

public class EarthQuake {
    private String mMagnitude;
    private String mLocation;
    private Long mDate;

    public EarthQuake(String mMagnitude,String mLocation,Long mDate) {
        this.mMagnitude = mMagnitude;
        this.mLocation=mLocation;
        this.mDate=mDate;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public Long getmDate() {
        return mDate;
    }
}
