package com.ltrsoft.andromotapp.fragment;// Import necessary packages and classes
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ltrsoft.andromotapp.R;  // Adjust the package accordingly
import com.ltrsoft.andromotapp.interfaces.CallBack;
import com.ltrsoft.andromotapp.javaclasses.User_crop_sensor;
import com.ltrsoft.andromotapp.pojoclass.Usercrop;

public class CropDetail extends Fragment {

    private TextView name, des, thrishud, value;

    public CropDetail() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crop_detail, container, false);

        name = view.findViewById(R.id.t2);

        Usercrop jobDashboard = new Usercrop();

        jobDashboard.getall(requireContext(), new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object instanceof Usercrop) {
                    User_crop_sensor userCropData = (User_crop_sensor) object;


                    String cropDescription = userCropData.getDes();

                    Toast.makeText(getContext(), "Your crop description: " + cropDescription, Toast.LENGTH_SHORT).show();
                    // Set the description in the TextView
                    des.setText(cropDescription);

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
