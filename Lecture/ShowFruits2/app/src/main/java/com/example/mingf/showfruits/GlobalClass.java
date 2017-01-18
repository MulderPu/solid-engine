package com.example.mingf.showfruits;

import android.app.Application;

/**
 * Created by mingf on 1/18/2017.
 */

public class GlobalClass extends Application{
    private int image;
    private String name;

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GlobalClass(String name, int image){
        this.name=name;
        this.image = image;
    }

    public GlobalClass(){

    }
}
