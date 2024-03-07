package com.ltrsoft.andromotapp.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.andromotapp.R;

public class Dashboard extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Create the parent layout (RelativeLayout)
        RelativeLayout parentLayout = new RelativeLayout(getActivity());
        parentLayout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        parentLayout.setBackgroundColor(Color.parseColor("#FAFBFB"));

        // Create TextView for "Search Products"
        TextView searchProductsTextView = new TextView(getActivity());
        RelativeLayout.LayoutParams searchParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        searchProductsTextView.setId(View.generateViewId());
        searchProductsTextView.setLayoutParams(searchParams);
        searchProductsTextView.setText("Search Products");
        searchProductsTextView.setTextSize(20);
        searchProductsTextView.setTextColor(Color.BLACK);
        searchProductsTextView.setGravity(Gravity.CENTER);
        parentLayout.addView(searchProductsTextView);

        TextView searchBorderTextView = new TextView(getActivity());
        RelativeLayout.LayoutParams searchBorderPerams = new RelativeLayout.LayoutParams(
                600,
                70);
        searchBorderPerams.addRule(RelativeLayout.BELOW, searchProductsTextView.getId());
        searchBorderPerams.topMargin=20;
        searchBorderPerams.leftMargin=100;
        searchBorderTextView.setLayoutParams(searchBorderPerams);
        searchBorderTextView.setId(View.generateViewId());
        searchBorderTextView.setBackgroundResource(R.drawable.edit);
        searchBorderTextView.setGravity(Gravity.CENTER);
        searchBorderTextView.setLayoutParams(searchBorderPerams);
        parentLayout.addView(searchBorderTextView);

        // Create SearchView
        SearchView searchView = new SearchView(getActivity());
        RelativeLayout.LayoutParams searchViewParams = new RelativeLayout.LayoutParams(300, 100);
        searchViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        searchViewParams.addRule(RelativeLayout.BELOW, searchProductsTextView.getId());
        searchView.setLayoutParams(searchViewParams);
        searchView.setId(View.generateViewId());
        parentLayout.addView(searchView);

        // Create TextView for "Search category"
        TextView searchCategoryTextView = new TextView(getActivity());
        RelativeLayout.LayoutParams searchCategoryParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        searchCategoryParams.addRule(RelativeLayout.BELOW, searchProductsTextView.getId());
        searchCategoryParams.topMargin=25;
        searchCategoryParams.leftMargin=70;
        searchCategoryTextView.setLayoutParams(searchCategoryParams);
        searchCategoryTextView.setId(View.generateViewId());
        searchCategoryTextView.setText("Search category");
        searchCategoryTextView.setTextSize(16);
        searchCategoryTextView.setTextColor(Color.parseColor("#2B620D"));
        searchCategoryTextView.setGravity(Gravity.CENTER);
        searchCategoryTextView.setLayoutParams(searchCategoryParams);
        parentLayout.addView(searchCategoryTextView);

//        // Create TextView for "Pump Status"
        TextView pumpStatusTextView = new TextView(getActivity());
        RelativeLayout.LayoutParams pumpStatusParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pumpStatusParams.addRule(RelativeLayout.BELOW, searchCategoryTextView.getId());
        pumpStatusParams.setMargins(50, 30, 0, 0);
        pumpStatusTextView.setLayoutParams(pumpStatusParams);
        pumpStatusTextView.setText("Pump Status");
        pumpStatusTextView.setTextSize(18);
        pumpStatusTextView.setId(View.generateViewId());
        pumpStatusTextView.setTextColor(Color.BLACK);
        parentLayout.addView(pumpStatusTextView);

        // Create CardView for pump status
        CardView pumpStatusCardView = new CardView(getActivity());
        RelativeLayout.LayoutParams pumpCardParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                150);
        pumpCardParams.addRule(RelativeLayout.BELOW, pumpStatusTextView.getId());
        pumpCardParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        pumpCardParams.setMargins(30, 20, 30, 0);
        pumpStatusCardView.setLayoutParams(pumpCardParams);
        pumpStatusCardView.setCardBackgroundColor(Color.parseColor("#83F1EBEB"));
        pumpStatusCardView.setRadius(20);
        pumpStatusCardView.setId(View.generateViewId());
        pumpStatusCardView.setId(View.generateViewId());
        parentLayout.addView(pumpStatusCardView);

        // Create ImageView for pump status
        ImageView pumpStatusImageView = new ImageView(getActivity());
        RelativeLayout.LayoutParams pumpImageParams = new RelativeLayout.LayoutParams(250, 150);
        pumpImageParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        pumpImageParams.addRule(RelativeLayout.CENTER_VERTICAL);
        pumpImageParams.setMargins(10, 10, 0, 0);
        pumpStatusImageView.setLayoutParams(pumpImageParams);
        pumpStatusImageView.setImageResource(R.drawable.motor);
        pumpStatusCardView.addView(pumpStatusImageView);
