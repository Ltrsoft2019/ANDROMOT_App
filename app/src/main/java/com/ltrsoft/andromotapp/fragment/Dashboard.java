package com.ltrsoft.andromotapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.ltrsoft.andromotapp.R;
import com.ltrsoft.andromotapp.adapter.UserCropAdapter;

import com.ltrsoft.andromotapp.interfaces.CallBack;
import com.ltrsoft.andromotapp.javaclasses.User_crop_sensor;
import com.ltrsoft.andromotapp.pojoclass.Usercrop;

import java.util.ArrayList;

public class Dashboard extends Fragment {
    private RecyclerView recyclerView,recycleview1;
    private BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);


        recycleview1 =view.findViewById(R.id.recent);


        recyclerView = view.findViewById(R.id.dashboard);

        Usercrop jobDashboard = new Usercrop();

        jobDashboard.getall(requireContext(), new CallBack() {
            @Override
            public void onSuccess(Object object) {
                ArrayList<User_crop_sensor> yourJobList = (ArrayList<User_crop_sensor>) object;
                UserCropAdapter adapter = new UserCropAdapter(yourJobList);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recycleview1.setLayoutManager(layoutManager);
                recycleview1.setAdapter(adapter);
            }

            @Override
            public void onError(String error) {
            }
        });



        Usercrop usercrop=new Usercrop();
        usercrop.getuser(requireContext(), recyclerView, new CallBack() {
                    @Override
                    public void onSuccess(Object object) {
                        ArrayList<User_crop_sensor> yourJobList = (ArrayList<User_crop_sensor>) object;
                        UserCropAdapter adapter = new UserCropAdapter(yourJobList);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onError(String error) {

                    }
                });














        bottomNavigationView = view.findViewById(R.id.bottomNavigationView);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home) {

                }else if (id == R.id.Add) {
                    Toast.makeText(getContext(), "Add Croped", Toast.LENGTH_SHORT).show();
                    AddCropFragment addCropFragment = new AddCropFragment();
                    getFragmentManager().beginTransaction().replace(R.id.maincontainer, addCropFragment).addToBackStack(null).commit();
                }



                else if (id == R.id.battery) {
                    Toast.makeText(getContext(), "battery clicked", Toast.LENGTH_SHORT).show();
                    StatusDetail statusDetail = new StatusDetail();
                    getFragmentManager().beginTransaction().replace(R.id.maincontainer,   statusDetail).addToBackStack(null).commit();

                }

                else if (id == R.id.profile) {
                    Profile statusDetail = new Profile



                            ();
                    getFragmentManager().beginTransaction().replace(R.id.maincontainer,   statusDetail).addToBackStack(null).commit();

                    Toast.makeText(getContext(), "profile clicked", Toast.LENGTH_SHORT).show();
                    // Handle profile click
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
