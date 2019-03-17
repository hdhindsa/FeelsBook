package com.example.a17808.hsdhindsfeelsbook;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class EmotionListController  {

    private static EmotionList emotionList = null;


    static public EmotionList createEmotionList() {
        if (emotionList == null){
            emotionList = new EmotionList();
        }
        return emotionList;

    }


    public void addComment(Emotion emotion){
        createEmotionList().addEmotion(emotion);

    }

    public void addCommentBeginning(Emotion emotion){
        createEmotionList().addEmotionBeginning(emotion);

    }



}
