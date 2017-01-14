package com.example.mingf.task6;

/**
 * Created by mingf on 1/13/2017.
 */
public class Question {
    private int question;
    private boolean bool;

    public Question(int question, boolean bool){
        this.question = question;
        this.bool = bool;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public boolean getB(){
        return bool;
    }

    public void setB(boolean bool) {
        this.bool = bool;
    }

}
