package com.example.android.myplannerver2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static android.R.attr.id;
import static android.R.attr.text;
import static android.R.attr.textViewStyle;

public class AnniversityActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anniversity);

        textView = (TextView) findViewById(R.id.wish);
        textView.setTextColor(Color.parseColor("#F50057"));


        Timer timer = new Timer();

        MyTimer myTimer = new MyTimer();

        //We schedule the timer task to run after 1000 ms and continue to run every 1000 ms.
        timer.schedule(myTimer, 1000, 1000);
    }

    //An inner class which is an implementation of the TImerTask interface to be used by the Timer.
    class MyTimer extends TimerTask {

        public void run() {

            //This runs in a background thread.
            //We cannot call the UI from this thread, so we must call the main UI thread and pass a runnable
            runOnUiThread(new Runnable() {

                public void run() {
                    Random rand = new Random();
                    //The random generator creates values between [0,256) for use as RGB values used below to create a random color
                    //We call the RelativeLayout object and we change the color.  The first parameter in argb() is the alpha.
                    textView.setTextColor(Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                }
            });
        }
    }
}
