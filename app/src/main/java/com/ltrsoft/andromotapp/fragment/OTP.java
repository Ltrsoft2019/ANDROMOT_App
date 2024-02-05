package com.ltrsoft.andromotapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.ltrsoft.andromotapp.R;

public class OTP extends Fragment {
    private Button login;
    private EditText otp;
    public OTP() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.otp, container, false);

        login=view.findViewById(R.id.login);
        otp=view.findViewById(R.id.otp);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationDrawerfragment navigationDrawerfragment = new NavigationDrawerfragment();
                getFragmentManager().beginTransaction().replace(R.id.maincontainer, navigationDrawerfragment).commit();

            }
        });


        return view;
    }
}