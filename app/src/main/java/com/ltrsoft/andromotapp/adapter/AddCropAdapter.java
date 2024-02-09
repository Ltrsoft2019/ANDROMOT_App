package com.ltrsoft.andromotapp.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.andromotapp.R;
import com.ltrsoft.andromotapp.fragment.CropDetail;
import com.ltrsoft.andromotapp.javaclasses.User_crop_sensor;

import java.util.ArrayList;

public class AddCropAdapter extends RecyclerView.Adapter<AddCropAdapter.ViewHolder> {
    private ArrayList<User_crop_sensor> list;
    private AdapterView.OnItemClickListener mListener;

    public AddCropAdapter(ArrayList<User_crop_sensor> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.status_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User_crop_sensor userCropSensor = list.get(position);
        holder.name.setText(userCropSensor.getId());
        holder.description.setText(userCropSensor.getName());

        holder.userCropCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                CropDetail cropDetailFragment = new CropDetail();

                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containermain, cropDetailFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description;
        private CardView userCropCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);  // Replace with the actual TextView ID
            description = itemView.findViewById(R.id.description);  // Replace with the actual TextView ID
            userCropCard = itemView.findViewById(R.id.cardview);  // Replace with the actual CardView ID
        }
    }
}
