package com.thangtruong19.earthquake;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create a fake list of earthquake locations.
        ArrayList<EarthQuake> earthquakes = new ArrayList<>();
        earthquakes.add(new EarthQuake("7.2","San Francisco","Feb 2 2016"));
        earthquakes.add(new EarthQuake("6.1","London","July 20 2015"));
        earthquakes.add(new EarthQuake("3.9","Tokyo","Nov 10 2014"));
       // earthquakes.add("Mexico City");
        //earthquakes.add("Moscow");
        //earthquakes.add("Rio de Janeiro");
        //earthquakes.add("Paris");

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView =  findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        ArrayAdapter<EarthQuake> adapter = new ArrayAdapter<>(this, R.layout.list_item, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
    }

