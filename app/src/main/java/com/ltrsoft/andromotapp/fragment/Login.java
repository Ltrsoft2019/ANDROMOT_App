package com.ltrsoft.andromotapp.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ltrsoft.andromotapp.R;

public class Login extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Create the main RelativeLayout
        RelativeLayout mainLayout = new RelativeLayout(requireContext());
        mainLayout.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        ));
        mainLayout.setBackgroundColor(Color.WHITE); // Set background color

        // Create the ImageView
        ImageView imageView = new ImageView(getContext());
        imageView.setId(View.generateViewId()); // Set unique ID for this view
        imageView.setImageResource(R.drawable.andlogo);
        RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(
                800,
                500
        );
        imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL); // Center horizontally
        imageParams.addRule(RelativeLayout.ALIGN_PARENT_TOP); // Align to the top
        imageParams.topMargin = dpToPx(20); // Set top margin
        imageView.setLayoutParams(imageParams);
        mainLayout.addView(imageView);

        // Create the TextView for "Login"
        TextView loginTextView = new TextView(requireContext());
        loginTextView.setId(View.generateViewId()); // Set unique ID for this view
        loginTextView.setText("Login");
        loginTextView.setTextSize(40);
        loginTextView.setTextColor(Color.BLACK);
        RelativeLayout.LayoutParams loginParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        loginParams.addRule(RelativeLayout.CENTER_HORIZONTAL); // Center horizontally
        loginParams.addRule(RelativeLayout.BELOW, imageView.getId()); // Position below the ImageView
        loginParams.topMargin = dpToPx(10); // Set top margin
        loginTextView.setLayoutParams(loginParams);
        mainLayout.addView(loginTextView);

        // Create the EditText for number input
        EditText numberEditText = new EditText(requireContext());
        numberEditText.setHint("Enter your number");
        numberEditText.setTextSize(16);
        numberEditText.setId(View.generateViewId()); // Set unique ID for this view
        numberEditText.setBackgroundResource(R.drawable.edit);
        numberEditText.setPadding(30,8,1,1);
        RelativeLayout.LayoutParams numberParams = new RelativeLayout.LayoutParams(
                dpToPx(300), // width
                dpToPx(60) // height
        );
        numberParams.addRule(RelativeLayout.CENTER_HORIZONTAL); // Center horizontally
        numberParams.addRule(RelativeLayout.BELOW, loginTextView.getId()); // Position below the TextView for "Login"
        numberParams.topMargin = dpToPx(30); // Set top margin
        numberEditText.setLayoutParams(numberParams);
        mainLayout.addView(numberEditText);
//
//        // Create the EditText for OTP input
        EditText otpEditText = new EditText(requireContext());
        otpEditText.setHint("Enter OTP");
        otpEditText.setTextSize(16);
        otpEditText.setId(View.generateViewId()); // Set unique ID for this view
        otpEditText.setPadding(30,8,1,1);
        otpEditText.setBackgroundResource(R.drawable.edit);
        RelativeLayout.LayoutParams otpParams = new RelativeLayout.LayoutParams(
                dpToPx(300), // width
                dpToPx(60) // height
        );
        otpParams.addRule(RelativeLayout.CENTER_HORIZONTAL); // Center horizontally
        otpParams.addRule(RelativeLayout.BELOW, numberEditText.getId()); // Position below the EditText for number input
        otpParams.topMargin = dpToPx(20); // Set top margin
        otpEditText.setLayoutParams(otpParams);
        mainLayout.addView(otpEditText);

//        // Create the TextView for "Resend OTP"
        TextView resendTextView = new TextView(requireContext());
        resendTextView.setText("Resend OTP");
        resendTextView.setTextColor(Color.parseColor("#FF5722"));
        resendTextView.setTextSize(15);
        resendTextView.setId(View.generateViewId());
        resendTextView.setId(View.generateViewId());
        RelativeLayout.LayoutParams resendParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        resendParams.addRule(RelativeLayout.ALIGN_START, otpEditText.getId()); // Align with the start of the EditText for OTP input
        resendParams.addRule(RelativeLayout.BELOW, otpEditText.getId()); // Position below the EditText for OTP input
        resendParams.topMargin = dpToPx(10); // Set top margin
        resendTextView.setLayoutParams(resendParams);
        mainLayout.addView(resendTextView);

//        // Create the TextView for timestamp
        TextView timestampTextView = new TextView(requireContext());
        timestampTextView.setText("12.01");
        timestampTextView.setTextSize(15);
        RelativeLayout.LayoutParams timestampParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        timestampParams.addRule(RelativeLayout.ALIGN_END, otpEditText.getId()); // Align with the end of the EditText for OTP input
        timestampParams.addRule(RelativeLayout.BELOW, otpEditText.getId()); // Position below the EditText for OTP input
        timestampParams.topMargin = dpToPx(10); // Set top margin
        timestampParams.rightMargin = dpToPx(10);
        timestampTextView.setLayoutParams(timestampParams);
        mainLayout.addView(timestampTextView);

//        // Create the Button for sign up
        Button signUpButton = new Button(requireContext());
        signUpButton.setText("Sign Up");
        signUpButton.setTextSize(20);
        signUpButton.setTextColor(Color.WHITE);
        signUpButton.setBackgroundResource(R.color.button);
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                dpToPx(200), // width
                dpToPx(50) // height
        );
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL); // Center horizontally
        buttonParams.addRule(RelativeLayout.BELOW, resendTextView.getId()); // Position below the TextView for "Resend OTP"
        buttonParams.topMargin = dpToPx(50); // Set top margin
        signUpButton.setLayoutParams(buttonParams);
        mainLayout.addView(signUpButton);


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dashboard dashboard = new Dashboard();
                getFragmentManager().beginTransaction().replace(R.id.maincontainer,dashboard).commit();
            }
        });

        return mainLayout;
    }

    // Method to convert dp to pixels
    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
}
