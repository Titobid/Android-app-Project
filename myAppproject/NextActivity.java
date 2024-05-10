package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;


public class NextActivity extends AppCompatActivity {

    CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);

        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                String msg = "Selected date Day: " + day + " Month : " + (month + 1) + " Year " + year;
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();


            }
        });
    }
}