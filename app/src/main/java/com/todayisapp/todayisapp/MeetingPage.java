package com.todayisapp.todayisapp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

public class MeetingPage extends AppCompatActivity {

    private static final String START_DAY_KEY = "TodayIs.StartDay";
    private static final String START_DATE_KEY = "TodayIs.StartDate";

    int DIALOG_DATE = 1;
    int myYear = 2016;
    int myMonth = 9;
    int myDay = 1;
    Button changebuttonmeeting;
    private TextView dateNumberMeeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_meeting_page);
        changebuttonmeeting = (Button) findViewById(R.id.changebuttonmeeting);
        dateNumberMeeting = (TextView) findViewById(R.id.dateNumberMeeting);
        Spinner spinner = (Spinner) findViewById(R.id.dayschooseMeeting);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.DaysOfTheWeek, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Button button = (Button) findViewById(R.id.gobuttonmeeting);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Spinner spinner1 = (Spinner) findViewById(R.id.dayschooseMeeting);
                String daynumber = spinner1.getSelectedItem().toString();

                TextView textView = (TextView) findViewById(R.id.dateNumberMeeting);
                String date = textView.getText().toString();

                SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
                sharedPreferences.edit()
                        .putString(START_DAY_KEY, daynumber)
                        .putString(START_DATE_KEY, date)
                        .apply();

            }
        });

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        String todayday = sharedPreferences.getString(START_DAY_KEY, "1");
        int index = findIndex(adapter, todayday);
        spinner.setSelection(index);

       String date = sharedPreferences.getString(START_DATE_KEY,"09/01/16" );
        TextView textView = (TextView) findViewById(R.id.dateNumberMeeting);
        textView.setText(date);

    }

    private int findIndex(ArrayAdapter<CharSequence> adapter, String todayday) {
        int n = adapter.getCount();
        for (int i = 0; i < n; i++) {
            String theday = adapter.getItem(i).toString();
            if (theday.equals(todayday)) {
                return i;
            }
        }
        return 0;

        //   adapter.getItem(X).toString() --- gives you element number X ("Day 1" for 0, "Day 2" for 1, etc)
        // Learn how to use for() cycle -- this is Java!! and go through all items until you
        // find the match
        // Use if() to compare todayday with each element of the spinner.
    }



    public void onclick(View view) {
        showDialog(DIALOG_DATE);
    }


    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, myYear, myDay, myMonth);
            return tpd;
        }
        return super.onCreateDialog(id);
    }


    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myYear = year;
            myMonth = monthOfYear;
            myDay = dayOfMonth;
            dateNumberMeeting.setText(myMonth + "/" + myDay + "/" + myYear);

        }

    };
}
