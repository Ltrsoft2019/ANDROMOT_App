package com.ltrsoft.andromotapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.andromotapp.R;
import com.ltrsoft.andromotapp.interfaces.CallBack;
import com.ltrsoft.andromotapp.javaclasses.User_detail;
import com.ltrsoft.andromotapp.pojoclass.Userdao;

import java.util.ArrayList;


public class Profile extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Userdao userdao = new Userdao();
        userdao.getoneuserdetail(requireContext(), new CallBack() {
            @Override
            public void onSuccess(Object object) {
                ArrayList<User_detail> userList = (ArrayList<User_detail>) object;
                if (!userList.isEmpty()) {
                    User_detail firstUser = userList.get(0);
                    Toast.makeText(getContext(), "" + firstUser.toString(), Toast.LENGTH_SHORT).show();
                    // Set the user name or perform any other actions with the user details
                }
            }

            @Override
            public void onError(String error) {
                // Handle error if needed
            }
        });

        return view;
    }
}
