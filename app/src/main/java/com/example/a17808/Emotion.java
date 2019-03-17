package com.example.a17808.hsdhindsfeelsbook;

public class Emotion {

    protected String emotion;
    protected String comment;
    private String timeStamp;
    public Emotion(String emotion){
        this.emotion = emotion;


    }

    public String getEmotion() {

        return this.emotion;
    }

    //public String comment (String emotion, String comments) {
      //  return comments;
    //}

    public void setComment (Emotion emotion,String comments){
        this.comment = comments;
    }

    public String getComment(){
        return this.comment;
    }
    public void setTimeStamp (Emotion emotion,String timeStamp){
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp(){
        return this.timeStamp;
    }
}
