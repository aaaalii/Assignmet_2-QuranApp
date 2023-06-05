package com.example.assignmet_2quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

        EditText et;
        TextView tv;
        ListView lv;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            et = findViewById(R.id.editTextNumber);
            tv = findViewById(R.id.surahName);
            lv = findViewById(R.id.surah);

            Intent i = getIntent();
            String name = i.getStringExtra("surah");
            int st = i.getIntExtra("surahStartingAyat", 0);
            int end = i.getIntExtra("surahEndingAyat", 0);

            ArrayList<String> surah = new ArrayList<>();

            for(int it = st -1; it < end - 1;it++){
                surah.add(QuranArabicText.QuranArabicText[it]);
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , surah);

            lv.setAdapter(arrayAdapter);


    }
}