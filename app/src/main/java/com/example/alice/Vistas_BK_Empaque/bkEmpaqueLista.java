package com.example.alice.Vistas_BK_Empaque;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alice.BKAdapter.BKEmpaqueAdapter;
import com.example.alice.BKModelo.BKConsolidacion;
import com.example.alice.BKModelo.BKConsolidacionservice;
import com.example.alice.BKModelo.BKEmpaque;
import com.example.alice.BKModelo.BKEmpaqueservice;
import com.example.alice.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class bkEmpaqueLista extends Fragment {

    //se agrega al layout
    RecyclerView rcbkem;

    public bkEmpaqueLista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bk_empaque_lista, container, false);

        //Seteo de layout
        rcbkem = view.findViewById(R.id.rcbkem);

        //se genera el layout mostandrando un apartado el cual se replicara a todos los datos guardado
        LinearLayoutManager lmalv = new LinearLayoutManager(getActivity());
        lmalv.setOrientation(RecyclerView.VERTICAL);
        lmalv.setReverseLayout(true);
        lmalv.setStackFromEnd(true);
        rcbkem.setLayoutManager(lmalv);

        BKEmpaqueAdapter adapter = new BKEmpaqueAdapter(BKEmpaqueservice.bkEmpaques, R.layout.bkempaque, getActivity());
        rcbkem.setAdapter(adapter);

        //se llama al metodo para traer datos de firebase
        cargardatosbkem();

        return view;
    }

    private void cargardatosbkem() {
        // se instancia la base de datos
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Blackberry_2023").child("Empaque");

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKEmpaque bkEmpaque = snapshot.getValue(BKEmpaque.class);
                bkEmpaque.setA_Id(snapshot.getKey());

                if (!BKEmpaqueservice.bkEmpaques.contains(bkEmpaque)){
                    BKEmpaqueservice.addbkempaque(bkEmpaque);
                }

                rcbkem.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKEmpaque bkEmpaque = snapshot.getValue(BKEmpaque.class);
                bkEmpaque.setA_Id(snapshot.getKey());

                if (BKEmpaqueservice.bkEmpaques.contains(bkEmpaque)){
                    BKEmpaqueservice.updatebkempaque(bkEmpaque);
                }

                rcbkem.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                BKEmpaque bkEmpaque = snapshot.getValue(BKEmpaque.class);
                bkEmpaque.setA_Id(snapshot.getKey());

                if (BKEmpaqueservice.bkEmpaques.contains(bkEmpaque)){
                    BKEmpaqueservice.removebkempaque(bkEmpaque);
                }

                rcbkem.getAdapter().notifyDataSetChanged();
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