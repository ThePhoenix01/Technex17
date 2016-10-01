package org.piratejester.technex17.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.piratejester.technex17.R;

public class Splash extends AppCompatActivity {

    private String MY_PREFS_NAME="MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    SharedPreferences pref=getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
                    boolean loc=pref.getBoolean("LoginStat", false);
                    int c=0;


                    if(loc){
                        Intent i = new Intent(Splash.this, HomeActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        Intent i;
                        i=new Intent(Splash.this,LoginActivity.class);
                        startActivity(i);
                        finish();
                    }

                }

            }

        };
        timer.start();

    }
}