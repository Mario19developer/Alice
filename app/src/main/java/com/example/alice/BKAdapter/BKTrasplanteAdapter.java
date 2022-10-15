package com.example.alice.BKAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alice.BKModelo.BKTrasplante;
import com.example.alice.R;

import java.util.List;

public class BKTrasplanteAdapter extends RecyclerView.Adapter<BKTrasplanteAdapter.BKTrasplanteHolder> {

    //se agrega e
    List<BKTrasplante> lista;
    int layout;
    Activity activity;

    public BKTrasplanteAdapter(List<BKTrasplante> lista, int layout, Activity activity){
        this.lista = lista;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BKTrasplanteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new BKTrasplanteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BKTrasplanteAdapter.BKTrasplanteHolder holder, int position) {

        BKTrasplante bkTrasplante = lista.get(position);
        //Se les pasa el parametro que se encuentra en firebase
        holder.txidbktr.setText(bkTrasplante.getA_Id()); //ID
        holder.txusbktr.setText(bkTrasplante.getC_Usuario()); //
        holder.txfrbktr.setText(bkTrasplante.getD_Fecha_Registro()); //
        holder.txfbktr.setText(bkTrasplante.getE_Fecha_Trasplante()); //
        holder.txranbktr.setText(bkTrasplante.getG_Rancho()); //
        holder.txcamabktr.setText(bkTrasplante.getH_Cama()); //
        holder.txposisionbktr.setText(bkTrasplante.getI_Posicion()); //
        holder.txvarbktr.setText(bkTrasplante.getK_Variedad_Seleccion()); //
        holder.txclonbktr.setText(bkTrasplante.getL_Clon()); //
        holder.txprodbktr.setText(bkTrasplante.getM_Producto_Plantado()); //
        holder.txqtybktr.setText(bkTrasplante.getT_Total_Planta_Plantada()); //
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class BKTrasplanteHolder extends RecyclerView.ViewHolder{

        //se agregan los elementos del layout a esta clase
        TextView txidbktr, txusbktr, txfrbktr, txfbktr, txranbktr, txcamabktr, txposisionbktr,
                txvarbktr, txclonbktr, txprodbktr, txqtybktr;

        public BKTrasplanteHolder(@NonNull View itemView) {
            super(itemView);

            txidbktr = itemView.findViewById(R.id.txidbktr);
            txusbktr = itemView.findViewById(R.id.txusbktr);
            txfrbktr = itemView.findViewById(R.id.txfrbktr);
            txfbktr = itemView.findViewById(R.id.txfbktr);
            txranbktr = itemView.findViewById(R.id.txranbktr);
            txcamabktr = itemView.findViewById(R.id.txcamabktr);
            txposisionbktr = itemView.findViewById(R.id.txposisionbktr);
            txvarbktr = itemView.findViewById(R.id.txvarbktr);
            txclonbktr = itemView.findViewById(R.id.txclonbktr);
            txprodbktr = itemView.findViewById(R.id.txprodbktr);
            txqtybktr = itemView.findViewById(R.id.txqtybktr);
        }
    }
}
