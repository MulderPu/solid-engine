package com.example.mingf.imagenote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

//    public void vegBtnClickHandler(View view) {
//        showFoodView("Vegetable", R.drawable.veg);
//    }
//
//    public void drinkBtnClickHandler(View view) {
//        showFoodView("Drink", R.drawable.drink);
//    }

    private void showFoodView(String foodName, int foodImage) {
        Bundle dataBundle = new Bundle();
        dataBundle.putString("name", foodName);
        dataBundle.putInt("image", foodImage);

        //Set the sender and the receiver of the intent
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), FoodFormActivity.class);
        intent.putExtras(dataBundle); // store data that needed to sent

        startActivity(intent); // transmit data from intent
    }
}
