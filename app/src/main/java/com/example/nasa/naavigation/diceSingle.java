package com.example.nasa.naavigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class diceSingle extends AppCompatActivity {
private Button roll,back,play;
    ImageView img1, img2;
    final int[] images = {R.mipmap.dice1, R.mipmap.dice2, R.mipmap.dice3, R.mipmap.dice4, R.mipmap.dice5, R.mipmap.dice6};
    TextView hightxt,rollleft,score,username;
    SharedPreferences preferences,sharedPreferences;
    int count=10,point_scored=0,high_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_single);


        roll = (Button) findViewById(R.id.btnroll);
        back = (Button) findViewById(R.id.btnback);
        play = (Button) findViewById(R.id.button5);
        img1 = (ImageView) findViewById(R.id.singleimg2);
        img2 = (ImageView) findViewById(R.id.singleimg1);
        hightxt=(TextView) findViewById(R.id.txthigh);
        rollleft=(TextView) findViewById(R.id.txtrol);
        username =(TextView) findViewById(R.id.usertext);
        score=(TextView) findViewById(R.id.txtscore);
        play.setEnabled(false);

        preferences = getSharedPreferences("points",MODE_PRIVATE);
        hightxt.setText(String.valueOf(preferences.getInt("pt",0)));
        String max=hightxt.getText().toString();
        high_score= Integer.valueOf(max);

        sharedPreferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        username.setText(String.valueOf(sharedPreferences.getString("display","")));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnback = new Intent(diceSingle.this,MainActivity.class);
                startActivity(btnback);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnplay = new Intent(diceSingle.this,diceSingle.class);
                startActivity(btnplay);
            }
        });

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                rollleft.setText(String.valueOf(count));
                Random RandomNumber = new Random();
                int number1 = RandomNumber.nextInt(6);
                int number2 = RandomNumber.nextInt(6);
                img1.setImageResource(images[number1]);
                img2.setImageResource(images[number2]);
                if (number1 == number2) {
                  point_scored = point_scored + 10;
                  score.setText(String.valueOf(point_scored));
                  if(point_scored>high_score){
                      high_score=point_scored;
                  }

                  SharedPreferences.Editor editor=preferences.edit();
                  editor.putInt("pt",high_score);
                  editor.commit();


                }
                if(count==0){
                    play.setEnabled(true);
                    roll.setEnabled(false);
                }
            }
        });

    }
}
