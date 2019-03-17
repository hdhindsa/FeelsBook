package com.example.a17808.hsdhindsfeelsbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.a17808.hsdhindsfeelsbook.EmotionListController.createEmotionList;
import static com.example.a17808.hsdhindsfeelsbook.History.POSITION;
import static com.example.a17808.hsdhindsfeelsbook.MainActivity.countAnger;
import static com.example.a17808.hsdhindsfeelsbook.MainActivity.countFear;
import static com.example.a17808.hsdhindsfeelsbook.MainActivity.countJoy;
import static com.example.a17808.hsdhindsfeelsbook.MainActivity.countLove;
import static com.example.a17808.hsdhindsfeelsbook.MainActivity.countSadness;
import static com.example.a17808.hsdhindsfeelsbook.MainActivity.countSurprise;

public class Editer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_emotion);

        EditText editField = (EditText) findViewById(R.id.editText);
        String position;
        position = getIntent().getStringExtra(POSITION);
        String timeStamp = createEmotionList().getEmotionList().get(Integer.parseInt(position)).getTimeStamp();
        String emotionName = createEmotionList().getEmotionList().get(Integer.parseInt(position)).getEmotion();
        String emotionCommment =createEmotionList().getEmotionList().get(Integer.parseInt(position)).getComment();
        editField.setText("Comment:  "+emotionCommment+"\n"+"\n"+"Time Stamp:  "+String.format(timeStamp));
        TextView emotionField = findViewById(R.id.emotionField);
        emotionField.setText("Emotion:  "+emotionName);
    }


    public void saveChanges(View v) {
        Toast.makeText(this, "Saving Changes", Toast.LENGTH_SHORT).show();


        EditText editField = (EditText) findViewById(R.id.editText);
        String position;
        position = getIntent().getStringExtra(POSITION);

        String edittedText = editField.getText().toString();
        String[] parts = edittedText.split("\n");
        String newComment = parts[0].substring(10).trim();
        String newTimeStamp = parts[2].substring(12).trim();


        Emotion emotionName = createEmotionList().getEmotionList().get(Integer.parseInt(position));
        createEmotionList().getEmotionList().get(Integer.parseInt(position)).setTimeStamp(emotionName,newTimeStamp);
        createEmotionList().getEmotionList().get(Integer.parseInt(position)).setComment(emotionName,newComment);


        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }

    public void deleteEmotion(View view){
        Toast.makeText(this, "Emotion Deleted", Toast.LENGTH_SHORT).show();

        String position;
        position = getIntent().getStringExtra(POSITION);

        EmotionList emotionList = createEmotionList();
        Emotion currentEmotion = createEmotionList().getEmotionList().get(Integer.parseInt(position));
        if (currentEmotion.getEmotion().equals("Love")){
           countLove -= 1;
        }
        if (currentEmotion.getEmotion().equals("Joy")){
           countJoy -= 1;
        }
        if (currentEmotion.getEmotion().equals("Surprise") ){
            countSurprise -= 1;
        }
        if (currentEmotion.getEmotion().equals("Sadness")){
            countSadness -= 1;
       }
        if (currentEmotion.getEmotion().equals("Anger")){
            countAnger -= 1;
        }
       if (currentEmotion.getEmotion().equals("Fear")){
            countFear -= 1;
        }
        emotionList.removeEmotion(currentEmotion);



        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }

}