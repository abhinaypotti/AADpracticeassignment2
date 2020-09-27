package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Communicator {


    TextView tv;
    FrameLayout fl;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle b = getIntent().getExtras();
        tv = findViewById(R.id.details);
        String name = b.getString("name");
        phone = b.getString("mobile");
        tv.setText(name + " " + phone);
        fl = findViewById(R.id.frame);
        FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, new FirstFragment());
        ft.commit();

    }


    @Override
    public void respond(HashMap<Integer, Integer> hm) {
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("map",hm);
        i.putExtra("phonenumber",phone);
        startActivity(i);
    }
}