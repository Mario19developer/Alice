package com.example.alice.Vistas_GH_Almacigo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alice.GHModelo.GreenAlmacigos;
import com.example.alice.GHModelo.GreenAlmacigosservice;
import com.example.alice.R;
import com.example.alice.GHAdapter.GHAlmacigosAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ghAlmacigosLista extends Fragment {

    //se agrega al layout
    RecyclerView rcalv;

    public ghAlmacigosLista() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gh_almacigos_lista, container, false);

        //Seteo de layout
        rcalv = view.findViewById(R.id.rcalv);

        //se genera el layout mostandrando un apartado el cual se replicara a todos los datos guardado
        LinearLayoutManager lmalv = new LinearLayoutManager(getActivity());
        lmalv.setOrientation(RecyclerView.VERTICAL);
        lmalv.setReverseLayout(true);
        lmalv.setStackFromEnd(true);
        rcalv.setLayoutManager(lmalv);

        //se genera el adaptador y se fusiona el fragment dentro del activity
        GHAlmacigosAdapter adapter = new GHAlmacigosAdapter(GreenAlmacigosservice.greenalmacigoss,R.layout.ghalmacigos, getActivity());
        rcalv.setAdapter(adapter);

        //se llama al metodo para traer datos de firebase
        cargardatosfb();

        //genera la vista
        return view;
    }

    private void cargardatosfb() {
        // se instancia la base de datos
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Green House 2023").child("Plantación Almacigos");

        //se valida que haya datos en algun evento, si se agrega, si se elimina, si cambia
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                GreenAlmacigos greenAlmacigos = snapshot.getValue(GreenAlmacigos.class);
                greenAlmacigos.setA_Id(snapshot.getKey());

                if (!GreenAlmacigosservice.greenalmacigoss.contains(greenAlmacigos)){
                    GreenAlmacigosservice.addalmacigos(greenAlmacigos);
                }

                rcalv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                GreenAlmacigos greenAlmacigos = snapshot.getValue(GreenAlmacigos.class);
                greenAlmacigos.setA_Id(snapshot.getKey());

                if (GreenAlmacigosservice.greenalmacigoss.contains(greenAlmacigos)){
                    GreenAlmacigosservice.updatealmacigos(greenAlmacigos);
                }

                rcalv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                GreenAlmacigos greenAlmacigos = snapshot.getValue(GreenAlmacigos.class);
                greenAlmacigos.setA_Id(snapshot.getKey());

                if (GreenAlmacigosservice.greenalmacigoss.contains(greenAlmacigos)){
                    GreenAlmacigosservice.removealmacigos(greenAlmacigos);
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