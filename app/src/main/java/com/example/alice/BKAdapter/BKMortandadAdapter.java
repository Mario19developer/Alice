package com.example.alice.BKAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alice.BKModelo.BKMortandad;
import com.example.alice.R;

import java.util.List;

public class BKMortandadAdapter extends RecyclerView.Adapter<BKMortandadAdapter.BKMortandadHolder>{
    //se agrega e
    List<BKMortandad> lista;
    int layout;
    Activity activity;

    public BKMortandadAdapter(List<BKMortandad>lista, int layout, Activity activity){
        this.lista = lista;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BKMortandadHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new BKMortandadHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BKMortandadAdapter.BKMortandadHolder holder, int position) {

        BKMortandad bkMortandad = lista.get(position);
        //Se les pasa el parametro que se encuentra en firebase
        holder.txidbkcm.setText(bkMortandad.getA_Id()); //ID
        holder.txusbkcm.setText(bkMortandad.getC_Usuario()); //ID
        holder.txfbkcm.setText(bkMortandad.getE_Fecha_Muestreo()); //
        holder.txranbkcm.setText(bkMortandad.getH_Rancho_Plantacion()); //
        holder.txcamabkcm.setText(bkMortandad.getI_Cama()); //
        holder.txposisionbkcm.setText(bkMortandad.getJ_Posicion()); //
        holder.txladbkcm.setText(bkMortandad.getK_Lado()); //
        holder.txvarbkcm.setText(bkMortandad.getL_Variedad_Seleccion()); //
        holder.txclonbkcm.setText(bkMortandad.getM_Clon()); //
        holder.txqtybkcm.setText(bkMortandad.getQ_Cantidad_Planta_Muerta()); //
    }


    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class BKMortandadHolder extends RecyclerView.ViewHolder{

        TextView txidbkcm, txusbkcm, txfbkcm, txranbkcm, txcamabkcm, txposisionbkcm, txladbkcm, txvarbkcm, txclonbkcm, txqtybkcm;

        public BKMortandadHolder(@NonNull View itemView) {
            super(itemView);

            txidbkcm = itemView.findViewById(R.id.txidbkcm);
            txusbkcm = itemView.findViewById(R.id.txusbkcm);
            txfbkcm = itemView.findViewById(R.id.txfbkcm);
            txranbkcm = itemView.findViewById(R.id.txranbkcm);
            txcamabkcm = itemView.findViewById(R.id.txcamabkcm);
            txposisionbkcm = itemView.findViewById(R.id.txposisionbkcm);
            txladbkcm = itemView.findViewById(R.id.txladbkcm);
            txvarbkcm = itemView.findViewById(R.id.txvarbkcm);
            txclonbkcm = itemView.findViewById(R.id.txclonbkcm);
            txqtybkcm = itemView.findViewById(R.id.txqtybkcm);
        }
    }
}