//
        // Create Switch for pump status
        Switch pumpStatusSwitch = new Switch(getActivity());
        RelativeLayout.LayoutParams switchParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        switchParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        switchParams.addRule(RelativeLayout.CENTER_VERTICAL);
        switchParams.setMargins(300, 30, 20, 0);
        pumpStatusSwitch.setLayoutParams(switchParams);
        pumpStatusSwitch.setId(View.generateViewId());
        pumpStatusCardView.addView(pumpStatusSwitch);
//
        // Create TextView for pump status text
        TextView pumpStatusText = new TextView(getActivity());
        RelativeLayout.LayoutParams pumpStatusTextParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pumpStatusTextParams.addRule(RelativeLayout.CENTER_VERTICAL);
        pumpStatusTextParams.addRule(RelativeLayout.RIGHT_OF, pumpStatusImageView.getId());
        pumpStatusTextParams.setMargins(250,80,0,0);
        pumpStatusText.setLayoutParams(pumpStatusTextParams);
        pumpStatusText.setText("Pump is Active");
        pumpStatusText.setTextSize(14);
        pumpStatusText.setTextColor(Color.parseColor("#2B620D"));
        pumpStatusCardView.addView(pumpStatusText);
//
        // Create TextView for "Current Crops"
        TextView currentCropsTextView = new TextView(getActivity());
        RelativeLayout.LayoutParams currentCropsParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        currentCropsParams.addRule(RelativeLayout.BELOW, pumpStatusCardView.getId());
        currentCropsParams.setMargins(50, 20, 0, 0);
        currentCropsTextView.setLayoutParams(currentCropsParams);
        currentCropsTextView.setText("Current Crops");
        currentCropsTextView.setTextSize(18);
        currentCropsTextView.setId(View.generateViewId());
        currentCropsTextView.setTextColor(Color.BLACK);
        parentLayout.addView(currentCropsTextView);

        // Create RecyclerView for current crops
        RecyclerView currentCropsRecyclerView = new RecyclerView(getActivity());
        RelativeLayout.LayoutParams cropsRecyclerParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        cropsRecyclerParams.addRule(RelativeLayout.BELOW, currentCropsTextView.getId());
        cropsRecyclerParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        currentCropsRecyclerView.setId(View.generateViewId());
        currentCropsRecyclerView.setLayoutParams(cropsRecyclerParams);
        parentLayout.addView(currentCropsRecyclerView);
//
        // Create TextView for "Recently Crops"
        TextView recentCropsTextView = new TextView(getActivity());
        RelativeLayout.LayoutParams recentCropsParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        recentCropsParams.addRule(RelativeLayout.BELOW, currentCropsRecyclerView.getId());
        recentCropsParams.setMargins(50, 20, 0, 0);
        recentCropsTextView.setLayoutParams(recentCropsParams);
        recentCropsTextView.setText("Recently Crops");
        recentCropsTextView.setTextSize(18);
        recentCropsTextView.setId(View.generateViewId());
        recentCropsTextView.setTextColor(Color.BLACK);
        parentLayout.addView(recentCropsTextView);

        // Create RecyclerView for recent crops
        RecyclerView recentCropsRecyclerView = new RecyclerView(getActivity());
        RelativeLayout.LayoutParams recentRecyclerParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 132);
        recentRecyclerParams.addRule(RelativeLayout.BELOW, recentCropsTextView.getId());
        recentRecyclerParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        recentCropsRecyclerView.setLayoutParams(recentRecyclerParams);
        parentLayout.addView(recentCropsRecyclerView);

        return parentLayout;
    }
}
