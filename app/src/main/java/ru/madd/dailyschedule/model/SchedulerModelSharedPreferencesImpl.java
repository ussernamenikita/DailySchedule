package ru.madd.dailyschedule.model;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

import ru.madd.dailyschedule.IScheduleModel;
import ru.madd.dailyschedule.ScheduleListItem;

public class SchedulerModelSharedPreferencesImpl implements IScheduleModel {

    private SharedPreferences preferences;

    /**
     * last index of saved item
     */
    private int lastIndex;

    public SchedulerModelSharedPreferencesImpl(Context context) {
        //TODO #0 Create shared preferences from context
        this.preferences ...;
        lastIndex = getLastIndex();
    }


    //TODO #6

    /**
     * Get last saved item's index from sharedPreferences
     *
     * @return index
     */
    private int getLastIndex() {
        return 0;
    }

    /**
     * Function return saved to {@link SharedPreferences} items
     *
     * @return saved items
     */
    @Override
    public List<ScheduleListItem> getAllItems() {
        //TODO #4
        List<ScheduleListItem> newList = ...;
        return getFromSharedPreferencesToList(newList);
    }

    //TODO #7

    /**
     * Add all available items from {@link SharedPreferences} to list
     *
     * @param newList list for items
     * @return all items from sharedPreferences
     */
    private List<ScheduleListItem> getFromSharedPreferencesToList(List<ScheduleListItem> newList) {

    }

    /**
     * Add item to sharedPreferences
     *
     * @param item newItem
     */
    @Override
    public void addItem(ScheduleListItem item) {
        putToSharedPreferences(++lastIndex, getString(item));
    }

    //TODO #3

    /**
     * Save string representation of {@link ScheduleListItem} with index {@param lastIndex}
     *
     * @param lastIndex index of last saved item
     * @param string    string representation of item
     */
    private void putToSharedPreferences(int lastIndex, String string) {

    }

    //TODO #5

    /**
     * Get string representation {@link ScheduleListItem} with index {@param index} from {@link SharedPreferences}
     *
     * @param index item's index
     * @return string representation of item with index
     */
    private String getFromSharedPreferences(int index) {

    }

    //TODO #2

    /**
     * Get string from item
     *
     * @param item item
     * @return string representation of item
     */
    private String getString(ScheduleListItem item) {

    }


    //TODO #1

    /**
     * Parse {@link ScheduleListItem} from string
     *
     * @param stringItem string representation of item
     * @return parsed item
     */
    private ScheduleListItem fromString(String stringItem) {

    }

}
