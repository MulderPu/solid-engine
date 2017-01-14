package com.example.mingf.task6;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView text;
    Button btnTrue;
    Button btnFalse;
    Button btnNext;

    int i=0;
    boolean ans;
    boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTrue = (Button) findViewById(R.id.button);
        btnFalse = (Button) findViewById(R.id.button2);
        btnNext = (Button) findViewById(R.id.button3);
        btnTrue.setOnClickListener(this);
        btnFalse.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        text = (TextView) findViewById(R.id.textView);
        text.setText(mQuestionBank[i].getQuestion());

    }

    //array of objects to store questions and answer
    public Question[] mQuestionBank = new Question[] {
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
                ans = mQuestionBank[i].getB();
                clicked = true;
                //display in short period of time
//                Toast.makeText(getApplicationContext(), "True clicked.",
//                        Toast.LENGTH_SHORT).show();

                if( ans == true){

                    Snackbar.make(findViewById(android.R.id.content), "CORRECT !", Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener(){
                                @Override
                                public void onClick(View view) {
                                }
                            })
                            .setActionTextColor(Color.GREEN)
                            .show();

                }else{
                    Snackbar.make(findViewById(android.R.id.content), "INCORRECT !", Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener(){
                                @Override
                                public void onClick(View view) {
                                }
                            })
                            .setActionTextColor(Color.GREEN)
                            .show();
                }
                break;

            case R.id.button2:
                ans = mQuestionBank[i].getB();
                clicked = true;
                //display in short period of time
//                Toast.makeText(getApplicationContext(), "False clicked.",
//                        Toast.LENGTH_SHORT).show();

                if( ans == false){

                    Snackbar.make(findViewById(android.R.id.content), "CORRECT !", Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener(){
                                @Override
                                public void onClick(View view) {
                                }
                            })
                            .setActionTextColor(Color.GREEN)
                            .show();

                }else{
                    Snackbar.make(findViewById(android.R.id.content), "INCORRECT !", Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener(){
                                @Override
                                public void onClick(View view) {
                                }
                            })
                            .setActionTextColor(Color.GREEN)
                            .show();
                }
                break;

            case R.id.button3:

                    i++;
                    text.setText(mQuestionBank[i].getQuestion());
                    ans = mQuestionBank[i].getB();

                    if(Integer.toString(i) == "4"){
                        Toast.makeText(getApplicationContext(), "End of Questions.",
                                Toast.LENGTH_SHORT).show();
                        btnNext.setEnabled(false);

                    }

                break;

            default:
                break;
        }
    }
}
