package ru.madd.dailyschedule;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateScheduleItemView {

    private final EditText startTime;
    private EditText title;
    private CreateScheduleItemPresenter presenter;
    private Date lastStartTime;
    private Date lastDurationMinutes;
    private EditText durationMinutes;
    private Button createTask;
    private ProgressBar progressBar;


    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");


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
        startTime = rootView.findViewById(R.id.second_daily_schedule_element_input_start_time_ed);
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
        durationMinutes = rootView.findViewById(R.id.second_daily_schedule_element_minutes_ed);
        durationMinutes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                lastDurationMinutes = fromDurationToDate(s.toString());
                presenter.onEndTimeChanged(lastDurationMinutes);
            }
        });
        createTask = rootView.findViewById(R.id.second_daily_schedule_element_create_tast_b);
        //TODO#1 add click listener to createTask. In listener call onButtonClicked function on presenter

        //TODO#2 get progressBar from xml and set it visibility to Gone

        //TODO#0 set textChangeListener to description EditText
    }

    public void bindToPresenter(CreateScheduleItemPresenter presenter) {
        this.presenter = presenter;
    }

    private Date startTimeFromString(String string) throws ParseException {
        //string = "01/04/2019 00:00-00:30";
        return format.parse(string);
    }

    /**
     * Function convert duration to end time
     * Uses lastStartTime
     * @param text text from edit text
     * @return end time
     */
    private Date fromDurationToDate(String text) {
        //text = "20" минуты;
        long duration = Long.parseLong(text) * 60 * 1000;
        long longLastStartTime = lastStartTime.getTime();
        return new Date(longLastStartTime + duration);
    }


    //TODO#4 implement function
    /**
     * Enable button according to {@param enabled}
     * If enabled == true, then btn will be enabled
     * If enabled == false, then btn will be disabled
     * @param enabled enabled or not
     */
    public void setCreateTaskBtnEnabled(boolean enabled){

    }


    //TODO#3 set progressBar visibility to VISIBLE and rest views to GONE
    /**
     * Show progress bar on screen,
     * and hide all rest views
     */
    public void showProgress() {

    }
}
