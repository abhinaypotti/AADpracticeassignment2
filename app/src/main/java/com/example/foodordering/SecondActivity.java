package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import java.util.HashMap;

public class SecondActivity extends AppCompatActivity implements Communicator2{
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle b = getIntent().getExtras();
        phone = b.getString("phonenumber");
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm = (HashMap<Integer, Integer>) b.getSerializable("map");
        FragmentManager fm = getSupportFragmentManager();
        CountFragment f2 = (CountFragment) fm.findFragmentById(R.id.cf);
        f2.changeData(hm);
    }

    @Override
    public void respond(double amount) {
        FragmentManager fm2 = getSupportFragmentManager();
        ThirdFragment t = (ThirdFragment) fm2.findFragmentById(R.id.tf);
        t.changeData(amount);
        t.mobile(phone);
    }
}