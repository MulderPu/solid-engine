package com.example.mingf.task6;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView text;
    Button btnTrue;
    Button btnFalse;
    Button btnNext;
    boolean next = false;
    int i=0;


    TextView text2;
    TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);
        text.setText(mQuestionBank[i].getQuestion());
        boolean ans = mQuestionBank[i].getB();


        text2 = (TextView) findViewById(R.id.textView2);
        if(ans == true) {
            text2.setText("true");
        }else{
            text2.setText("false");
        }

        text = (TextView) findViewById(R.id.textView);
        btnTrue = (Button) findViewById(R.id.button);
        btnFalse = (Button) findViewById(R.id.button2);
        btnNext = (Button) findViewById(R.id.button3);
        btnTrue.setOnClickListener(this);
        btnFalse.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        text3 = (TextView) findViewById(R.id.textView3);
        if(next == true){
            text3.setText("true");
        }else{
            text3.setText("false");
        }

    }

    //array of objects to store questions and answer
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };

    //onclick event listener
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button:

                break;

            case R.id.button2:

                break;

            case R.id.button3:
                next = true;
                break;

            default:
                break;
        }
    }
}
