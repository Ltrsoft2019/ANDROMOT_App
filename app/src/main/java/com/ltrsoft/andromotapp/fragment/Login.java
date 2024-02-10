package com.ltrsoft.andromotapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.ltrsoft.andromotapp.R;


public class Login extends Fragment {
    private Button signup;
    private TextView t1,t2,t3;
    private EditText edit1,edit2;

    public Login() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.login, container, false);

        t1=view.findViewById(R.id.t1);
        t2=view.findViewById(R.id.t2);
        t3=view.findViewById(R.id.t3);
        edit1=view.findViewById(R.id.edit1);
        edit2=view.findViewById(R.id.edit2);
        signup=view.findViewById(R.id.btn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.maincontainer,new NavigationDrawerfragment()).commit();

            }
        });
        return view;
                }
}
