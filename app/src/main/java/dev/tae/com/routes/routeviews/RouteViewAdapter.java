package dev.tae.com.routes.routeviews;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dev.tae.com.routes.R;
import dev.tae.com.routes.model.Model;

/**
 * Created by TAE on 05/06/2016.
 */
public class RouteViewAdapter extends RecyclerView.Adapter<RouteViewAdapter.ViewHolder> {
    private Context context;
    private List<Model> model;

    public RouteViewAdapter(Context c, List<Model> mod){
        this.context = c;
        this.model = mod;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.depart.setText(model.get(position).getStartLocality());
        String departDate, arriveDate, departTime, arriveTime;
        departDate = cutDate(model.get(position).getStartDate().getDate());
        arriveDate = cutDate(model.get(position).getEndDate().getDate());
        departTime = cutTime(model.get(position).getStartDate().getDate());
        arriveTime = cutTime(model.get(position).getEndDate().getDate());
        holder.dDate.setText(departDate);
        holder.aDate.setText(arriveDate);
        holder.dTime.setText(departTime);
        holder.aTime.setText(arriveTime);
        holder.arrive.setText(model.get(position).getEndLocality());
        holder.journeyID.setText("Id "+model.get(position).getJourneyID().toString());
        holder.distance.setText("Distance "+model.get(position).getDistance().toString());
        holder.duration.setText("Duration "+String.valueOf(model.get(position).getDuration()/60)+" hrs");

        holder.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocationInterfaces mCallback;
                try {
                    final double[] gps = new double[4];
                    gps[0] = model.get(position).getStartCoordinate().getLat();
                    gps[1] = model.get(position).getStartCoordinate().getLat();
                    gps[2] = model.get(position).getEndCoordinate().getLat();
                    gps[3] = model.get(position).getEndCoordinate().getLat();
                    final String startN = model.get(position).getStartLocality();
                    final String endN = model.get(position).getEndLocality();
                    mCallback = (LocationInterfaces) context;
                    mCallback.setLocation(context,1, gps, startN, endN);
                } catch (ClassCastException e) {
                    Log.i("onClick", "CharactersGridAdapter error:" + e.getMessage());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.route_card_view_layout, parent, false);
        return new ViewHolder(v);
    }

    private String cutDate(String timeStamp){

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = sdf.parse(timeStamp);
            return sdf.format(d);
        }catch(Exception e){
            Log.i("format convert", e.getMessage());
        }
        return null;
    }

    private String cutTime(String timeStamp){

        DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            Date d = sdf.parse(timeStamp);
            return sdf.format(d);
        }catch(Exception e){
            Log.i("format convert", e.getMessage());
        }
        return null;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView depart, arrive, dDate, aDate, dTime, aTime, journeyID, duration, distance;
        private View.OnClickListener clickListener;
        public ViewHolder(View v){
            super(v);
            depart = (TextView) v.findViewById(R.id.tv_departure);
            dDate = (TextView) v.findViewById(R.id.tv_departure_date);
            arrive = (TextView) v.findViewById(R.id.tv_arrival);
            aDate = (TextView) v.findViewById(R.id.tv_departure_date);
            dTime = (TextView) v.findViewById(R.id.tv_departure_time);
            aTime = (TextView) v.findViewById(R.id.tv_arrival_Date);
            journeyID = (TextView) v.findViewById(R.id.tv_journey_id);
            duration = (TextView) v.findViewById(R.id.tv_duration);
            distance = (TextView) v.findViewById(R.id.tv_distance);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }
        /**
         * @param clickListener
         */
        public void setClickListener(View.OnClickListener clickListener) {
            this.clickListener = clickListener;
        }

        /**
         * @param v
         */
        @Override
        public void onClick(View v) {
            this.clickListener.onClick(v);
        }
    }
}
