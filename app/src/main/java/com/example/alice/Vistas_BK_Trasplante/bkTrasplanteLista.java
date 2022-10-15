package com.example.alice.Vistas_BK_Trasplante;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alice.BKAdapter.BKBrotesAdapter;
import com.example.alice.BKAdapter.BKTrasplanteAdapter;
import com.example.alice.BKModelo.BKBrotes;
import com.example.alice.BKModelo.BKBrotesservice;
import com.example.alice.BKModelo.BKTrasplante;
import com.example.alice.BKModelo.BKTrasplanteservice;
import com.example.alice.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class bkTrasplanteLista extends Fragment {

    //se agrega al layout
    RecyclerView rcbktp;

    public bkTrasplanteLista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bk_trasplante_lista, container, false);

        //Seteo de layout
        rcbktp = view.findViewById(R.id.rcbktp);

        //se genera el layout mostandrando un apartado el cual se replicara a todos los datos guardado
        LinearLayoutManager lmalv = new LinearLayoutManager(getActivity());
        lmalv.setOrientation(RecyclerView.VERTICAL);
        lmalv.setReverseLayout(true);
        lmalv.setStackFromEnd(true);
        rcbktp.setLayoutManager(lmalv);

        BKTrasplanteAdapter adapter = new BKTrasplanteAdapter(BKTrasplanteservice.bkTrasplantes, R.layout.bktrasplante, getActivity());
        rcbktp.setAdapter(adapter);


        //se llama al metodo para traer datos de firebase
        cargardatosbktr();

        return view;
    }

    private void cargardatosbktr() {
         // se instancia la base de datos
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Blackberry_2023").child("Trasplante");

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKTrasplante bkTrasplante = snapshot.getValue(BKTrasplante.class);
                bkTrasplante.setA_Id(snapshot.getKey());

                if (!BKTrasplanteservice.bkTrasplantes.contains(bkTrasplante)){
                    BKTrasplanteservice.addbktrasplante(bkTrasplante);
                }

                rcbktp.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKTrasplante bkTrasplante = snapshot.getValue(BKTrasplante.class);
                bkTrasplante.setA_Id(snapshot.getKey());

                if (BKTrasplanteservice.bkTrasplantes.contains(bkTrasplante)){
                    BKTrasplanteservice.updatebktrasplante(bkTrasplante);
                }

                rcbktp.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                BKTrasplante bkTrasplante = snapshot.getValue(BKTrasplante.class);
                bkTrasplante.setA_Id(snapshot.getKey());

                if (BKTrasplanteservice.bkTrasplantes.contains(bkTrasplante)){
                    BKTrasplanteservice.removebktrasplante(bkTrasplante);
                }

                rcbktp.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}