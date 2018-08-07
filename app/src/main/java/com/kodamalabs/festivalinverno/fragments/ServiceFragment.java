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

import com.kodamalabs.festivalinverno.R;
import com.kodamalabs.festivalinverno.adapters.FoodTruckAdapter;
import com.kodamalabs.festivalinverno.adapters.ServiceAdapter;
import com.kodamalabs.festivalinverno.mappers.ServiceMapper;
import com.kodamalabs.festivalinverno.models.FoodTruck;
import com.kodamalabs.festivalinverno.models.Services;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ServiceFragment extends Fragment {

    private List<Services> servicesList;

    public static ServiceFragment newInstance(){
        return new ServiceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_services, container, false);
        RecyclerView lista = (RecyclerView) rootView.findViewById(R.id.list_services);
        try {
            servicesList = loadServiceList(getArguments().getString("category"));
        } catch (JSONException e) {
            Log.e("SERVICES", e.getMessage());
            servicesList = new ArrayList<>();
        }

        ServiceAdapter adapter = new ServiceAdapter(servicesList);
        lista.setAdapter(adapter);
        lista.setLayoutManager(new LinearLayoutManager(getActivity()));
        lista.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        lista.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickListener(new ServiceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Services services = servicesList.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("name", services.getName());
                bundle.putString("description", services.getDescription());
                bundle.putString("imageUrl", services.getImageUrl());
                bundle.putString("address", services.getAddress());
                bundle.putString("latitude", services.getLatitude());
                bundle.putString("longitude", services.getLongitude());

                Fragment detailsFragment = DetailsFragment.newInstance();
                detailsFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, detailsFragment,"Detail Fragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }

    private List<Services> loadServiceList(String category) throws JSONException {
        return ServiceMapper.getServicesList(getActivity(),category);
    }


}
