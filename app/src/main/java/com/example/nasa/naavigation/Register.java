package com.example.nasa.naavigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
private EditText u,p,e;
private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        u=(EditText) findViewById(R.id.txtuser);
        p=(EditText) findViewById(R.id.txtpass);
        e=(EditText) findViewById(R.id.txtemail);
        btn=(Button) findViewById(R.id.btnsave);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String use=u.getText().toString();
                String pas=p.getText().toString();
                String email=e.getText().toString();
                SharedPreferences.Editor edit=sharedPreferences.edit();
                edit.putString(use + pas +"data",use);
                edit.commit();
                Intent screen = new Intent(Register.this,login.class);
                startActivity(screen);
            }
        });
    }
}
