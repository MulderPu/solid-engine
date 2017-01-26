package com.example.mingf.assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewPersonality;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String text = "Mike Wazowski is a proud and confident monster. Mike has a romantic side" +
                ", shown by his dating Celia Mae, presumably the one Mike wants to tie the knot with," +
                "and refers to as his " + "<b>" + "schmoopsie-poo" + "</b>" + " although he has a self-centered side";
        textViewPersonality = (TextView) findViewById(R.id.textViewPersonality2);
        textViewPersonality.setText(Html.fromHtml(text));
    }
}
