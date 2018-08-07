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
import android.widget.TextView;
import android.widget.Toast;

import com.kodamalabs.festivalinverno.R;
import com.kodamalabs.festivalinverno.adapters.FoodTruckAdapter;
import com.kodamalabs.festivalinverno.mappers.FoodTruckMapper;
import com.kodamalabs.festivalinverno.models.FoodTruck;

import java.util.ArrayList;
import java.util.List;

public class FoodTruckFragment extends Fragment {

    private List<FoodTruck> foodTruckList;
    public static FoodTruckFragment newInstance(){
        return  new FoodTruckFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_foodtruck, container, false);

        RecyclerView lista = (RecyclerView) rootView.findViewById(R.id.list_foodtruck);
        try{
            foodTruckList = FoodTruckMapper.getFoodTruckList(getActivity());
        }catch (Exception ex){
            Log.e("FOODTRUCK",ex.getMessage());
            foodTruckList = new ArrayList<>();
        }
        FoodTruckAdapter adapter = new FoodTruckAdapter(foodTruckList);

        lista.setAdapter(adapter);
        lista.setLayoutManager(new LinearLayoutManager(getActivity()));
        lista.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        lista.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickListener(new FoodTruckAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                FoodTruck foodTruck = foodTruckList.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("name", foodTruck.getName());
                bundle.putString("description", foodTruck.getDescription());
                bundle.putString("imageUrl", foodTruck.getImageUrl());

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
}
