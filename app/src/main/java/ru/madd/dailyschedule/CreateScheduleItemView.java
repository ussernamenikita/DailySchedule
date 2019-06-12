package ru.madd.dailyschedule;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateScheduleItemView {

    private final EditText startTime;
    private EditText title;
    private CreateScheduleItemPresenter presenter;

    public void bindToPresenter(CreateScheduleItemPresenter presenter){
        this.presenter = presenter;
    }


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
                    presenter.onStartTimeChanged(startTimeFromString(s.toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });


        //
    }

    private Date startTimeFromString(String string) throws ParseException {
        //string = "01/04/2019 00:00-00:30";
        Date stringToDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(string);

        return stringToDate;

    }


    public void showProgress() {

    }
}
