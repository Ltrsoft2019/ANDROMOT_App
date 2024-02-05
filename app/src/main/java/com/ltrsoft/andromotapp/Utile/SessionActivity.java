package com.ltrsoft.andromotapp.Utile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ltrsoft.andromotapp.MainActivity;
import com.ltrsoft.andromotapp.R;
import com.ltrsoft.andromotapp.fragment.Login;

public class SessionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session2);

        SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if (pref.getBoolean("flag",false)){
            Intent main_activity_intent = new Intent(SessionActivity.this, MainActivity.class);
            startActivity(main_activity_intent);

        }
        else {
            Login login=new Login();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.maincontainer, login)
                    .commit();
        }

    }
}