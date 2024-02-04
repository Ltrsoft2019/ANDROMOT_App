package com.ltrsoft.andromotapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.andromotapp.R;
import com.ltrsoft.andromotapp.javaclasses.User_crop_sensor;

import java.util.ArrayList;

public class UserCropSensorAdapter extends RecyclerView.Adapter<UserCropSensorAdapter.ViewHolder> {

    public ArrayList<User_crop_sensor>list;

    public UserCropSensorAdapter(ArrayList<User_crop_sensor> list) {
        this.list = list;
    }

    @NonNull
    @Override


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User_crop_sensor sensor = list.get(position);
        holder.t1.setText(sensor.getSensor_id());
        holder.t2.setText(sensor.getUser_crop_sensor_id());
        holder.t3.setText(sensor.getCrop_id());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView t1,t2,t3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);





            t1= itemView.findViewById(R.id.idd);
            t2= itemView.findViewById(R.id.dob);
            t3= itemView.findViewById(R.id.name);


        }
    }
}

