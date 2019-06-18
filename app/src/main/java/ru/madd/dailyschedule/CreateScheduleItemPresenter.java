package ru.madd.dailyschedule;

import java.util.Date;

public class CreateScheduleItemPresenter {


    private CreateScheduleItemView view;
    private IScheduleModel model;
    private IScreenRouter router;
    //TODO#5 create new ScheduleListItem - ?
    private ScheduleListItem newItem = new ScheduleListItem();

    public void bindToView(CreateScheduleItemView view) {
        this.view = view;
        updateBtnState();
    }


    private void updateBtnState() {
        if(view != null){
            view.setCreateTaskBtnEnabled(isAllFiledsFilled());
        }
    }

    //TODO#6 Implement function - ?
    /**
     * Check if all newItem's fields filled properly (!= null)
     * @return true if all fields filled and user can create item, otherwise false
     */
    private boolean isAllFiledsFilled() {
       if (newItem != null) return true;
       else return false;
    }

    public void onTitleChanged(String newTitle) {
        newItem.setTitle(newTitle);
        updateBtnState();
    }

    public void onDescriptionChanged(String newDescription) {
        newItem.setDescription(newDescription);
        updateBtnState();
    }

    public void onStartTimeChanged(Date newStartTime) {
        newItem.setStartTime(newStartTime);
        updateBtnState();
    }

    public void onEndTimeChanged(Date newEndTime) {
        newItem.setEndTime(newEndTime);
        updateBtnState();
    }

    public void onButtonClicked() {
        view.showProgress();
        model.addItem(newItem);
        router.routeToScheduleList();
    }


}
