package com.kodamalabs.festivalinverno.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kodamalabs.festivalinverno.R;
import com.kodamalabs.festivalinverno.models.Sightseeing;

import org.w3c.dom.Text;

import java.util.List;

public class SightseeingAdapter extends RecyclerView.Adapter<SightseeingAdapter.ViewHolder>{

    private List<Sightseeing> sightseeingList;

    public SightseeingAdapter(List<Sightseeing> sightseeingList){
        this.sightseeingList = sightseeingList;
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
        Sightseeing sightseeing = sightseeingList.get(position);
        holder.txtFoodTruckName.setText(sightseeing.getName());
        holder.txtDesc.setText(sightseeing.getDescription());
    }

    @Override
    public int getItemCount() {
        return sightseeingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtFoodTruckName;
        private TextView txtDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            txtFoodTruckName = (TextView) itemView.findViewById(R.id.text_foodtruck);
            txtDesc = (TextView) itemView.findViewById(R.id.text_foodtruck_desc);


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
