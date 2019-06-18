package ru.madd.dailyschedule;

import java.util.List;

public interface IScheduleModel {

    List<ScheduleListItem> getAllItems();

    void addItem(ScheduleListItem item);
}
