package com.example.hal_kumar.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.interceptors.ParseLogInterceptor;

public class MainActivity extends AppCompatActivity {
    private static boolean isParseInitialized = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(isParseInitialized==false) {
            Parse.initialize(new Parse.Configuration.Builder(this)
                    .applicationId("app") // should correspond to APP_ID env variable
                    .clientKey(null)// set explicitly unless clientKey is explicitly configured on Parse server
                    .addNetworkInterceptor(new ParseLogInterceptor())
                    .server("http://192.168.1.3:1337/parse/").build());
            isParseInitialized = true;
        }
        ParseInstallation.getCurrentInstallation().saveInBackground();
        ParseObject gameScore = new ParseObject("GameScore");
        gameScore.put("score", 123);
        gameScore.put("playerName", "Novak");
        gameScore.put("cheatMode", false);
        gameScore.saveInBackground();
        final ParseInstallation parseInstallation = ParseInstallation.getCurrentInstallation();
        parseInstallation.put("GCMSenderId","584878908926");
        parseInstallation.saveInBackground();

    }

}
