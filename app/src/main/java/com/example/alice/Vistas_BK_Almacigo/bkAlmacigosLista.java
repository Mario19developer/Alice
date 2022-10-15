package com.example.alice.Vistas_BK_Almacigo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alice.BKModelo.BKAlmacigos;
import com.example.alice.BKAdapter.BKAlmacigosAdapter;
import com.example.alice.BKModelo.BKAlmacigosservice;
import com.example.alice.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class bkAlmacigosLista extends Fragment {

    //se agrega al layout
    RecyclerView rcbkpa;

    public bkAlmacigosLista() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bk_almacigos_lista, container, false);

        //Seteo de layout
        rcbkpa = view.findViewById(R.id.rcbkpa);

        //se genera el layout mostandrando un apartado el cual se replicara a todos los datos guardado
        LinearLayoutManager lmalv = new LinearLayoutManager(getActivity());
        lmalv.setOrientation(RecyclerView.VERTICAL);
        lmalv.setReverseLayout(true);
        lmalv.setStackFromEnd(true);
        rcbkpa.setLayoutManager(lmalv);

        BKAlmacigosAdapter adapter = new BKAlmacigosAdapter(BKAlmacigosservice.bkAlmacigos, R.layout.bkalmacigos, getActivity());
        rcbkpa.setAdapter(adapter);

        //se llama al metodo para traer datos de firebase
        cargardatosbkpa();

        //genera la vista
        return view;
    }

    private void cargardatosbkpa(){
        // se instancia la base de datos
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Blackberry_2023").child("Plantacion Almacigos");

        //se valida que haya datos en algun evento, si se agrega, si se elimina, si cambia
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKAlmacigos bkAlmacigos = snapshot.getValue(BKAlmacigos.class);
                bkAlmacigos.setA_Id(snapshot.getKey());

                if (!BKAlmacigosservice.bkAlmacigos.contains(bkAlmacigos)){
                    BKAlmacigosservice.addbkalmacigos(bkAlmacigos);
                }

                rcbkpa.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                BKAlmacigos bkAlmacigos = snapshot.getValue(BKAlmacigos.class);
                bkAlmacigos.setA_Id(snapshot.getKey());

                if (BKAlmacigosservice.bkAlmacigos.contains(bkAlmacigos)){
                    BKAlmacigosservice.updatebkalmacigos(bkAlmacigos);
                }

                rcbkpa.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                BKAlmacigos bkAlmacigos = snapshot.getValue(BKAlmacigos.class);
                bkAlmacigos.setA_Id(snapshot.getKey());

                if (BKAlmacigosservice.bkAlmacigos.contains(bkAlmacigos)){
                    BKAlmacigosservice.removebkalmacigos(bkAlmacigos);
                }

                rcbkpa.getAdapter().notifyDataSetChanged();
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