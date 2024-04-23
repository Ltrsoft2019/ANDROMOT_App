package com.ltrsoft.andromotapp.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.ltrsoft.andromotapp.R;

public class Splash_Screen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash__screen, container, false);

        // Find views
        LinearLayout mainLayout = view.findViewById(R.id.spashLayout);

        // Create and configure TextView for "Andromot"
        TextView textViewAndromot = new TextView(getContext());
        textViewAndromot.setText("Andromot");
        textViewAndromot.setTextColor(Color.parseColor("#18613E"));
        textViewAndromot.setTextSize(40);
        textViewAndromot.setGravity(android.view.Gravity.CENTER);
        LinearLayout.LayoutParams paramsAndromot = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        paramsAndromot.setMargins(0, 100, 0, 0);
        textViewAndromot.setLayoutParams(paramsAndromot);

        // Create and configure ImageView for sweetcorn
        ImageView imageViewSweetcorn = new ImageView(getContext());
        imageViewSweetcorn.setImageResource(R.drawable.sweetcorn);
        imageViewSweetcorn.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        imageViewSweetcorn.setPadding(100, 100, 0, 0);
        imageViewSweetcorn.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        // Create and configure TextView for "Per drop more crop"
        TextView textViewPerDrop = new TextView(getContext());
        textViewPerDrop.setText("Per drop more crop");
        textViewPerDrop.setTextColor(Color.parseColor("#18613E"));
        textViewPerDrop.setTextSize(30);
        textViewPerDrop.setGravity(android.view.Gravity.CENTER);
        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.caveat_brush);
        textViewPerDrop.setTypeface(typeface);
        LinearLayout.LayoutParams paramsPerDrop = new LinearLayout.LayoutParams(
                300,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        paramsPerDrop.gravity = android.view.Gravity.CENTER_HORIZONTAL;
        paramsPerDrop.setMargins(0, 10, 0, 0);
        textViewPerDrop.setLayoutParams(paramsPerDrop);

        // Create and configure LinearLayout for circles
        LinearLayout circleLayout = new LinearLayout(getContext());
        circleLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams paramsCircleLayout = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        paramsCircleLayout.gravity = android.view.Gravity.CENTER_HORIZONTAL;
        circleLayout.setLayoutParams(paramsCircleLayout);

        // Create and configure first circle ImageView
        ImageView imageViewCircle1 = new ImageView(getContext());
        imageViewCircle1.setImageResource(R.drawable.circle);
        LinearLayout.LayoutParams paramsCircle1 = new LinearLayout.LayoutParams(
                250,
                255
        );
        paramsCircle1.setMargins(0, 0, 0, 0);
        imageViewCircle1.setLayoutParams(paramsCircle1);

        // Create and configure second circle ImageView
        ImageView imageViewCircle2 = new ImageView(getContext());
        imageViewCircle2.setImageResource(R.drawable.circle);
        LinearLayout.LayoutParams paramsCircle2 = new LinearLayout.LayoutParams(
                250,
                255
        );
        paramsCircle2.setMargins(300, 0, 0, 300);
        imageViewCircle2.setLayoutParams(paramsCircle2);

        // Add views to the main layout
        mainLayout.addView(textViewAndromot);
        mainLayout.addView(imageViewSweetcorn);
        mainLayout.addView(textViewPerDrop);
        mainLayout.addView(circleLayout);
        circleLayout.addView(imageViewCircle1);
        circleLayout.addView(imageViewCircle2);

        return view;
    }
}
