package com.ltrsoft.andromotapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.ltrsoft.andromotapp.R;

public class Dashboard extends Fragment {

    private BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        bottomNavigationView = view.findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home) {
//                    DashboardFragment main = new DashboardFragment();
//                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer, main).commit();
                } else if (id == R.id.Add) {
                    Toast.makeText(getContext(), "Add Croped", Toast.LENGTH_SHORT).show();

//                    AddCropRecyclview addCropRecyclview=new AddCropRecyclview();
//                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer,addCropRecyclview).addToBackStack(null).commit();

                } else if (id == R.id.battery) {
                    Toast.makeText(getContext(), "battery clicked", Toast.LENGTH_SHORT).show();
                } else if (id==R.id.profile) {
                    Toast.makeText(getContext(), "profile clicked", Toast.LENGTH_SHORT).show();

                }
                return false;
            }
        });

        return view;
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
