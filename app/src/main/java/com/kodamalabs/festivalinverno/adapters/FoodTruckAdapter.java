package com.kodamalabs.festivalinverno.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kodamalabs.festivalinverno.R;
import com.kodamalabs.festivalinverno.models.FoodTruck;

import java.util.List;

public class FoodTruckAdapter extends RecyclerView.Adapter<FoodTruckAdapter.ViewHolder>{

    private List<FoodTruck> foodTruckList;

    public FoodTruckAdapter(List<FoodTruck> foodTrucksList){
        this.foodTruckList = foodTrucksList;
        notifyDataSetChanged();
    }

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_foodtruck, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodTruck foodTruck = foodTruckList.get(position);
        holder.txtFoodTruckName.setText(foodTruck.getName());
    }

    @Override
    public int getItemCount() {
        return foodTruckList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtFoodTruckName;

        public ViewHolder(View itemView) {
            super(itemView);
            txtFoodTruckName = (TextView) itemView.findViewById(R.id.text_foodtruck);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onItemClick(v,getLayoutPosition());
                    }
                }
            });
        }


    }
}
