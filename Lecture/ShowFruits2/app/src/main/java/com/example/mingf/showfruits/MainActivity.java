package com.example.mingf.showfruits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fruitBtnClickHandler(View view) {
        showFoodView("Fruit", R.drawable.fruit);
    }

    public void vegBtnClickHandler(View view) {
        showFoodView("Vegetable", R.drawable.veg);
    }

    public void drinkBtnClickHandler(View view) {
        showFoodView("Drink", R.drawable.drink);
    }

    private void showFoodView(String foodName, int foodImage) {
        GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        globalVariable.setImage(foodImage);
        globalVariable.setName(foodName);

        Intent intent = new Intent(getBaseContext(), FoodView.class);
        startActivity(intent); // transmit data from intent
    }
}
