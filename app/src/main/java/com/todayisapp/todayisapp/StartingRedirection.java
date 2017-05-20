package com.todayisapp.todayisapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.todayisapp.todayisapp.MeetingPage.START_DAY_KEY;

public class StartingRedirection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Model model = Model.INSTANCE;
        SharedPreferences sharedPreferences = getSharedPreferences("MeetingPage", Context.MODE_PRIVATE);

        ModelPersistence.persistModel(model, sharedPreferences);

        setContentView(R.layout.activity_starting_redirection);

        if (model.isInitialized()) {
            Intent intent = new Intent(StartingRedirection.this, MainScreen.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(StartingRedirection.this, MeetingPage.class);
            startActivity(intent);
        }
    }
}
