package com.example.alice.Vistas_GH_Brotes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alice.GHModelo.GreenBrotes;
import com.example.alice.GHModelo.GreenBrotesservice;
import com.example.alice.R;
import com.example.alice.GHAdapter.GHBrotesAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ghBrotesLista extends Fragment {

    RecyclerView rcpbi;

    public ghBrotesLista() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gh_brotes_lista, container, false);

        rcpbi = view.findViewById(R.id.rcpbi);

        LinearLayoutManager lmpbi = new LinearLayoutManager(getActivity());
        lmpbi.setOrientation(RecyclerView.VERTICAL);
        lmpbi.setReverseLayout(true);
        lmpbi.setStackFromEnd(true);
        rcpbi.setLayoutManager(lmpbi);

        GHBrotesAdapter adapter = new GHBrotesAdapter(GreenBrotesservice.greenbrotes,R.layout.ghbrotes,getActivity());
        rcpbi.setAdapter(adapter);

        cargardatosfbpbi();

        return view;
    }

    private void cargardatosfbpbi() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Green House 2023").child("Plantación Brotes");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                GreenBrotes greenBrotes = snapshot.getValue(GreenBrotes.class);
                greenBrotes.setA_Id(snapshot.getKey());

                if (!GreenBrotesservice.greenbrotes.contains(greenBrotes)){
                    GreenBrotesservice.addbrotes(greenBrotes);
                }

                rcpbi.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                GreenBrotes greenBrotes = snapshot.getValue(GreenBrotes.class);
                greenBrotes.setA_Id(snapshot.getKey());

                if (GreenBrotesservice.greenbrotes.contains(greenBrotes)){
                    GreenBrotesservice.updatebrotes(greenBrotes);
                }

                rcpbi.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                GreenBrotes greenBrotes = snapshot.getValue(GreenBrotes.class);
                greenBrotes.setA_Id(snapshot.getKey());

                if (GreenBrotesservice.greenbrotes.contains(greenBrotes)){
                    GreenBrotesservice.removebrotes(greenBrotes);
                }

                rcpbi.getAdapter().notifyDataSetChanged();
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