package ru.madd.dailyschedule.settings;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainSettingsView implements IMainSettingsView{

    private TextView titleTextView;
    private Button saveBtn;
    private Button resetBtn;
    private CheckBox saveScheduleCheckBox;
    private CheckBox showPasttasksCheckBox;
    private CheckBox showNotificationCheckBox;
    private MainSettingsPresenter presenter;


    //TODO #1 set all fields from view parameter (view is root view from main_settings_fragment.xml)
    public MainSettingsView(View view){
        titleTextView = ...;
        saveBtn = ...;
        resetBtn = ...;
        saveScheduleCheckBox = ...;
        showPasttasksCheckBox = ...;
        showNotificationCheckBox = ...;
    }


    @Override
    public void bind(MainSettingsPresenter presenter) {
        this.presenter = presenter;
    }
}
