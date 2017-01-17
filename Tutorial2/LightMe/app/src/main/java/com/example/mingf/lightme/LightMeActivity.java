package com.example.mingf.lightme;

import android.os.Bundle;
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
        init();
    }

    private void init() {
        offImageView = (ImageView) findViewById(R.id.offImageView);
        offImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        view.setPressed(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        view.setPressed(false);
                        break;
                }

                return true;
            }
        });

    }

}
