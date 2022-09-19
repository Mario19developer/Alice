package com.example.alice.BKAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alice.BKModelo.BKConsolidacion;
import com.example.alice.R;

import java.util.List;

public class BKConsolidacionAdapter extends RecyclerView.Adapter<BKConsolidacionAdapter.BKConsolidacionHolder> {

    //se agrega e
    List<BKConsolidacion> lista;
    int layout;
    Activity activity;

    public BKBrotesAdapter(List<BKConsolidacion, lista, int layout, activity>){
        this.lista = lista;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BKConsolidacionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //se genera la vista
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new BKConsolidacionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BKConsolidacionAdapter.BKConsolidacionHolder holder, int position) {

        BKConsolidacion bkConsolidacion = lista.get(position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public class BKConsolidacionHolder extends RecyclerView.ViewHolder{

        //se agregan los elementos del layout a esta clase
        TextView txidbkpb, txusbkpb, txfbkpb, txranbkpb, txcamabkpb, txposisionbkpb, txladbkpb,
                txvarbkpb, txclonbkpb, txprodbkpb, txqtybkpb;

        public BKConsolidacionHolder(@NonNull View itemView) {
            super(itemView);

            txidbkpb = itemView.findViewById(R.id.txidbkpb);
        }
    }
}
