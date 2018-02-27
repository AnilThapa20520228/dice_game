package com.example.nasa.naavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class jhandiActivity extends AppCompatActivity {
    Button roll1;
    ImageView img1, img2,img3,img4,img5,img6;
    final int[] images = {R.mipmap.chidi, R.mipmap.munda, R.mipmap.bhote, R.mipmap.itta, R.mipmap.jhandi, R.mipmap.pana};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jhandi);

        roll1 = (Button) findViewById(R.id.button);
        img1 = (ImageView) findViewById(R.id.imageView);
        img2 = (ImageView) findViewById(R.id.imageView3);
        img3 = (ImageView) findViewById(R.id.imageView4);
        img4 = (ImageView) findViewById(R.id.imageView5);
        img5 = (ImageView) findViewById(R.id.imageView6);
        img6 = (ImageView) findViewById(R.id.imageView7);

        roll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random RandomNumber = new Random();
                int number1 = RandomNumber.nextInt(6);
                int number2 = RandomNumber.nextInt(6);
                int number3 = RandomNumber.nextInt(6);
                int number4 = RandomNumber.nextInt(6);
                int number5 = RandomNumber.nextInt(6);
                int number6 = RandomNumber.nextInt(6);
                img1.setImageResource(images[number1]);
                img2.setImageResource(images[number2]);
                img3.setImageResource(images[number3]);
                img4.setImageResource(images[number4]);
                img5.setImageResource(images[number5]);
                img6.setImageResource(images[number6]);


            }
        });
    }
}
