package com.example.a17808.hsdhindsfeelsbook;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.a17808.hsdhindsfeelsbook.EmotionListController.createEmotionList;


public class MainActivity extends AppCompatActivity{

    public static Boolean check = false;

    private static final String LOVE_COUNT = "MY_LOVE_COUNT";
    private static final String FEAR_COUNT = "MY_FEAR_COUNT";
    private static final String SADNESS_COUNT = "MY_SADNESS_COUNT";
    private static final String SURPRISE_COUNT = "MY_SURPRISE_COUNT";
    private static final String ANGER_COUNT = "MY_ANGER_COUNT";
    private static final String JOY_COUNT = "MY_JOY_COUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!check) {
            check = true;
            countLove += getCountLove();
            countFear += getCountFear();
            countSadness += getCountSadness();
            countSurprise += getCountSurprise();
            countAnger += getCountAnger();
            countJoy += getCountJoy();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.history:
                Intent intent1 = new Intent(this, History.class);
                this.startActivity(intent1);
                return true;
            case R.id.count:
                Intent intent2 = new Intent(this, Count.class);
                this.startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public static int countLove = 0;
    public static int countFear = 0;
    public static int countAnger = 0;
    public static int countSurprise = 0;
    public static int countSadness = 0;
    public static int countJoy = 0;


    public void recordComment(View view) {
         int id = view.getId();
         if (id == R.id.buttonLove) {
             countLove += 1;
             Toast.makeText(getApplicationContext(), "Love Recorded", Toast.LENGTH_SHORT).show();
         }
         if (id == R.id.buttonJoy) {
             countJoy += 1;
             Toast.makeText(getApplicationContext(), "Joy Recorded", Toast.LENGTH_SHORT).show();
         }
         if (id == R.id.buttonSurprise) {
             countSurprise += 1;
             Toast.makeText(getApplicationContext(), "Surprise Recorded", Toast.LENGTH_SHORT).show();
         }
         if (id == R.id.buttonAnger) {
             countAnger += 1;
             Toast.makeText(getApplicationContext(), "Anger Recorded", Toast.LENGTH_SHORT).show();
             }
         if (id == R.id.buttonSadness) {
             countSadness += 1;
             Toast.makeText(getApplicationContext(), "Sadness Recorded", Toast.LENGTH_SHORT).show();
         }
         if (id == R.id.buttonFear) {
             countFear += 1;
             Toast.makeText(getApplicationContext(), "Fear Recorded", Toast.LENGTH_SHORT).show();
         }


         Button buttonFeeling = (Button) view;

         Intent intent = new Intent(MainActivity.this, Comment.class);
        // EditText commentField = findViewById(R.id.CommentField);
         //commentField.setText(commentField.getText().toString()+"\n"+currentTimeStamp);


         //TextView showemotion = findViewById(R.id.displayEmotion);
         EmotionListController feel = new EmotionListController();
         feel.addComment(new Emotion(buttonFeeling.getText().toString()));
         startActivity(intent);


         //showemotion.setText(buttonFeeling.getText().toString());
     }
    public void saveCountLove() {
        SharedPreferences sp = this.getSharedPreferences(LOVE_COUNT, Activity.MODE_PRIVATE);

        SharedPreferences.Editor LoveEdit = sp.edit();

        LoveEdit.putInt("love", countLove);
        LoveEdit.commit();
    }

    public int getCountLove() {
        SharedPreferences sp = this.getSharedPreferences(LOVE_COUNT, Activity.MODE_PRIVATE);

        int loveTally = sp.getInt("love", 0);
        return loveTally;
    }
    public void saveCountFear() {
        SharedPreferences sp = this.getSharedPreferences(FEAR_COUNT, Activity.MODE_PRIVATE);

        SharedPreferences.Editor FearEdit = sp.edit();

        FearEdit.putInt("fear", countFear);
        FearEdit.commit();
    }

    public int getCountFear() {
        SharedPreferences sp = this.getSharedPreferences(FEAR_COUNT, Activity.MODE_PRIVATE);

        int fearTally = sp.getInt("fear", 0);
        return fearTally;
    }
    public void saveCountSadness() {
        SharedPreferences sp = this.getSharedPreferences(SADNESS_COUNT, Activity.MODE_PRIVATE);

        SharedPreferences.Editor SadnessEdit = sp.edit();

        SadnessEdit.putInt("sadness", countSadness);
        SadnessEdit.commit();
    }

    public int getCountSadness() {
        SharedPreferences sp = this.getSharedPreferences(SADNESS_COUNT, Activity.MODE_PRIVATE);

        int sadnessTally = sp.getInt("sadness", 0);
        return sadnessTally;
    }
    public void saveCountSurprise() {
        SharedPreferences sp = this.getSharedPreferences(SURPRISE_COUNT, Activity.MODE_PRIVATE);

        SharedPreferences.Editor SurpriseEdit = sp.edit();

        SurpriseEdit.putInt("surprise", countSurprise);
        SurpriseEdit.commit();
    }

    public int getCountSurprise() {
        SharedPreferences sp = this.getSharedPreferences(SURPRISE_COUNT, Activity.MODE_PRIVATE);

        int surpriseTally = sp.getInt("surprise", 0);
        return surpriseTally;
    }
    public void saveCountAnger() {
        SharedPreferences sp = this.getSharedPreferences(ANGER_COUNT, Activity.MODE_PRIVATE);

        SharedPreferences.Editor AngerEdit = sp.edit();

        AngerEdit.putInt("anger", countAnger);
        AngerEdit.commit();
    }

    public int getCountAnger() {
        SharedPreferences sp = this.getSharedPreferences(ANGER_COUNT, Activity.MODE_PRIVATE);

        int angerTally = sp.getInt("anger", 0);
        return angerTally;
    }
    public void saveCountJoy() {
        SharedPreferences sp = this.getSharedPreferences(JOY_COUNT, Activity.MODE_PRIVATE);

        SharedPreferences.Editor JoyEdit = sp.edit();

        JoyEdit.putInt("joy", countJoy);
        JoyEdit.commit();
    }

    public int getCountJoy() {
        SharedPreferences sp = this.getSharedPreferences(JOY_COUNT, Activity.MODE_PRIVATE);

        int joyTally = sp.getInt("joy", 0);
        return joyTally;
    }



    public void onStop() {
        saveCountLove();
        saveCountFear();
        saveCountAnger();
        saveCountJoy();
        saveCountSadness();
        saveCountSurprise();
        super.onStop();
    }




}
