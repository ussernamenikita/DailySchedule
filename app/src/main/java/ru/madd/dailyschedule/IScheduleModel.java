package ru.madd.dailyschedule;

import java.util.List;

interface IScheduleModel {

    List<ScheduleListItem> getAllItems();

    void addItem(ScheduleListItem item);

    void removeItem(ScheduleListItem item);
}
