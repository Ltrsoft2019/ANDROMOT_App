package com.ltrsoft.andromotapp.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.andromotapp.R;
import com.ltrsoft.andromotapp.fragment.StatusDetail;  // Assuming you have a StatusDetail fragment

import java.util.ArrayList;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {
    public ArrayList<StatusAdapter> list;

    private AdapterView.OnItemClickListener mListener;

    public StatusAdapter(ArrayList<StatusAdapter> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StatusAdapter userStatus = list.get(position);
        holder.name.setText(userStatus.getId());
        holder.description.setText(userStatus.getName());

        holder.statusCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                StatusDetail statusDetailFragment = new StatusDetail();

                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containermain, statusDetailFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private int getName() {
        return list.size();
    }

    private int getId() {
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description;
        private CardView statusCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id. description);
            statusCard = itemView.findViewById(R.id.cardview);
        }
    }
}
