package com.example.assignmet_2quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv1 = findViewById(R.id.textView3);
        tv2 = findViewById(R.id.textView42);

        Intent i = getIntent();

        String s1 = i.getStringExtra("surah");
        String s2 = i.getStringExtra("ayat");

        tv1.setText(s1);
        tv2.setText(s2);


    }
}