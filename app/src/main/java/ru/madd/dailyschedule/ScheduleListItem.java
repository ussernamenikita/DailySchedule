package ru.madd.dailyschedule;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ScheduleListItem {

    private String title;
    private String description;
    private boolean isTaskDone;
    private Date startTime;
    private Date endTime;

    public String getTitle() {
        return title;
    }

    DateFormat dateFormat = new SimpleDateFormat("HH:mm");

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTaskDone() {
        return isTaskDone;
    }

    public void setTaskDone(boolean taskDone) {
        isTaskDone = taskDone;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Converts time interval to progress value between 0 and 100
     * For example if {@param currentTime} equals {@link ScheduleListItem#startTime} then return 0
     * and if {@param currentTime} equals {@link ScheduleListItem#endTime} then return 100
     *
     * @param currentTime current time
     * @return time interval progress from 0 to 100
     */
    //TODO implement
    public int getProgressFromDates(Date currentTime) {
      if (startTime.after(currentTime)) return 0;
      if (endTime.before(currentTime)) return 100;
      long intervalDate = (endTime.getTime() - startTime.getTime());
      long firstPercent = intervalDate / 100;
      long intervaltoDate = (currentTime.getTime() - startTime.getTime());
      return (int)(intervaltoDate / firstPercent);

    }

    public String parseTimeInterval()  {

            return dateFormat.format(startTime) + "-" + dateFormat.format(endTime);
    }
}
