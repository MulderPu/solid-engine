package com.example.mingf.lightme;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class LightMeActivity extends AppCompatActivity {

    ImageView offImageView;
    public int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_me);

        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        offImageView = (ImageView) findViewById(R.id.offImageView);
        offImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ImageView imageView = (ImageView) view;
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    // Button was pressed, change button background
                    imageView.setImageResource(R.drawable.on);
                    return true;
                } else if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    // Button was released, reset button background
                    imageView.setImageResource(R.drawable.off);
                    return true;
                }

                return false;
            }
        });

        if( savedInstanceState != null){
            image = savedInstanceState.getInt("image", R.drawable.on);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("image", R.drawable.on );
    }
}
