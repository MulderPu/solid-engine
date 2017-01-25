package com.example.mingf.imagenote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView textViewRate, textViewDate, textViewShare, textViewName, textViewShortDesc, textViewUrl, textViewKeywords, textViewOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        init();
    }

    private void init() {
        textViewRate = (TextView) findViewById(R.id.textViewRate2);
        textViewDate = (TextView) findViewById(R.id.textViewDate2);
        textViewShare = (TextView) findViewById(R.id.textViewShare2);
        textViewName = (TextView) findViewById(R.id.textViewName2);
        textViewShortDesc = (TextView) findViewById(R.id.textViewDesc2);
        textViewUrl = (TextView) findViewById(R.id.textViewUrl2);
        textViewKeywords = (TextView) findViewById(R.id.textViewKeywords2);
        textViewOwner = (TextView) findViewById(R.id.textViewEmail2);

        Bundle dataBundle = getIntent().getExtras();
        if (dataBundle != null) {
            //get data passed from previous activity
            String rating = dataBundle.getString("rating");
            String date = dataBundle.getString("date");
            String share = dataBundle.getString("share");
            String name = dataBundle.getString("name");
            String desc = dataBundle.getString("desc");
            String url = dataBundle.getString("url");
            String keywords = dataBundle.getString("keywords");
            String email = dataBundle.getString("email");

            textViewRate.setText(rating);
            textViewDate.setText(date);
            textViewShare.setText(share);
            textViewOwner.setText(email);
            textViewKeywords.setText(keywords);
            textViewUrl.setText(url);
            textViewShortDesc.setText(desc);
            textViewName.setText(name);
        }
    }
}
