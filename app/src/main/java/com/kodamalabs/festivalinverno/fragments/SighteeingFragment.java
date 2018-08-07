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
import com.kodamalabs.festivalinverno.adapters.SightseeingAdapter;
import com.kodamalabs.festivalinverno.mappers.SightseeingMapper;
import com.kodamalabs.festivalinverno.models.Sightseeing;

import java.util.ArrayList;
import java.util.List;

public class SighteeingFragment extends Fragment {

    private List<Sightseeing> sightseeingList;

    public static SighteeingFragment newInstance(){
        return new SighteeingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_foodtruck, container, false);

        RecyclerView lista = (RecyclerView) rootView.findViewById(R.id.list_foodtruck);
        try{
            sightseeingList = SightseeingMapper.getSightseeingList(getActivity());
        }catch (Exception ex){
            Log.e("TURISMO",ex.getMessage());
            sightseeingList = new ArrayList<>();
        }
        SightseeingAdapter adapter = new SightseeingAdapter(sightseeingList);

        lista.setAdapter(adapter);
        lista.setLayoutManager(new LinearLayoutManager(getActivity()));
        lista.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        lista.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickListener(new SightseeingAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Sightseeing sightseeing = sightseeingList.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("name", sightseeing.getName());
                bundle.putString("description", sightseeing.getDescription());
                bundle.putStringArrayList("listImagesUrl", new ArrayList<String>(sightseeing.getListImagesUrl()));
                bundle.putString("latitude", sightseeing.getLatitude());
                bundle.putString("longitude", sightseeing.getLongitude());


                Fragment basicDetailFragment = DetailPagerFragment.newInstance();
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
