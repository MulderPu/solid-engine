package com.example.mingf.lightme;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LightMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_me);
    }

    public void toggleBulb(View view) {
        ImageView onImageView = (ImageView) findViewById(R.id.onImageView);
        ImageView offImageView = (ImageView) findViewById(R.id.offImageView);

        if(onImageView.getVisibility() == View.VISIBLE){
            onImageView.setVisibility(View.GONE);
            offImageView.setVisibility(View.VISIBLE);
        }else{
            offImageView.setVisibility(View.GONE);
            onImageView.setVisibility(View.VISIBLE);
        }
    }
}
