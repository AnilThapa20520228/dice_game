package com.example.nasa.naavigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
private EditText user,pass;
private Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user=(EditText) findViewById(R.id.usertxt);
        pass=(EditText) findViewById(R.id.passtxt);
        login=(Button) findViewById(R.id.loginbtn);
        signup=(Button) findViewById(R.id.signupbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=user.getText().toString();
                String password=pass.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String userDetails = sharedPreferences.getString(username + password +"data","incorrect");
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("display",userDetails);
                edit.commit();
                if (userDetails == "incorrect"){
                    Toast.makeText(login.this,"Username and Password is incorrect",Toast.LENGTH_LONG).show();

                }else{
                    if(TextUtils.isEmpty(username)|| TextUtils.isEmpty(password)){
                        Toast.makeText(login.this,"Username and Password is incorrect",Toast.LENGTH_LONG).show();

                    }else{
                        Intent mainscreen = new Intent(login.this, MainActivity.class);
                        startActivity(mainscreen);
                    }

                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent signupscreen = new Intent(login.this,Register.class);
                startActivity(signupscreen);

            }
        });



    }
}
