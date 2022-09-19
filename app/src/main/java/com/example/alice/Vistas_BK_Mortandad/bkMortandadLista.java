package com.example.alice.Vistas_BK_Mortandad;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alice.BKAdapter.BKMortandadAdapter;
import com.example.alice.BKModelo.BKMortandad;
import com.example.alice.BKModelo.BKMortandadservice;
import com.example.alice.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class bkMortandadLista extends Fragment {

    //se agrega al layout
    RecyclerView rcalv;

    public bkMortandadLista() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bk_mortandad_lista, container, false);

        //Seteo de layout
        rcalv = view.findViewById(R.id.rcalv);

        //se genera el layout mostandrando un apartado el cual se replicara a todos los datos guardado
        LinearLayoutManager lmalv = new LinearLayoutManager(getActivity());
        lmalv.setOrientation(RecyclerView.VERTICAL);
        lmalv.setReverseLayout(true);
        lmalv.setStackFromEnd(true);
        rcalv.setLayoutManager(lmalv);

        BKMortandadAdapter adapter = new BKMortandadAdapter(BKMortandadservice.bkMortandads,R.layout.bkmortandad,getActivity());
        rcalv.setAdapter(adapter);

        //se llama al metodo para traer datos de firebase
        cargardatosbkcm();

        return view;
    }

    private void cargardatosbkcm() {
        // se instancia la base de datos
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Blackberry_2023").child("Conteos_Mortandad");

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKMortandad bkMortandad = snapshot.getValue(BKMortandad.class);
                bkMortandad.setA_Id(snapshot.getKey());

                if (!BKMortandadservice.bkMortandads.contains(bkMortandad)){
                    BKMortandadservice.addbkMortandad(bkMortandad);
                }

                rcalv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKMortandad bkMortandad = snapshot.getValue(BKMortandad.class);
                bkMortandad.setA_Id(snapshot.getKey());

                if (BKMortandadservice.bkMortandads.contains(bkMortandad)){
                    BKMortandadservice.updatebkMortandad(bkMortandad);
                }

                rcalv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                BKMortandad bkMortandad = snapshot.getValue(BKMortandad.class);
                bkMortandad.setA_Id(snapshot.getKey());

                if (BKMortandadservice.bkMortandads.contains(bkMortandad)){
                    BKMortandadservice.removebkMortandad(bkMortandad);
                }

                rcalv.getAdapter().notifyDataSetChanged();
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