package com.example.alice.Vistas_BK_Consolidacion;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alice.BKAdapter.BKConsolidacionAdapter;
import com.example.alice.BKModelo.BKBrotes;
import com.example.alice.BKModelo.BKBrotesservice;
import com.example.alice.BKModelo.BKConsolidacion;
import com.example.alice.BKModelo.BKConsolidacionservice;
import com.example.alice.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


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

        BKConsolidacionAdapter adapter = new BKConsolidacionAdapter(BKConsolidacionservice.bkConsolidacion, R.layout.bkconsolidacion, getActivity());
        rcalv.setAdapter(adapter);

        //se llama al metodo para traer datos de firebase
        cargardatosbkco();

        return view;
    }

    private void cargardatosbkco() {
        // se instancia la base de datos
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Blackberry_2023").child("Consolidacion");

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKConsolidacion bkConsolidacion = snapshot.getValue(BKConsolidacion.class);
                bkConsolidacion.setA_Id(snapshot.getKey());

                if (!BKConsolidacionservice.bkConsolidacion.contains(bkConsolidacion)){
                    BKConsolidacionservice.addbkConsolidacion(bkConsolidacion);
                }

                rcalv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKConsolidacion bkConsolidacion = snapshot.getValue(BKConsolidacion.class);
                bkConsolidacion.setA_Id(snapshot.getKey());

                if (BKConsolidacionservice.bkConsolidacion.contains(bkConsolidacion)){
                    BKConsolidacionservice.updatebkConsolidacion(bkConsolidacion);
                }

                rcalv.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKConsolidacion bkConsolidacion = snapshot.getValue(BKConsolidacion.class);
                bkConsolidacion.setA_Id(snapshot.getKey());

                if (BKConsolidacionservice.bkConsolidacion.contains(bkConsolidacion)){
                    BKConsolidacionservice.removebkConsolidacion(bkConsolidacion);
                }

                rcalv.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}