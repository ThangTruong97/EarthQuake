package com.thangtruong19.earthquake;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by User on 10/07/2018.
 */

public class EarthQuakeLoader extends AsyncTaskLoader<List<EarthQuake>> {
    /*Tag for log message */
    private static final String LOG_TAG=EarthQuakeLoader.class.getName();
    private String mUrl;

    public EarthQuakeLoader(Context context,String url){
        super(context);
        mUrl=url;
    }

    @Override
    public List<EarthQuake> loadInBackground() {
        if(mUrl==null){
            return null;
        }
        List<EarthQuake> earthQuakes=QueryUtils.fetchEarthquakeData(mUrl);
        return earthQuakes;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
