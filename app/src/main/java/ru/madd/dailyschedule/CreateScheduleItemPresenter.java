package ru.madd.dailyschedule;

import android.view.View;

import java.util.Date;

public class CreateScheduleItemPresenter {


    private CreateScheduleItemView view;
    private ScheduleListItem model;

    public void bindToView(CreateScheduleItemView view){
        this.view = view;
    }


    public void onTitleChanged(String newTitle){
        model.setTitle(newTitle);
    }

    public void onDescriptionChanged(String newDescription) {model.setDescription(newDescription);}

    public  void onStartTimeChanged(Date newStartTime) {model.setStartTime(newStartTime);}

    public void onEndTimeChanged (Date newEndTime) {model.setEndTime(newEndTime);}

    public void onButtonClicked () {view.showProgress();}


}
