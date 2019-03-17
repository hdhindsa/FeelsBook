package com.example.a17808.hsdhindsfeelsbook;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;

public class EmotionList {

    protected ArrayList<Emotion> emotionList;


    public EmotionList(){
        emotionList = new ArrayList<Emotion>();
    }


    public ArrayList<Emotion> getEmotionList(){

        return emotionList;
    }

    public void addEmotion(Emotion testEmotion){
        emotionList.add(testEmotion);



    }


    public void removeEmotion(Emotion testEmotion){
        emotionList.remove(testEmotion);


    }

    public void addEmotionBeginning(Emotion testEmotion){
        emotionList.add(0,testEmotion);



    }

    public int size(){
        return emotionList.size();
    }

    public boolean contains(Emotion testEmotion){
        return emotionList.contains(testEmotion);
    }
}


