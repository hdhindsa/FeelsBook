package com.example.a17808.hsdhindsfeelsbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static com.example.a17808.hsdhindsfeelsbook.EmotionListController.createEmotionList;
import static com.example.a17808.hsdhindsfeelsbook.MainActivity.countAnger;
import static com.example.a17808.hsdhindsfeelsbook.MainActivity.countFear;
import static com.example.a17808.hsdhindsfeelsbook.MainActivity.countJoy;
import static com.example.a17808.hsdhindsfeelsbook.MainActivity.countLove;
import static com.example.a17808.hsdhindsfeelsbook.MainActivity.countSadness;
import static com.example.a17808.hsdhindsfeelsbook.MainActivity.countSurprise;

public class Count extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        TextView loveBox = findViewById(R.id.countLove);
        TextView fearBox = findViewById(R.id.countFear);
        TextView angerBox = findViewById(R.id.countAnger);
        TextView sadnessBox = findViewById(R.id.countSadness);
        TextView surpriseBox = findViewById(R.id.countSurprise);
        TextView joyBox = findViewById(R.id.countJoy);

        loveBox.setText("Count Love = "+String.valueOf(countLove));


        fearBox.setText("Count Fear = "+String.valueOf(countFear));


        sadnessBox.setText("Count Sadness = "+String.valueOf(countSadness));


        surpriseBox.setText("Count Surprise = "+String.valueOf(countSurprise));


        angerBox.setText("Count Anger = "+String.valueOf(countAnger));


        joyBox.setText("Count Joy = "+String.valueOf(countJoy));





    }






}
