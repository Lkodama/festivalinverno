package com.kodamalabs.festivalinverno.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kodamalabs.festivalinverno.R;

public class CategoryFragment extends Fragment {

    public static CategoryFragment newInstance(){
        return new CategoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        Button btnCompras = (Button) rootView.findViewById(R.id.btn_compras);
        Button btnRestaurante = (Button) rootView.findViewById(R.id.btn_restaurante);
        Button btnPousada = (Button) rootView.findViewById(R.id.btn_pousada);
        Button btnSaude = (Button) rootView.findViewById(R.id.btn_saude);
        Button btnServico = (Button) rootView.findViewById(R.id.btn_servico);

        btnCompras.setOnClickListener(onComprasListener());
        btnRestaurante.setOnClickListener(onRestauranteListener());
        btnPousada.setOnClickListener(onPousadaListener());
        btnSaude.setOnClickListener(onSaudeListener());
        btnServico.setOnClickListener(onServicoListener());

        return rootView;
    }

    private View.OnClickListener onComprasListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCategory("COMPRAS");
            }
        };
    }

    private View.OnClickListener onRestauranteListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCategory("RESTAURANTE");
            }
        };
    }

    private View.OnClickListener onPousadaListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCategory("POUSADA");
            }
        };
    }

    private View.OnClickListener onSaudeListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCategory("SAUDE");
            }
        };
    }

    private View.OnClickListener onServicoListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCategory("SERVICO");
            }
        };
    }


    private void sendCategory(String category){
        Bundle bundle = new Bundle();
        bundle.putString("category", category);

        Fragment serviceFragment = ServiceFragment.newInstance();
        serviceFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, serviceFragment,"ServiceFragment")
                .addToBackStack(null)
                .commit();
    }
}
