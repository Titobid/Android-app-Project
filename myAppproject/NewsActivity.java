package com.example.myfinalproject;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);

        ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mMobile = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if (mWifi.isConnected() == false && mMobile.isConnected() == false) {
            showErrorView();
        }
        else {
            System.out.println("Connected");
            setContentView(R.layout.news_activity);

            findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
            FileDownloader news = new FileDownloader("https://computingsystems.me/etcapp/news/news.xml", NewsActivity.this);
            news.setOnResultsListener(new AsyncResponse() {
                @Override
                public void processFinish(String output) {
                    Intent newsScreen = new Intent(getApplicationContext(), NewsActivitys.class);
                    newsScreen.putExtra("xmlData", output);
                    findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                    startActivity(newsScreen);
                }
            });
            news.execute();
        }
    }

    private void showErrorView() {
        setContentView(R.layout.error_layout);
        TextView errorView = (TextView) findViewById(R.id.errorMessage);
        errorView.setText("App cannot connect to network. Check network settings and try again.");
    }
}
