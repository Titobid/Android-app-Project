package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;



// telephony

import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

// email

import android.net.NetworkInfo;
import android.app.AlertDialog;
import android.net.ConnectivityManager;

// web

import android.webkit.WebView;
import android.webkit.WebViewClient;

// maps

public class ContactActivity extends AppCompatActivity {
    String[] items = new String[] { "Call", "Write", "Visit", "Find" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_activity);

        ListView contactListView = findViewById(R.id.contactListView);
        contactListView.setAdapter(new ContactAdapter(this, items));
        contactListView.setTextFilterEnabled(true);
        contactListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String selectedValue = (String) parent.getItemAtPosition(position);

                if (selectedValue.equals("Call")) {
                    call("tel:7097587091");
                } else if (selectedValue.equals("Write")) {
                    sendEmail();
                } else if (selectedValue.equals("Visit")) {
                    loadWebsite("https://www.cna.nl.ca");
                } else if (selectedValue.equals("Find")) {
                    loadWebsite("https://www.google.com/maps");
                }
            }
        });
    }

    private void call(String pn) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse(pn));
        try {
            startActivity(callIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ContactActivity.this, "There are no phone clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendEmail() {
        if (!isNetworkAvailable()) {
            new AlertDialog.Builder(ContactActivity.this)
                    .setTitle("Error").setMessage("No Network Connection")
                    .setNeutralButton("Close", null).show();
        } else {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"bc170264@gmail.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "ETC Programs Info");
            // i.putExtra(Intent.EXTRA_TEXT, "body of email");
            try {
                startActivity(Intent.createChooser(emailIntent, "Complete Action Using"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(ContactActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public void loadWebsite(String url) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(webIntent);
    }
}
