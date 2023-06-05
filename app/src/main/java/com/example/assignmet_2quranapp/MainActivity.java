package com.example.assignmet_2quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> surahNames = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning ArrayList its values
        lv = findViewById(R.id.surahsView);
        for (int i = 0;i < QDH.englishSurahNames.length;i++){
            surahNames.add(QDH.englishSurahNames[i]);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , surahNames);

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click
                String selectedSurahPos = surahNames.get(position);

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("surah" , selectedSurahPos);
                i.putExtra("surahStartingAyat" , QDH.SSP[position]);
                i.putExtra("surahEndingAyat" , (QDH.SSP[position + 1]));
                startActivity(i);
            }
        });



    }
}