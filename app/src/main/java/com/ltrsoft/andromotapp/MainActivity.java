package com.ltrsoft.andromotapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import com.ltrsoft.andromotapp.fragment.Splash_Screen;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Splash_Screen splashScreen=new Splash_Screen();
        getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer, splashScreen).commit();
    }
}