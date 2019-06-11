package ru.madd.dailyschedule;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ScheduleListItemTest {

    private ScheduleListItem item1;

    @Before
    public void setUp() {
        item1 = new ScheduleListItem();
    }

    @Test
    public void getProgressFromDates_0_percent() {
        //Given
        item1.setStartTime(new Date(0));
        item1.setEndTime(new Date(100));

        //When
        int actualPercent = item1.getProgressFromDates(new Date(0));

        //Then
        assertEquals(0, actualPercent);
    }

    @Test
    public void getProgressFromDate_50_percent() {
        //Given
        item1.setStartTime(new Date(0));
        item1.setEndTime(new Date(100));

        //When
        int actualPercent = item1.getProgressFromDates(new Date(50));

        //Then
        assertEquals(50, actualPercent);
    }

    @Test
    public void getProgressFromDate_100_percent() {
        //Given
        item1.setStartTime(new Date(0));
        item1.setEndTime(new Date(100));

        //When
        int actualPercent = item1.getProgressFromDates(new Date(100));

        //Then
        assertEquals(100, actualPercent);
    }


    @Test
    public void getProgressFromDate_biggerThanEndTime() {
        //Given
        item1.setStartTime(new Date(0));
        item1.setEndTime(new Date(100));

        //When
        int actualPercent = item1.getProgressFromDates(new Date(10000));

        //Then
        assertEquals(100, actualPercent);
    }


    @Test
    public void getProgressFromDate_lowerThanStartTime() {
        //Given
        item1.setStartTime(new Date(100));
        item1.setEndTime(new Date(200));

        //When
        int actualPercent = item1.getProgressFromDates(new Date(10));

        //Then
        assertEquals(0, actualPercent);
    }
}