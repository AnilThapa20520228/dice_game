package com.example.nasa.naavigation;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class player1Activity extends AppCompatActivity {
    private TextView textview;
    private ImageView img8,img9;
    final int[] images = {R.mipmap.dice1, R.mipmap.dice2, R.mipmap.dice3, R.mipmap.dice4, R.mipmap.dice5, R.mipmap.dice6};
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player1);
        String a=getIntent().getStringExtra("imgnum");
        int b=Integer.parseInt(a);
        play=(Button) findViewById(R.id.button3);
        textview=(TextView) findViewById(R.id.textView6);
        textview.setText("Players "+getIntent().getStringExtra("Number")+" Wins");
        img8=(ImageView) findViewById(R.id.imageView8);
        img9=(ImageView) findViewById(R.id.imageView9);
        img8.setImageResource(images[b]);
        img9.setImageResource(images[b]);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }
}
