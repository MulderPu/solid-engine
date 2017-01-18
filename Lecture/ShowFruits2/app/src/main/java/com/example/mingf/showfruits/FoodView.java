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
        TextView foodTextView = (TextView) findViewById(R.id.foodTextView);
        ImageView foodImageView = (ImageView) findViewById(R.id.foodImageView);

        GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        String foodName = globalVariable.getName();
        int foodImage = globalVariable.getImage();

        foodImageView.setImageResource(foodImage);
        foodTextView.setText(foodName);
    }
}
