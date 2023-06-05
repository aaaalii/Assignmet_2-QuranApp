package com.example.assignmet_2quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

        EditText et;
        TextView tv;
        ListView lv;
        Button b;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            et = findViewById(R.id.editTextNumber);
            tv = findViewById(R.id.surahName);
            lv = findViewById(R.id.surah);
            b= findViewById(R.id.button);

            Intent i = getIntent();
            String name = i.getStringExtra("surah");
            tv.setText(name);
            int st = i.getIntExtra("surahStartingAyat", 0);
            int end = i.getIntExtra("surahEndingAyat", 0);

            ArrayList<String> surah = new ArrayList<>();

            for(int it = st -1; it < end - 1; it++){
                surah.add(QuranArabicText.QuranArabicText[it]);
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , surah);

            lv.setAdapter(arrayAdapter);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText()== null){
                        return;
                    }
                    else{
                        int ayat = Integer.parseInt(et.getText().toString());

                        int total = st - end;

                        if(ayat>total){
                            String ac =  "Surah " + surah + " has max " + (total) + " ayats.";
                            Toast.makeText(MainActivity2.this, ac, Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Intent in = new Intent(MainActivity2.this , MainActivity3.class);
                            in.putExtra("surah" , name);
                            in.putExtra("ayat" , surah.get(ayat));

                            startActivity(in);
                        }
                    }
                }
            });


    }
}