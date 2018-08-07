package com.kodamalabs.festivalinverno.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kodamalabs.festivalinverno.R;
import com.kodamalabs.festivalinverno.models.LineUp;

import java.util.List;

public class LineupAdapter extends RecyclerView.Adapter<LineupAdapter.ViewHolder> {

    private List<LineUp> lineUpList;

    private ServiceAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(ServiceAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    public LineupAdapter(List<LineUp> lineUpList) {
        this.lineUpList = lineUpList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater= LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_lineup, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LineUp lineUp = lineUpList.get(position);
        holder.txtHour.setText(lineUp.getTime());
        holder.txtBand.setText(lineUp.getBand());
    }

    @Override
    public int getItemCount() {
        return lineUpList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtBand;
        private TextView txtHour;

        public ViewHolder(View itemView) {
            super(itemView);
            txtBand = (TextView) itemView.findViewById(R.id.txt_band);
            txtHour = (TextView) itemView.findViewById(R.id.txt_hour);


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
