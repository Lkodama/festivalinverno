package com.kodamalabs.festivalinverno.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.kodamalabs.festivalinverno.R;
import com.squareup.picasso.Picasso;

public class TownFragment extends Fragment {

    private ProgressBar progressBar;

    public static TownFragment newInstance() {
        return new TownFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_prefeitura, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imgPrefeitura);
        Button button = (Button) rootView.findViewById(R.id.btnface);
        button.setOnClickListener(onGoClickListener());
        progressBar = new ProgressBar(getContext());
        progressBar.setVisibility(View.VISIBLE);
        Picasso.with(getContext()).load("https://i.imgur.com/ke4dvrX.jpg").centerCrop().resize(500,500).placeholder(R.mipmap.ic_launcher).into(imageView, new com.squareup.picasso.Callback(){
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
        return rootView;
    }

    private View.OnClickListener onGoClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/prefeitura.toledo/"));
                startActivity(intent);
            }
        };
    }

}