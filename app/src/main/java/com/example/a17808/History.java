package com.example.a17808.hsdhindsfeelsbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.LV;
import static com.example.a17808.hsdhindsfeelsbook.EmotionListController.createEmotionList;

public class History extends AppCompatActivity {

    public final static String POSITION = "com.example.a17808.hsdhindsfeelsbook._ID";
    public static Boolean check = false;

    ArrayList my = new ArrayList<String>();
    private static final String SHARED_PREFS_NAME = "MY_SHARED_PREF";
    ArrayAdapter<String> adapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        ListView list = (ListView)findViewById(R.id.history);

        //to get size of EmotionList for the loop
        ArrayList emotionList = createEmotionList().getEmotionList();

        //Appends new emotionList to old EmotionList
        if (!check) {
            check = true;
            appendArray();
        }


        //adds emotions as strings in a new arrayList my to diaplay in history
        for(int i = 0; i < emotionList.size(); i++){

            String emotionName = createEmotionList().getEmotionList().get(i).getEmotion();
            String emotionCommment = createEmotionList().getEmotionList().get(i).getComment();
            String timeStamp =  createEmotionList().getEmotionList().get(i).getTimeStamp();

            my.add(String.format("%1$77s", timeStamp)+"\n"+emotionName+"\n"+"Comments:  "+emotionCommment);

        }



        //display arrayList my in history
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  my);
        list.setAdapter(adapter);

        //opens editer when clicked on an item in history
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                TextView temp = (TextView) view;
                String Value = String.valueOf(position);
                Toast.makeText(getApplicationContext(), Value, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(view.getContext(),Editer.class);
                intent.putExtra(POSITION, Value);

                //based on item add info to intent
                startActivity(intent);
                }


        });
    }



    public void appendArray(){
        ArrayList<String> old = new ArrayList<String>();
        old =  getArray();
        int sizeOld = getArray().size();

       for(int i = sizeOld-1; i >= 0; i--){
            String emotionCommentTime = old.get(i);
            String[] parts = emotionCommentTime.split("\n");
            String newEmotion = parts[1].trim();
            String newComment = parts[2].substring(9).trim();
            String newTimeStamp = parts[0].trim();
            createEmotionList().addEmotionBeginning(new Emotion(newEmotion));
            createEmotionList().getEmotionList().get(0).setComment(createEmotionList().getEmotionList().get(0),newComment);
            createEmotionList().getEmotionList().get(0).setTimeStamp(createEmotionList().getEmotionList().get(0), newTimeStamp);

        }
    }
    public void saveArray() {
        SharedPreferences sp = this.getSharedPreferences(SHARED_PREFS_NAME, Activity.MODE_PRIVATE);

        SharedPreferences.Editor mEdit1 = sp.edit();
        Set<String> set = new HashSet<String>();
        set.addAll(my);
        mEdit1.putStringSet("list", set);
        mEdit1.commit();
    }

    public ArrayList<String> getArray() {
        SharedPreferences sp = this.getSharedPreferences(SHARED_PREFS_NAME, Activity.MODE_PRIVATE);

        //NOTE: if shared preference is null, the method return empty Hashset and not null
        Set<String> set = sp.getStringSet("list", new HashSet<String>());

        return new ArrayList<String>(set);
    }

    public void onStop() {
        saveArray();
        super.onStop();
    }



}
