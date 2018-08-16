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
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.Arrays;
import java.util.List;

public class TurismFragment extends Fragment {

    private ProgressBar progressBar;
    private List<String> listImagesUrl = Arrays.asList("https://i.imgur.com/lXm2Bui.jpg","https://i.imgur.com/xMkRuHp.jpg");

    public static TurismFragment newInstance(){
        return new TurismFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_turism, container, false);

        CarouselView carouselView;
        Button btnDetail = (Button)rootView.findViewById(R.id.btn_call);
        carouselView = (CarouselView) rootView.findViewById(R.id.carousel);
        carouselView.setPageCount(listImagesUrl.size());
        carouselView.setImageListener(getImageListener());

        btnDetail.setOnClickListener(onGoClickListener());
        return rootView;
    }

    private View.OnClickListener onGoClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+553597684030"));
                startActivity(intent);
            }
        };
    }


    private ImageListener getImageListener(){
        return new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                progressBar = new ProgressBar(getContext());
                progressBar.setVisibility(View.VISIBLE);
                Picasso.with(getContext()).load(listImagesUrl.get(position)).placeholder(R.mipmap.ic_launcher).centerCrop().resize(800,900).into(imageView, new com.squareup.picasso.Callback(){
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
            }
        };
    }
}
