package com.kodamalabs.festivalinverno.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kodamalabs.festivalinverno.R;
import com.kodamalabs.festivalinverno.models.FoodTruck;
import com.squareup.picasso.Picasso;

public class BasicDetailFragment extends Fragment {

    private ProgressBar progressBar;

    public static BasicDetailFragment newInstance(){
        return new BasicDetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_basic_detail, container, false);

        String name = getArguments().getString("name");
        String description = getArguments().getString("description");
        String imageUrl = getArguments().getString("imageUrl");

        TextView txtName = (TextView) rootView.findViewById(R.id.txtName);
        TextView txtDescription = (TextView) rootView.findViewById(R.id.txtDescription);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageUrl);
        progressBar = new ProgressBar(getContext());
        progressBar.setVisibility(View.VISIBLE);
        Picasso.with(getContext()).load(imageUrl).into(imageView, new com.squareup.picasso.Callback(){
            @Override
            public void onSuccess() {
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onError() {

            }
        });

        txtName.setText(name);
        txtDescription.setText(description);

        return rootView;
    }
}
