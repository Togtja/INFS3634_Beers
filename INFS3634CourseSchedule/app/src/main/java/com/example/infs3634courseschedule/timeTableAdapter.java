package com.example.infs3634courseschedule;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class timeTableAdapter extends RecyclerView.Adapter<timeTableAdapter.timeTableViewHolder>{
    private List<INFS3634Info> schedule;
    public static class timeTableViewHolder extends RecyclerView.ViewHolder {
        public TextView timeTableWeek;
        public  TextView beerDesc;
        public timeTableViewHolder (View itemView){
            super(itemView);
            timeTableWeek = itemView.findViewById(R.id.week);
            //beerName = itemView.findViewById(R.id.beerNameLayout);
            //beerDesc = itemView.findViewById(R.id.beerDescLayout);
        }
    }
    public timeTableAdapter(List<INFS3634Info> b){
        schedule = b;
    }
    @Override
    public timeTableAdapter.timeTableViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.infs3634time, parent,false);
        return new timeTableViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(timeTableViewHolder holder, int pos) {
        holder.timeTableWeek.setText("W: "+schedule.get(pos).getName());
        //holder.beerDesc.setText(schedule.get(pos).getShortDescription());

    }

    @Override
    public int getItemCount() {
        return schedule.size();
    }
}
