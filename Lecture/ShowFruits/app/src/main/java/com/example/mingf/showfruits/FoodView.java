package com.example.mingf.showfruits;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_view);
        initializeUI();
    }

    private void initializeUI() {
        Bundle dataBundle = getIntent().getExtras();

        if( dataBundle != null){
            //get data passed from previous activity
            String foodName = dataBundle.getString("name");
            Drawable foodImg =  ResourcesCompat.getDrawable(getResources(), dataBundle.getInt("image"), null);

            //get handles to the views that we need to change -- change data
            TextView foodTextView = (TextView) findViewById(R.id.foodTextView);
            ImageView foodImageView = (ImageView) findViewById(R.id.foodImageView);

            foodTextView.setText(foodName);
            foodImageView.setImageDrawable(foodImg);
        }
    }
}
