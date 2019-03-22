package com.example.infs3634courseschedule;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityTopicAdapter extends RecyclerView.Adapter<ActivityTopicAdapter.actTopViewHolder> {
    static class actTopViewHolder extends RecyclerView.ViewHolder {
        TextView actTopView;

        actTopViewHolder(View itemView){
            super(itemView);
            actTopView = itemView.findViewById(R.id.actTop);

        }
    }
    private ArrayList<Pair> actTop;
    public ActivityTopicAdapter(ArrayList<Pair> actTop){
        this.actTop = actTop;
    }
    @NonNull
    @Override
    public ActivityTopicAdapter.actTopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.infs3634acttop, parent,false);
        return new actTopViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull actTopViewHolder actTopViewHolder, int i) {
        String actTopViewCard = actTop.get(i).first +": " + actTop.get(i).second;
        actTopViewHolder.actTopView.setText(actTopViewCard);
    }

    @Override
    public int getItemCount() {
        return actTop.size();
    }


}
