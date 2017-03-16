package com.sarahehabm.orangerx.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sarahehabm.orangerx.R;
import com.sarahehabm.orangerx.model.Location;

import java.util.ArrayList;

/**
 * Created by Sarah E. Mostafa on 16-Mar-17.
 */
public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Location> locations;

    public LocationListAdapter(Context context, ArrayList<Location> locations) {
        this.context = context;
        this.locations = locations;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_location, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Location location = locations.get(position);

        holder.textViewLongitude.setText(String.valueOf(location.getLongitude()));
        holder.textViewLatitude.setText(String.valueOf(location.getLatitude()));
    }

    @Override
    public int getItemCount() {
        if (locations == null)
            return 0;

        return locations.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewLatitude, textViewLongitude;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewLatitude = (TextView) itemView.findViewById(R.id.textView_latitude);
            textViewLongitude = (TextView) itemView.findViewById(R.id.textView_longitude);
        }
    }
}
