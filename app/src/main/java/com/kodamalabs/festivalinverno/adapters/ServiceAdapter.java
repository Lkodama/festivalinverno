package com.kodamalabs.festivalinverno.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kodamalabs.festivalinverno.R;
import com.kodamalabs.festivalinverno.models.Services;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder>{

    private List<Services> servicesList;

    public ServiceAdapter(List<Services> servicesList){
        this.servicesList = servicesList;
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
        View view = inflater.inflate(R.layout.item_service, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Services service = servicesList.get(position);
        holder.txtService.setText(service.getName());
    }

    @Override
    public int getItemCount() {
        return servicesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtService;

        public ViewHolder(View itemView) {
            super(itemView);
            txtService = (TextView) itemView.findViewById(R.id.text_service);


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
