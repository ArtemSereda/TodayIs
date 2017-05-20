package com.todayisapp.todayisapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.todayisapp.todayisapp.MeetingPage.START_DATE_KEY;
import static com.todayisapp.todayisapp.MeetingPage.START_DAY_KEY;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        try {
            SharedPreferences sharedPreferences = getSharedPreferences("MeetingPage", Context.MODE_PRIVATE);

            String todayday = sharedPreferences.getString(START_DAY_KEY, "1");
            String date = sharedPreferences.getString(START_DATE_KEY,"09/01/16" );

            todayday = todayday.substring(4);
            int todaydayNumbr = Integer.parseInt(todayday);

            Date d = new SimpleDateFormat("MM/dd/yy").parse(date);
            Calendar vbc = Calendar.getInstance();
            vbc.setTime(d);


            int day = knowDay(todaydayNumbr, vbc);

            String TodayDay = Integer.toString(day);

            TextView textView = (TextView) findViewById(R.id.TodayDay);
            textView.setText(TodayDay);
        } catch (ParseException e) {
            //// todo process error





        }
        Button button = (Button) findViewById(R.id.menubutton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, MenuScreen.class);
                startActivity(intent);
            }
        });

    }





    public static int knowDay(int startDay, Calendar startDate) {
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
    }

}

