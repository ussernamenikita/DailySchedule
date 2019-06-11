package ru.madd.dailyschedule;

import android.view.View;

public class CreateScheduleItemPresenter {


    private CreateScheduleItemView view;
    private ScheduleListItem model;

    public void bindToView(CreateScheduleItemView view){
        this.view = view;
    }


    public void onTitleChanged(String newTitle){
        model.setTitle(newTitle);
    }


}
