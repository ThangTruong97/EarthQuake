package com.thangtruong19.earthquake;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<EarthQuake>>{

    private static final String LOG_TAG=EarthQuakeLoader.class.getName();
    private static final int EarthQuakeLoaderID=1;
    private static final String SAMPLE_JSON_RESPONSE = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=5&limit=10";
    private EarthQuakeAdapter adapter;
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG,"Test: Main Activity onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOG_TAG,"Test: Calling initLoader()");
        getLoaderManager().initLoader(EarthQuakeLoaderID,null,this).forceLoad();
        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView =  findViewById(R.id.list);

        mEmptyStateTextView=findViewById(R.id.empty_view);
        earthquakeListView.setEmptyView(mEmptyStateTextView);

        // Create a new {@link ArrayAdapter} of earthquakes
        adapter = new EarthQuakeAdapter(this, new ArrayList<EarthQuake>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //find the current earthquake that was clicked on
                EarthQuake currentEarthquake=adapter.getItem(i);
                //convert the url string into url object
                Uri earthquakeURi=Uri.parse(currentEarthquake.getmUrl());
                //Create a new intent to view the earthquake to view url
                Intent websiteIntent=new Intent(Intent.ACTION_VIEW,earthquakeURi);
                //start activity
                startActivity(websiteIntent);
            }
        });

    }

    @Override
    public Loader<List<EarthQuake>> onCreateLoader(int i, Bundle bundle) {
        Log.i(LOG_TAG,"Test: onCreateLoader() called");
        return new EarthQuakeLoader(this,SAMPLE_JSON_RESPONSE);
    }

    @Override
    public void onLoadFinished(Loader<List<EarthQuake>> loader, List<EarthQuake> earthQuakes) {
        Log.i(LOG_TAG,"Test: onLoadFinished() called");
        // Hide loading indicator because the data has been loaded
        View loadingIndicator=findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        // Set empty state text to display "No earthquakes found."
        mEmptyStateTextView.setText(R.string.no_data);
        //clear the adapter for previous earthquake data
        adapter.clear();
        if(earthQuakes!=null &&!earthQuakes.isEmpty()){
           // adapter.addAll(earthQuakes);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<EarthQuake>> loader) {
        Log.i(LOG_TAG,"Test: onLoaderReset() called");
        adapter.clear();
    }


    }

