package com.todayisapp.todayisapp;

import java.util.Date;

public class Model {
    public static final int NUMBER_OF_SCHOOL_DAYS = 6;
    public static final Model INSTANCE = new Model();

    /**
     * The starting day number.
     */
    private int myStartDayNumber;

    /**
     * The starting day.
     */
    private Date myStartDate;

    /**
     * Single observer of the changes.
     */
    private Runnable myChangeObserver;


    private Model() {}


    public int getStartDayNumber() {
        return myStartDayNumber;
    }

    public Date getStartDate() {
        return myStartDate;
    }

    public void setStartDayNumber(int startDayNumber) {
        myStartDayNumber = startDayNumber;
        modelUpdated();
    }

    public void setStartDate(Date startDate) {
        myStartDate = startDate;
        modelUpdated();
    }

    private void modelUpdated() {
        if (myChangeObserver != null) {
            myChangeObserver.run();
        }
    }

    /**
     * Call {@code r} when model changes.
     *
     * @param r
     */
    public void onChange(Runnable r) {
        myChangeObserver = r;
    }


    public int getCurrentDayNumber() {
/*
        Calendar now = Calendar.getInstance();
        long nowMil = now.getTimeInMillis();
        long startMil = startDate.getTimeInMillis();
        long difMil = nowMil - startMil;
        int difDays = (int) (difMil / 86400000);
        int boomx = difDays % 6;
        int ResDay = startDay + boomx;
        if (ResDay > 6) {
            ResDay = ResDay - 6;
        }
        return ResDay;
*/

    }
}
