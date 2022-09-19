package com.example.alice.Vistas_BK_Consolidacion;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alice.R;


public class bkConsolidacionLista extends Fragment {

    //se agrega al layout
    RecyclerView rcalv;

    public bkConsolidacionLista() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bk_consolidacion_lista, container, false);

        //Seteo de layout
        rcalv = view.findViewById(R.id.rcalv);

        LinearLayoutManager lmalv = new LinearLayoutManager(getActivity());
        lmalv.setOrientation(RecyclerView.VERTICAL);
        lmalv.setReverseLayout(true);
        lmalv.setStackFromEnd(true);
        rcalv.setLayoutManager(lmalv);

        return view;
    }
}