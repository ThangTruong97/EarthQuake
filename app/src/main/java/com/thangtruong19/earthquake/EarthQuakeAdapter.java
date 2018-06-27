package com.thangtruong19.earthquake;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 13/06/2018.
 */

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {
    public EarthQuakeAdapter(@NonNull Context context, @NonNull List<EarthQuake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View ListItemView=convertView;
        if(ListItemView==null){
            ListItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        EarthQuake currentEarthquake=getItem(position);

        TextView magnitudeView=ListItemView.findViewById(R.id.magnitude);
        magnitudeView.setText(currentEarthquake.getmMagnitude());

        //get the original location from EarthQuake object and store it in a string object
        String originalLocation=currentEarthquake.getmLocation();
        //create 2 new String object to store primary and offset location
        String primaryLocation;
        String offsetLocation;
        //init primary location and offset location
        if(originalLocation.contains("of")){
            String[] part=originalLocation.split("of");
            offsetLocation=part[0]+"of";
            primaryLocation=part[1];
        }else{
            offsetLocation=getContext().getString(R.string.near_the);
            primaryLocation=originalLocation;
        }
        //set the Text View of location offset from the received offsetLocation
        TextView locationOffsetView=ListItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(offsetLocation);
        //set the Text View of location primary from the received primaryLocation
        TextView locationPrimaryView=ListItemView.findViewById(R.id.primary_location);
        locationPrimaryView.setText(primaryLocation);
        Date dateObject =new Date(currentEarthquake.getmDate());

        TextView dateView=ListItemView.findViewById(R.id.date);
        String formatDate=formatDate(dateObject);
        dateView.setText(formatDate);

        TextView timeView=ListItemView.findViewById(R.id.time);
        String formatTime=formatTime(dateObject);
        timeView.setText(formatTime);

        return ListItemView;
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat=new SimpleDateFormat("MMM dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat=new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}

