package com.ltrsoft.andromotapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ltrsoft.andromotapp.adapter.UserCropSensorAdapter;
import com.ltrsoft.andromotapp.fragment.LoginPage;
import com.ltrsoft.andromotapp.javaclasses.User_crop_sensor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.main_container,new LoginPage()).commit();
        RecyclerView recyclerView = findViewById(R.id.recycle);
        ArrayList<User_crop_sensor>list = new ArrayList<>();
        list.add(new User_crop_sensor("okok","okok","okok"));
        list.add(new User_crop_sensor("okok","okok","okok"));
        list.add(new User_crop_sensor("okok","okok","okok"));
        list.add(new User_crop_sensor("okok","okok","okok"));
        list.add(new User_crop_sensor("okok","okok","okok"));
        list.add(new User_crop_sensor("okok","okok","okok"));
        UserCropSensorAdapter adapter = new UserCropSensorAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}