package ru.madd.dailyschedule;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * This class bind {@link ScheduleListItem} to view.
 * It shows all data from item to view
 */
public class DailyScheduleViewHolder extends RecyclerView.ViewHolder {


    /**
     * Current showed item
     */
    private ScheduleListItem currentItem = null;

    public DailyScheduleViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bindToItem(ScheduleListItem item){
        this.currentItem = item;
        //Write your code there
        //to show item's data on view's
    }
}
