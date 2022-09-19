package com.example.alice.Vistas_GH_Trasplante;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alice.GHModelo.GreenTrasplante;
import com.example.alice.GHModelo.GreenTrasplanteservice;
import com.example.alice.R;
import com.example.alice.GHAdapter.GHTrasplanteAdapter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ghTrasplanteLista extends Fragment {

    RecyclerView rct;

    public ghTrasplanteLista() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gh_trasplante_lista, container, false);

        rct = view.findViewById(R.id.rct);

        LinearLayoutManager lmt = new LinearLayoutManager(getActivity());
        lmt.setOrientation(RecyclerView.VERTICAL);
        lmt.setReverseLayout(true);
        lmt.setStackFromEnd(true);
        rct.setLayoutManager(lmt);

        GHTrasplanteAdapter adapter = new GHTrasplanteAdapter(GreenTrasplanteservice.greentrasplantes,R.layout.ghtrasplante,getActivity());
        rct.setAdapter(adapter);

        cargardatosfbti();

        return view;
    }

    private void cargardatosfbti() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Green House 2022").child("Trasplante p1");

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                GreenTrasplante greenTrasplante = snapshot.getValue(GreenTrasplante.class);
                greenTrasplante.setA_Id(snapshot.getKey());

                if (!GreenTrasplanteservice.greentrasplantes.contains(greenTrasplante)){
                    GreenTrasplanteservice.addtrasplante(greenTrasplante);
                }

                rct.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                GreenTrasplante greenTrasplante = snapshot.getValue(GreenTrasplante.class);
                greenTrasplante.setA_Id(snapshot.getKey());

                if (GreenTrasplanteservice.greentrasplantes.contains(greenTrasplante)){
                    GreenTrasplanteservice.updatetrasplante(greenTrasplante);
                }

                rct.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                GreenTrasplante greenTrasplante = snapshot.getValue(GreenTrasplante.class);
                greenTrasplante.setA_Id(snapshot.getKey());

                if (GreenTrasplanteservice.greentrasplantes.contains(greenTrasplante)){
                    GreenTrasplanteservice.removetrasplante(greenTrasplante);
                }

                rct.getAdapter().notifyDataSetChanged();
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