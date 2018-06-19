package com.thangtruong19.earthquake;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        TextView locationView=ListItemView.findViewById(R.id.location);
        locationView.setText(currentEarthquake.getmLocation());

        TextView dateView=ListItemView.findViewById(R.id.date);
        dateView.setText(currentEarthquake.getmDate());

        return ListItemView;
    }
}

