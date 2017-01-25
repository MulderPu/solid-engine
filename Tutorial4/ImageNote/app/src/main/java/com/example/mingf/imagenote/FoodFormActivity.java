package com.example.mingf.imagenote;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class FoodFormActivity extends Activity implements View.OnClickListener {
    private DatePicker datePicker;
    private Calendar calendar;
    private Button dateView, btnSubmit;
    private int year, month, day;
    private ImageView foodImageView;
    private EditText foodEditText, foodShortDesc, foodOwner, foodUrl, foodKeywords;
    private RatingBar ratingBar;
    private String date;
    private ToggleButton togglebutton;
    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2 + 1, arg3);
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_form);

        initializeUI();
    }

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
        date = dateView.getText().toString();
    }

    private void initializeUI() {

        btnSubmit = (Button) findViewById(R.id.buttonSubmit);
        btnSubmit.setOnClickListener(this);
        dateView = (Button) findViewById(R.id.buttonDateView);
        foodImageView = (ImageView) findViewById(R.id.foodImageView);
        foodEditText = (EditText) findViewById(R.id.editTextFoodName);
        foodShortDesc = (EditText) findViewById(R.id.editTextFoodDesc);
        foodUrl = (EditText) findViewById(R.id.editTextUrl);
        foodKeywords = (EditText) findViewById(R.id.editTextKeywords);
        foodOwner = (EditText) findViewById(R.id.editTextEmail);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        togglebutton = (ToggleButton) findViewById(R.id.toggleButtonShare);

        Bundle dataBundle = getIntent().getExtras();
        if (dataBundle != null) {
            //get data passed from previous activity
            String foodName = dataBundle.getString("name");
            Drawable foodImg = ResourcesCompat.getDrawable(getResources(), dataBundle.getInt("image"), null);

            foodEditText.setText(foodName);
            foodImageView.setImageDrawable(foodImg);
        }

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "calendar",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    @Override
    public void onClick(View view) {


        Bundle bundle = new Bundle();
        String email = foodOwner.getText().toString();
        String name = foodEditText.getText().toString();

        if (name.matches("")) {
            Toast.makeText(this, "You did not enter name", Toast.LENGTH_SHORT).show();
        } else if (email.matches("")) {
            Toast.makeText(this, "You did not enter email", Toast.LENGTH_SHORT).show();
        } else {
            bundle.putString("email", String.valueOf(foodOwner.getText()));
            bundle.putString("rating", String.valueOf(ratingBar.getRating()));
            bundle.putString("share", String.valueOf(togglebutton.getText().toString()));
            bundle.putString("name", String.valueOf(foodEditText.getText()));
            bundle.putString("url", String.valueOf(foodUrl.getText()));
            bundle.putString("desc", String.valueOf(foodShortDesc.getText()));
            bundle.putString("keywords", String.valueOf(foodKeywords.getText()));
            bundle.putString("date", date);

            //Set the sender and the receiver of the intent
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), ResultActivity.class);
            intent.putExtras(bundle);

            startActivity(intent);
        }
    }
}
