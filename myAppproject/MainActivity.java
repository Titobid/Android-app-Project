package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myfinalproject.R;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton programsButton = (ImageButton)findViewById(R.id.programsButton);
        programsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent nextScreen = new Intent(getApplicationContext(), ProgramsActivity.class);
                nextScreen.putExtra("message", "Hello from Schedule Activity");
                startActivity(nextScreen);
            }
        });

        ImageButton scheduleButton = (ImageButton)findViewById(R.id.scheduleButton);
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(getApplicationContext(), spinnerActivity.class);
                nextScreen.putExtra("message", "Hello from Schedule Activity");
                startActivity(nextScreen);
            }
        });

        ImageButton calendarButton = (ImageButton)findViewById(R.id.calendarButton);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(getApplicationContext(), NextActivity.class);
                nextScreen.putExtra("message", "Hello from MainActivity");
                startActivity(nextScreen);
            }
        });

        ImageButton contactButton = (ImageButton)findViewById(R.id.contactButton);
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(getApplicationContext(), ContactActivity.class);
                nextScreen.putExtra("message", "Hello from ContactActivity");
                startActivity(nextScreen);
            }
        });

        ImageButton NewsButton = (ImageButton)findViewById(R.id.NewsButton);
        NewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(getApplicationContext(), NewsActivity.class);
                nextScreen.putExtra("message", "Hello from NewsActivity");
                startActivity(nextScreen);
            }
        });

        ImageButton busButton = (ImageButton)findViewById(R.id.busButton);
        busButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Website("http://www.metrobus.com");
            }
        });

        ImageButton emailButton = (ImageButton)findViewById(R.id.emailButton);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();

            }
        });

        Button infoButton = findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show developer information using an AlertDialog
                DevInfo();
            }
        });
    }

    private void DevInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Developer Info");
        builder.setMessage("Name: Titobioluwa John Dada\n" +
                "Passionate about crafting innovative solutions\n" +
                "\n" +
                "Contact:\n" +
                "Email: Titobioluwa.dada39@ed.cna.nl.ca\n" +
                "LinkedIn: https://www.linkedin.com/in/titobioluwa-dada-1b27271b7 \n" +
                "\n" +
                "App Purpose: \n" +
                "The app offers a comprehensive set of features catering to various aspects of college life, including academic programs, events, transportation, class schedules, news updates, contacts, and developer information." +
                "\n" +
                "\n" +
                "Features:\n" +
                "\n" +
                "Programs:\n" +
                "Displays academic programs.\n" +
                "Provides detailed course information from a URL request (XML).\n" +
                "\n" +
                "Calendar:\n" +
                "Presents events like registration, holidays, exams.\n" +
                "Allows users to store personal events using SQLite.\n" +
                "\n" +
                "Metrobus:\n" +
                "Embeds Metrobus' website using Webview.\n" +
                "\n" +
                "Schedule:\n" +
                "Shows class timetables based on program and year.\n" +
                "Retrieves data from URL requests (XML).\n" +
                "\n" +
                "News:\n" +
                "Displays latest news with detailed descriptions.\n" +
                "Fetches news content from URL requests (XML).\n" +
                "\n" +
                "Contacts:\n" +
                "Facilitates phone and email contact within the app.\n" +
                "Integrates Map Kit for location.\n" +
                "Includes a Web View for the college's website.");

        // Add a button to close the dialog
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Show the AlertDialog
        builder.show();
    }

    private void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"Titobioluwa_Dada39@ed.cna.nl.ca"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "ETC Programs Info");

        try {
            startActivity(Intent.createChooser(emailIntent, "Complete Action Using"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void Website(String url) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(webIntent);
    }


    }










