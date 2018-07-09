package com.thangtruong19.earthquake;

/**
 * Created by User on 13/06/2018.
 */

public class EarthQuake {
    private Double mMagnitude;
    private String mLocation;
    private Long mDate;
    private String mUrl;

    public EarthQuake(Double mMagnitude,String mLocation,Long mDate,String url) {
        this.mMagnitude = mMagnitude;
        this.mLocation=mLocation;
        this.mDate=mDate;
        this.mUrl=url;
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

    public String getmUrl(){return mUrl;}
}
