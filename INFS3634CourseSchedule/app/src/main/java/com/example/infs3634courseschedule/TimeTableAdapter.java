package com.example.infs3634courseschedule;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.timeTableViewHolder>{
    private List<INFS3634Info> schedule;
    private List<Boolean> isVisible = new ArrayList<>();
    private Context context;
    static class timeTableViewHolder extends RecyclerView.ViewHolder {
        TextView timeTableWeek;
        RecyclerView actTopRV;
        CardView cardViewTT;

        timeTableViewHolder(View itemView){
            super(itemView);
            timeTableWeek = itemView.findViewById(R.id.date);
            actTopRV = itemView.findViewById(R.id.actTopRV);
            cardViewTT = itemView.findViewById(R.id.CardViewTimeTable);

        }
    }

    public TimeTableAdapter(List<INFS3634Info> b){
        schedule = b;
    }
    @Override
    public TimeTableAdapter.timeTableViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.infs3634time, parent,false);
        context = parent.getContext();

        for (int i = 0; i < schedule.size(); i++){
            isVisible.add(Boolean.FALSE);
        }

        return new timeTableViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final timeTableViewHolder holder, final int pos) {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM");
        String titleCard = "Week "+ String .valueOf(schedule.get(pos).getWeekNr()) + ": " +  dateFormat.format(schedule.get(pos).getDate());
        holder.timeTableWeek.setText(titleCard);

        ActivityTopicAdapter activityTopicAdapter = new ActivityTopicAdapter(schedule.get(pos).getActTop());
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        holder.actTopRV.setLayoutManager(layoutManager);
        holder.actTopRV.setVisibility(View.GONE); // Default not there
        //Onclick
        holder.cardViewTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isVisible.get(pos) == Boolean.FALSE){
                    holder.actTopRV.setVisibility(View.VISIBLE);
                }
                else {
                    holder.actTopRV.setVisibility(View.GONE);
                }
                isVisible.set(pos, !isVisible.get(pos));
            }
        });

        holder.actTopRV.setAdapter(activityTopicAdapter);
    }

    @Override
    public int getItemCount() {
        return schedule.size();
    }
}
