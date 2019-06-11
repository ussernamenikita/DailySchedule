package ru.madd.dailyschedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.util.ArrayList;

public class DailyScheduleRecyclerViewAdapter extends RecyclerView.Adapter<DailyScheduleViewHolder> {

    private ArrayList<ScheduleListItem> items;

    private LayoutInflater layoutInflater;

    public DailyScheduleRecyclerViewAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public void setItems(ArrayList<ScheduleListItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DailyScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DailyScheduleViewHolder(createView(parent, viewType));
    }

    private View createView(ViewGroup parent, int viewType) {
        return layoutInflater.inflate(R.layout.daily_schedule_element, parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyScheduleViewHolder holder, int position) {
        if (position <= 0 || position >= items.size()) {
            return;
        }
        try {
            holder.bindToItem(items.get(position));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}
