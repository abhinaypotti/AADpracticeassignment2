package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText ed1,ed2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed1 = findViewById(R.id.username);
        ed2 = findViewById(R.id.mobilenumber);
        b = findViewById(R.id.button);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String user = ed1.getText().toString();
        String mobile = ed2.getText().toString();
        if(user.isEmpty() || mobile.isEmpty()){
            Toast.makeText(this,"Please enter valid credentials",Toast.LENGTH_SHORT).show();
        }
        else{
            if(user.matches("admin") && mobile.matches("12345")){
                Intent i = new Intent(this,MainActivity.class);
                i.putExtra("name",user);
                i.putExtra("mobile",mobile);
                startActivity(i);
            }
        }
    }
}