package com.todayisapp.todayisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        Button button = (Button) findViewById(R.id.ChangeStartDateButton);
        button.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            Intent intent = new Intent(MenuScreen.this, MeetingPage.class);
            startActivity(intent);
        }
        });
    }
}
