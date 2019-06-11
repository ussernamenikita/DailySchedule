package ru.madd.dailyschedule;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateScheduleItemView {

    private EditText title;
    private CreateScheduleItemPresenter presenter;

    public void bindToPresenter(CreateScheduleItemPresenter presenter){
        this.presenter = presenter;
    }


    public CreateScheduleItemView(View rootView) {
        title = rootView.findViewById(R.id.second_daily_schedule_element_type_title_ed);
        //
    }


}
