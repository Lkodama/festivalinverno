package com.kodamalabs.festivalinverno.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.kodamalabs.festivalinverno.R;
import com.kodamalabs.festivalinverno.adapters.LineupAdapter;
import com.kodamalabs.festivalinverno.mappers.LineupMapper;
import com.kodamalabs.festivalinverno.models.LineUp;

import java.util.ArrayList;
import java.util.List;

public class DayThreeFragment extends Fragment {

    private List<LineUp> listLineUpList;

    public static DayThreeFragment newInstance(){
        return new DayThreeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_day_03, container, false);
        TextView txtDate = (TextView) rootView.findViewById(R.id.txtDate03);
        ImageButton btnArrow = (ImageButton) rootView.findViewById(R.id.arrow04);
        RecyclerView lista = (RecyclerView) rootView.findViewById(R.id.list_band_03);

        txtDate.setText("26/08");
        btnArrow.setOnClickListener(onClickListener());

        try{
            listLineUpList = LineupMapper.getLineUpList(getActivity(),"lineup3.json");
        }catch (Exception ex){
            Log.e("Lineup",ex.getMessage());
            listLineUpList = new ArrayList<>();
        }

        LineupAdapter adapter = new LineupAdapter(listLineUpList);

        lista.setAdapter(adapter);
        lista.setLayoutManager(new LinearLayoutManager(getActivity()));
        lista.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        lista.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickListener(new LineupAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LineUp lineUp = listLineUpList.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("name", lineUp.getBand());
                bundle.putString("description", lineUp.getDescription());
                bundle.putString("imageUrl", lineUp.getImgUrl());

                Fragment basicDetailFragment = BasicDetailFragment.newInstance();
                basicDetailFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, basicDetailFragment,"basicDetailFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }

    private View.OnClickListener onClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = DayTwoFragment.newInstance();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, fragment,"DayTwoFragment")
                        .addToBackStack(null)
                        .commit();
            }
        };
    }
}
