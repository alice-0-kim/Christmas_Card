package com.example.android.myplannerver2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;
    ImageView heart;
    int[] drawables = new int[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawables[0] = R.drawable.reindeer;
        drawables[1] = R.drawable.santa;
        drawables[2] = R.drawable.tree;
        heart = (ImageView) findViewById(R.id.heart);
        heart.setAdjustViewBounds(true);
        heart.setMaxHeight(200);
        heart.setMaxWidth(200);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();

            }
        }, SPLASH_TIME_OUT);
        Timer timer = new Timer();

        MyTimer myTimer = new MyTimer();

        //We schedule the timer task to run after 1000 ms and continue to run every 1000 ms.
        timer.schedule(myTimer, 800, 800);
    }

    //An inner class which is an implementation of the TImerTask interface to be used by the Timer.
    class MyTimer extends TimerTask {
        private int counter = 0;

        public void run() {

            //This runs in a background thread.
            //We cannot call the UI from this thread, so we must call the main UI thread and pass a runnable
            runOnUiThread(new Runnable() {

                public void run() {
                    heart.setImageResource(drawables[counter%3]);
                    if (counter == 2) {
                        counter = 0;
                    } else {
                        counter++;
                    }
                    /*textView.setTextColor(Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));*/
                }
            });
        }
    }
}
