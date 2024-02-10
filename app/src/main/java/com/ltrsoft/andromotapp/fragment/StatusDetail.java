package com.ltrsoft.andromotapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.andromotapp.R;
import com.ltrsoft.andromotapp.adapter.UserCropAdapter;
import com.ltrsoft.andromotapp.adapter.UserPumpStatusAdapter;
import com.ltrsoft.andromotapp.interfaces.CallBack;
import com.ltrsoft.andromotapp.javaclasses.User_crop_sensor;
import com.ltrsoft.andromotapp.javaclasses.User_pump_status;
import com.ltrsoft.andromotapp.pojoclass.PumpStatus;
import com.ltrsoft.andromotapp.pojoclass.Usercrop;

import java.util.ArrayList;

public class StatusDetail extends Fragment {
private RecyclerView recyclerView;
    public StatusDetail() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_status_detail, container, false);
recyclerView=v.findViewById(R.id.status);





        PumpStatus pumpStatus=new PumpStatus();
        pumpStatus.getUserPumpStatus(requireContext(), recyclerView, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                ArrayList<User_pump_status> yourJobList1 = (ArrayList<User_pump_status>) object;
                UserPumpStatusAdapter adapter = new UserPumpStatusAdapter(yourJobList1);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(String error) {

            }
        });




        return v;
    }


}
