package com.example.mingf.simpleimageapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity implements View.OnClickListener {
    ImageButton imgLaksa;
    ImageButton imgNasiLemak;
    ImageButton imgKompia;
    ImageButton imgKuihTepung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        imgLaksa = (ImageButton) findViewById(R.id.imageLaksa);
        imgNasiLemak = (ImageButton) findViewById(R.id.imageNasiLemak);
        imgKompia = (ImageButton) findViewById(R.id.imageKompia);
        imgKuihTepung = (ImageButton) findViewById(R.id.imageKuihTepung);

        imgLaksa.setOnClickListener(this);
        imgNasiLemak.setOnClickListener(this);
        imgKompia.setOnClickListener(this);
        imgKuihTepung.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String foodName;
        int foodImage;
        String foodDesc;
        switch (view.getId()) {
            case R.id.imageLaksa:
                foodName = "Sarawak Laksa";
                foodImage = R.drawable.laksa;
                foodDesc = getString(R.string.laksaDesc1) +
                        getString(R.string.laksaDesc2);

                showImage(foodName,foodImage,foodDesc);
                break;
            case R.id.imageNasiLemak:
                foodName = "Sarawak Nasi Lemak";
                foodImage = R.drawable.nasi_lemak;
                foodDesc = getString(R.string.nLemakDesc1) +
                        getString(R.string.nLemakDesc2) +
                        getString(R.string.nLemakDesc3) +
                        getString(R.string.nLemakDesc4);

                showImage(foodName,foodImage,foodDesc);
                break;
            case R.id.imageKompia:
                foodName = "Sarawak Kompia";
                foodImage = R.drawable.kompia;
                foodDesc = getString(R.string.kompiaDesc);

                showImage(foodName,foodImage,foodDesc);
                break;
            case R.id.imageKuihTepung:
                foodName = "Sarawak Kuih Tepung Pelita";
                foodImage = R.drawable.kuih_tepung_pelita;
                foodDesc = getString(R.string.kuihTPDesc1) +
                        getString(R.string.kuihTPDesc2);

                showImage(foodName,foodImage,foodDesc);
                break;
            default:
                break;
        }
    }

    private void showImage(String foodName, int foodImage, String foodDesc) {
        Bundle dataBundle = new Bundle();
        dataBundle.putString("name", foodName);
        dataBundle.putInt("image", foodImage);
        dataBundle.putString("desc", foodDesc);

        Intent i = new Intent(MainActivity.this, ImageDisplayActivity.class);
        i.putExtras(dataBundle); // store data that needed to sent
        startActivity(i);
    }
}
