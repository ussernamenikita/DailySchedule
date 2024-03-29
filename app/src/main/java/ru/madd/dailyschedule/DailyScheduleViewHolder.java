package ru.madd.dailyschedule;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;

/**
 * This class bind {@link ScheduleListItem} to view.
 * It shows all data from item to view
 */
public class DailyScheduleViewHolder extends RecyclerView.ViewHolder {


    /**
     * Current showed item
     */
    private ScheduleListItem currentItem = null;
    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    private TextView dailyScheduleElementTitle;
    //TODO rename all fields like  dailyScheduleElementTitle
    //for more info see(https://www.geeksforgeeks.org/java-naming-conventions/)
    private TextView dailyScheduleElementBuzz;
    private TextView dailyScheduleElementDescription;
    private ProgressBar dailyScheduleElementProgBar;
    private CheckBox dailyScheduleElementCheck;


    public DailyScheduleViewHolder(@NonNull View itemView) {
        super(itemView);
        dailyScheduleElementTitle = itemView.findViewById(R.id.daily_schedule_element_text_in_title_tv);
        dailyScheduleElementBuzz = itemView.findViewById(R.id.daily_schedule_element_start_time_tv);
        dailyScheduleElementDescription = itemView.findViewById(R.id.daily_schedule_element_text_discription_tv);
        dailyScheduleElementProgBar = itemView.findViewById(R.id.daily_schedule_element_progress_task_pb);
        dailyScheduleElementCheck = itemView.findViewById(R.id.daily_schedule_element_check_task_cb);

    }

    public void bindToItem(ScheduleListItem item) throws ParseException {
        this.currentItem = item;
        this.dailyScheduleElementTitle.setText(item.getTitle());
        this.dailyScheduleElementBuzz.setText(item.parseTimeInterval());
        this.dailyScheduleElementDescription.setText(item.getDescription());
        this.dailyScheduleElementProgBar.setProgress(item.getProgressFromDates(new Date(System.currentTimeMillis())));
        this.dailyScheduleElementCheck.setChecked(item.isTaskDone());
    }





}
