package com.thangtruong19.earthquake;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create a fake list of earthquake locations.
        ArrayList<EarthQuake> earthquakes = QueryUtils.extractEarthquakes();


        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView =  findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        final EarthQuakeAdapter adapter = new EarthQuakeAdapter(this, earthquakes);

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
    }

