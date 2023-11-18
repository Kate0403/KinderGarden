package com.example.secproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.secproject.ui.OneFragment;
import com.example.secproject.ui.TwoFragment;

public class MainActiv
        ity extends AppCompatActivity {
    private OneFragment oneFragment;
    private TwoFragment twoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
       // startFragmentOne();

        startFragmentTwo();
    }

    private void startFragmentOne(){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, oneFragment).commit();
    }

    private void startFragmentTwo(){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, twoFragment).commit();
    }


}