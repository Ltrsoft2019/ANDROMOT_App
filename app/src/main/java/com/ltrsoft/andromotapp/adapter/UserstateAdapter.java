//package com.ltrsoft.andromotapp.adapter;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.ltrsoft.andromotapp.R;
//import com.ltrsoft.andromotapp.javaclasses.State;
//import com.ltrsoft.andromotapp.javaclasses.User_crop_sensor;
//import com.ltrsoft.andromotapp.javaclasses.User_pump_status;
//
//import java.util.ArrayList;
//
//public class UserstateAdapter extends RecyclerView.Adapter<UserstateAdapter.ViewHolder> {
//
//    public ArrayList<UserstateAdapter>list;
//
//    public UserstateAdapter(ArrayList<UserstateAdapter> list) {
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//
//
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//        State state=new State();
//        holder.t1.setText(state.getState_id());
//        holder.t2.setText(state.getState_name());
//        holder.t3.setText(state.getCountry_id());
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        TextView t1,t2,t3;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//
//
//
//
//            t1= itemView.findViewById(R.id.idd);
//            t2= itemView.findViewById(R.id.dob);
//            t3= itemView.findViewById(R.id.name);
//
//
//        }
//    }
//}
//
