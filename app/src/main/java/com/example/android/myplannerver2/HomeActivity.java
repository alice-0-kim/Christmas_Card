package com.example.android.myplannerver2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView anniversity = (TextView) findViewById(R.id.anniversity);
        anniversity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(HomeActivity.this, AnniversityActivity.class);
                startActivity(numbersIntent);
            }
        });
        TextView photos = (TextView) findViewById(R.id.photos);
        photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(HomeActivity.this, PhotoActivity.class);
                startActivity(numbersIntent);
            }
        });
    }
}
