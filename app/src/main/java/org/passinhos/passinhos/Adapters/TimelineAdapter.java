package org.passinhos.passinhos.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.passinhos.passinhos.Models.Income;
import org.passinhos.passinhos.Models.Timeline;
import org.passinhos.passinhos.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.MyViewHolder> {

    private List<Timeline> timeline;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.timeline_title);
        }
    }


    public TimelineAdapter(List<Timeline> ts) {
        Collections.reverse(ts);
        this.timeline = ts;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        if(viewType == timeline.size()-1)
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.timeline_list_first, parent, false);
        else
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.timeline_list_item, parent, false);;

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Timeline t = timeline.get(position);
        holder.title.setText(t.getTitle());
    }

    @Override
    public int getItemCount() {
        return timeline.size();
    }
}
