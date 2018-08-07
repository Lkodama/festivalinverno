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
import android.widget.TextView;

import com.kodamalabs.festivalinverno.R;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

public class DetailPagerFragment extends Fragment {

    private ProgressBar progressBar;
    private String latitude;
    private String longitude;
    private List<String> listImagesUrl;
    private String placeLabel;

    public static DetailPagerFragment newInstance(){
        return new DetailPagerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail_pager, container, false);

        latitude = getArguments().getString("latitude");
        longitude = getArguments().getString("longitude");

        CarouselView carouselView;

        TextView txtName = (TextView)rootView.findViewById(R.id.txt_pager_name);
        TextView txtDescription = (TextView)rootView.findViewById(R.id.txt_page_description);
        Button btnDetail = (Button)rootView.findViewById(R.id.btn_pager);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageDetail);
        carouselView = (CarouselView) rootView.findViewById(R.id.carouselView);
        placeLabel = getArguments().getString("name");

        listImagesUrl = getArguments().getStringArrayList("listImagesUrl");
        txtName.setText(placeLabel);
        txtDescription.setText(getArguments().getString("description"));
        carouselView.setPageCount(listImagesUrl.size());
        carouselView.setImageListener(getImageListener());


        btnDetail.setOnClickListener(onGoClickListener());

        return rootView;
    }

    private View.OnClickListener onGoClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+ latitude+","+longitude+"(" + placeLabel +")");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        };
    }

    private ImageListener getImageListener(){
        return new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                progressBar = new ProgressBar(getContext());
                progressBar.setVisibility(View.VISIBLE);
                Picasso.with(getContext()).load(listImagesUrl.get(position)).into(imageView, new com.squareup.picasso.Callback(){
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
