package com.example.a17808.hsdhindsfeelsbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.ZonedDateTime;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.a17808.hsdhindsfeelsbook.EmotionListController.createEmotionList;

public class Comment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_comment);
        ArrayList emotionList = createEmotionList().getEmotionList();
        TextView showemotion = findViewById(R.id.displayEmotion);
        showemotion.setText(createEmotionList().getEmotionList().get(emotionList.size() -1).getEmotion());
    }

    public void addEmotionComment(View v) {
        Toast.makeText(this, "Adding Comment", Toast.LENGTH_SHORT).show();



        //EmotionListController feel = new EmotionListController();
        EditText commentField = (EditText) findViewById(R.id.CommentField);

        //feel.addComment(new Emotion(commentField.getText().toString()));


        ArrayList emotionList = createEmotionList().getEmotionList();
        //TextView showemotion = findViewById(R.id.displayEmotion);
        //showemotion.setText(createEmotionList().getEmotionList().get(emotionList.size() -1).getEmotion());


        Emotion currentEmotion = createEmotionList().getEmotionList().get(emotionList.size() -1);

        currentEmotion.setComment(currentEmotion,commentField.getText().toString());


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


        ZoneId zone = ZoneId.of("Canada/Mountain");
        LocalTime time = LocalTime.now(zone);
        LocalDate date = LocalDate.now(zone);


        Button buttonFeeling = (Button) v;
        EditText timeStampShow = (EditText) findViewById(R.id.timeStamp);

        String dateTime = date.toString() + "T"+time.format(formatter);
        timeStampShow.setText(dateTime);

        currentEmotion.setTimeStamp(currentEmotion,timeStampShow.getText().toString());
        
    }

    public void skipAddingComment(View v){
        EditText commentField = (EditText) findViewById(R.id.CommentField);

        ArrayList emotionList = createEmotionList().getEmotionList();

        Emotion currentEmotion = createEmotionList().getEmotionList().get(emotionList.size() -1);

        currentEmotion.setComment(currentEmotion,"No Comment");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


        ZoneId zone = ZoneId.of("Canada/Mountain");
        LocalTime time = LocalTime.now(zone);
        LocalDate date = LocalDate.now(zone);


        Button buttonFeeling = (Button) v;
        EditText timeStampShow = (EditText) findViewById(R.id.timeStamp);

        String dateTime = date.toString() + "T"+time.format(formatter);
        timeStampShow.setText(dateTime);

        currentEmotion.setTimeStamp(currentEmotion,timeStampShow.getText().toString());
    }

}
