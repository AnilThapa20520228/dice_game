package com.example.nasa.naavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button roll1, roll2,btnsingleplayer;
    ImageView img1, img2;
    final int[] images = {R.mipmap.dice1, R.mipmap.dice2, R.mipmap.dice3, R.mipmap.dice4, R.mipmap.dice5, R.mipmap.dice6};


    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        toolbar.setTitle("My Profile");
        btnsingleplayer = (Button) findViewById(R.id.btnsingle);
        roll1 = (Button) findViewById(R.id.btnroll);
        roll2 = (Button) findViewById(R.id.button2);
        img1 = (ImageView) findViewById(R.id.singleimg2);
        img2 = (ImageView) findViewById(R.id.singleimg1);
        roll2.setEnabled(false);

        roll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll1.setEnabled(false);
                roll2.setEnabled(true);
                Random RandomNumber = new Random();
                int number1 = RandomNumber.nextInt(6);
                int number2 = RandomNumber.nextInt(6);
                img1.setImageResource(images[number1]);
                img2.setImageResource(images[number2]);

                if (number1 == number2) {
                    String num = String.valueOf(number1);
                    Intent player1 = new Intent(MainActivity.this,player1Activity.class);
                    player1.putExtra("Number","1");
                    player1.putExtra("imgnum",num);
                    startActivity(player1);
                }


            }
        });

        roll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll1.setEnabled(true);
                roll2.setEnabled(false);
                Random RandomNumber = new Random();
                int number1 = RandomNumber.nextInt(6);
                int number2 = RandomNumber.nextInt(6);
                img1.setImageResource(images[number1]);
                img2.setImageResource(images[number2]);
                if (number1 == number2) {
                    String num = String.valueOf(number1);
                    Intent player2 = new Intent(MainActivity.this,player1Activity.class);
                    player2.putExtra("Number","2");
                    player2.putExtra("imgnum",num);
                    startActivity(player2);
                }
            }
        });


        btnsingleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent single = new Intent(MainActivity.this,diceSingle.class);
                    startActivity(single);

            }
        });

        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.cloud)
                .addProfiles(
                        new ProfileDrawerItem().withName("SansBar").withEmail("SansBar_2013-2017@gmail.com").withIcon(getResources().getDrawable(R.drawable.thor))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(getResources().getDrawable(R.drawable.home));
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Settings").withIcon(getResources().getDrawable(R.drawable.setting));
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Apps & games").withIcon(getResources().getDrawable(R.drawable.apps));
        PrimaryDrawerItem item8 = new PrimaryDrawerItem().withIdentifier(8).withName("Langur Burja").withIcon(getResources().getDrawable(R.drawable.jhandi));
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("Movies").withIcon(getResources().getDrawable(R.drawable.images));
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName("Maps").withIcon(getResources().getDrawable(R.drawable.map));
        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(6).withName("Add account").withIcon(getResources().getDrawable(R.drawable.account));
        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(7).withName("Log Out").withIcon(getResources().getDrawable(R.drawable.logout));
//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(

                        item1,

                        item2,
                        item3,

                        item8,

                        item4,
                        item5,
                        item6,
                        item7



                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        switch(position) {

                            case 4: Intent play = new Intent(MainActivity.this,jhandiActivity.class);
                                startActivity(play);
                                break;

                        }
                        return true;
                    }
                })
                .build();
    }
}
