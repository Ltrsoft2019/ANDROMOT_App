package com.ltrsoft.andromotapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.andromotapp.R;
import com.ltrsoft.andromotapp.adapter.UserCropAdapter;
import com.ltrsoft.andromotapp.interfaces.CallBack;
import com.ltrsoft.andromotapp.javaclasses.User_crop_sensor;
import com.ltrsoft.andromotapp.pojoclass.Usercrop;

import java.util.ArrayList;


public class AddCropFragment extends Fragment {
private RecyclerView recyclerView;
    public AddCropFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_crop, container, false);
recyclerView=view.findViewById(R.id.addcrop);


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



        return view;
    }
}