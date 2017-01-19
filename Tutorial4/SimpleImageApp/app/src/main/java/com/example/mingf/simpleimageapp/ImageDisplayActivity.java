package com.example.mingf.simpleimageapp;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);

        initializeUI();
    }

    private void initializeUI() {
        Bundle dataBundle = getIntent().getExtras();

        if( dataBundle != null){
            //get data passed from previous activity
            String foodName = dataBundle.getString("name");
            Drawable foodImg =  ResourcesCompat.getDrawable(getResources(), dataBundle.getInt("image"), null);
            String foodDesc = dataBundle.getString("desc");

            //get handles to the views that we need to change -- change data
            TextView foodTextView = (TextView) findViewById(R.id.foodTextView);
            ImageView foodImageView = (ImageView) findViewById(R.id.foodImageView);
            TextView foodTextView3 = (TextView) findViewById(R.id.foodTextView3);

            foodTextView.setText(foodName);
            foodImageView.setImageDrawable(foodImg);
            foodTextView3.setText(foodDesc);
        }
    }
}
