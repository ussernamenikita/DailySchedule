package ru.madd.dailyschedule;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    private EditText descriptionsED;
    private TextView headerTitle;
    private TextView headerDescription;
    private TextView headerStartTime;
    private TextView headerDurationMinuters;


    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");


    public CreateScheduleItemView(View rootView) {
        headerTitle = rootView.findViewById(R.id.second_daily_schedule_element_title_tv);
        headerDescription = rootView.findViewById(R.id.second_daily_schedule_element_description_tv);
        headerStartTime = rootView.findViewById(R.id.second_daily_schedule_element_start_time_tv);
        headerDurationMinuters = rootView.findViewById(R.id.second_daily_schedule_element_duration_minutes_tv);
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
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClicked();
            }
        };
        createTask = rootView.findViewById(R.id.second_daily_schedule_element_create_tast_b);
        createTask.setOnClickListener(onClickListener);
        progressBar = rootView.findViewById(R.id.second_daily_schedule_element_minutes_open_pB);
        descriptionsED = rootView.findViewById(R.id.second_daily_schedule_element_description_name_ed);
        descriptionsED.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.onDescriptionChanged(s.toString());

            }
        });

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
     *
     * @param text text from edit text
     * @return end time
     */
    private Date fromDurationToDate(String text) {
        //text = "20" минуты;
        long duration = Long.parseLong(text) * 60 * 1000;
        long longLastStartTime = lastStartTime.getTime();
        return new Date(longLastStartTime + duration);
    }


    public void setCreateTaskBtnEnabled(boolean enabled) {
        createTask.setClickable(enabled);
    }


    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        title.setVisibility(View.GONE);
        startTime.setVisibility(View.GONE);
        durationMinutes.setVisibility(View.GONE);
        descriptionsED.setVisibility(View.GONE);
        headerDurationMinuters.setVisibility(View.GONE);
        headerStartTime.setVisibility(View.GONE);
        headerDescription.setVisibility(View.GONE);
        headerTitle.setVisibility(View.GONE);
    }


}
