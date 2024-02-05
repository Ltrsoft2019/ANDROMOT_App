package com.ltrsoft.andromotapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.ltrsoft.andromotapp.R;


public class Login extends Fragment {
    private Button next;
    private EditText phoneno;

    public Login() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.login, container, false);

        next=view.findViewById(R.id.next_btn);
        phoneno=view.findViewById(R.id.phoneno);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OTP otp=new OTP();
                getFragmentManager().beginTransaction().replace(R.id.maincontainer,otp).commit();
            }
        });


        return view;
    }
}