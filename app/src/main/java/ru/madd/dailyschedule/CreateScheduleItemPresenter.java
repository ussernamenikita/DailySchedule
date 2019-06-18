package ru.madd.dailyschedule;

import java.util.Date;

public class CreateScheduleItemPresenter {


    private CreateScheduleItemView view;
    private IScheduleModel model;
    private IScreenRouter router;
    private ScheduleListItem newItem = new ScheduleListItem();

    public void bindToView(CreateScheduleItemView view) {
        this.view = view;
        updateBtnState();
    }


    private void updateBtnState() {
        if (view != null) {
            view.setCreateTaskBtnEnabled(isAllFiledsFilled());
        }
    }

    private boolean isAllFiledsFilled() {
        return newItem.getDescription() != null &&
                newItem.getTitle() != null &&
                newItem.getStartTime() != null &&
                newItem.getEndTime() != null;
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
