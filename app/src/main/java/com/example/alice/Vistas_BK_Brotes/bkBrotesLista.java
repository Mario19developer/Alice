package com.example.alice.Vistas_BK_Brotes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alice.BKAdapter.BKAlmacigosAdapter;
import com.example.alice.BKAdapter.BKBrotesAdapter;
import com.example.alice.BKModelo.BKAlmacigos;
import com.example.alice.BKModelo.BKAlmacigosservice;
import com.example.alice.BKModelo.BKBrotes;
import com.example.alice.BKModelo.BKBrotesservice;
import com.example.alice.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class bkBrotesLista extends Fragment {

    //se agrega al layout
    RecyclerView rcbkpb;

    public bkBrotesLista() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bk_brotes_lista, container, false);

        //Seteo de layout
        rcbkpb = view.findViewById(R.id.rcbkpb);

        //se genera el layout mostandrando un apartado el cual se replicara a todos los datos guardado
        LinearLayoutManager lmalv = new LinearLayoutManager(getActivity());
        lmalv.setOrientation(RecyclerView.VERTICAL);
        lmalv.setReverseLayout(true);
        lmalv.setStackFromEnd(true);
        rcbkpb.setLayoutManager(lmalv);

        BKBrotesAdapter adapter = new BKBrotesAdapter(BKBrotesservice.bkBrotes, R.layout.bkbrotes, getActivity());
        rcbkpb.setAdapter(adapter);

        //se llama al metodo para traer datos de firebase
        cargardatosbkpb();

        return view;
    }

    private void cargardatosbkpb() {
         // se instancia la base de datos
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Blackberry_2023").child("Plantacion Brotes");

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKBrotes bkBrotes = snapshot.getValue(BKBrotes.class);
                bkBrotes.setA_Id(snapshot.getKey());

                if (!BKBrotesservice.bkBrotes.contains(bkBrotes)){
                    BKBrotesservice.addbkBrotes(bkBrotes);
                }

                rcbkpb.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKBrotes bkBrotes = snapshot.getValue(BKBrotes.class);
                bkBrotes.setA_Id(snapshot.getKey());

                if (BKBrotesservice.bkBrotes.contains(bkBrotes)){
                    BKBrotesservice.updatebkBrotes(bkBrotes);
                }

                rcbkpb.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                BKBrotes bkBrotes = snapshot.getValue(BKBrotes.class);
                bkBrotes.setA_Id(snapshot.getKey());

                if (BKBrotesservice.bkBrotes.contains(bkBrotes)){
                    BKBrotesservice.removebkBrotes(bkBrotes);
                }

                rcbkpb.getAdapter().notifyDataSetChanged();

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