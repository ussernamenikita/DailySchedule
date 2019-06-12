package ru.madd.dailyschedule;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateScheduleItemView {

    private final EditText startTime;
    private EditText title;
    private CreateScheduleItemPresenter presenter;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private Date lastStartTime;


    public CreateScheduleItemView(View rootView) {
        title = rootView.findViewById(R.id.second_daily_schedule_element_type_title_ed);
        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.onTitleChanged(s.toString());

            }
        });
        startTime = rootView.findViewById(R.id.second_daily_schedule_element_minutes_ed);
        startTime.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    lastStartTime = startTimeFromString(s.toString());
                    presenter.onStartTimeChanged(lastStartTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });


        //
    }

    public void bindToPresenter(CreateScheduleItemPresenter presenter) {
        this.presenter = presenter;
    }

    private Date startTimeFromString(String string) throws ParseException {
        //string = "01/04/2019 00:00-00:30";
        return format.parse(string);
    }

    /**
     * Function convert duratuion to end time
     * Uses lastStartTime
     * @param text text from edit text
     * @return end time
     */
    private Date fromDurationToDate(String text){
        int duration = ...//TODO parse text to Int
        Date endTime = ...//TODO get and return end tim e from start time + duration
    }


    public void showProgress() {

    }
}
