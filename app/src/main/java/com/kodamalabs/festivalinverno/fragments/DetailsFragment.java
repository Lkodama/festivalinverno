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

public class DetailsFragment extends Fragment {

    private ProgressBar progressBar;
    private String latitude;
    private String longitude;
    private String placeLabel;

    public static DetailsFragment newInstance(){
        return new DetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        latitude = getArguments().getString("latitude");
        longitude = getArguments().getString("longitude");

        TextView txtName = (TextView)rootView.findViewById(R.id.txt_detail_name);
        TextView txtDescription = (TextView)rootView.findViewById(R.id.txt_detail_description);
        TextView txtAddress = (TextView)rootView.findViewById(R.id.txt_detail_address);
        Button btnDetail = (Button)rootView.findViewById(R.id.btn_detail);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageDetail);

        placeLabel = getArguments().getString("name");
        txtName.setText(placeLabel);
        txtDescription.setText(getArguments().getString("description"));
        txtAddress.setText(getArguments().getString("address"));

        progressBar = new ProgressBar(getContext());
        progressBar.setVisibility(View.VISIBLE);
        Picasso.with(getContext()).load(getArguments().getString("imageUrl")).centerCrop().resize(500,500).into(imageView, new com.squareup.picasso.Callback(){
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
}
