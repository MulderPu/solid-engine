package com.example.mingf.tempconvertor;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TempActivity extends Activity implements View.OnClickListener {
    EditText inputTemp;
    TextView convertResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        init();
    }

    private void init() {
        Button btnConvert = (Button) findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(this);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        inputTemp = (EditText) findViewById(R.id.inputTempEditText);
        convertResult = (TextView) findViewById(R.id.result);

        inputTemp.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                // If the event is a key-down event on the "enter" button
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (i == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    String string = convertToFh(inputTemp.getText().toString());
                    convertResult.setText(string + " F");
                    return true;
                }
                return false;
            }
        });
    }

    private String convertToFh(String pCelcius){
        try{
            double c = Double.parseDouble(pCelcius);
            double f = c * (9.0/5.0) + 32.0;
            return String.format("%3.2f",f);

        }catch (NumberFormatException nfe){
            return "0";
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnConvert:
                inputTemp = (EditText) findViewById(R.id.inputTempEditText);
                convertResult = (TextView) findViewById(R.id.result);

                String string = convertToFh(inputTemp.getText().toString());

                convertResult.setText(string + " F");
                break;
            case R.id.btnClear:
                inputTemp.setText("");
                convertResult.setText("");
                break;

            default:
                break;
        }
    }
}
