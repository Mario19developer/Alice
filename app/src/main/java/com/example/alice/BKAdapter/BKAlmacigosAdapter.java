package com.example.alice.BKAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alice.BKModelo.BKAlmacigos;
import com.example.alice.R;

import java.util.List;

public class BKAlmacigosAdapter extends RecyclerView.Adapter<BKAlmacigosAdapter.BKAlmacigosHolder>{
    //se agrega e
    List <BKAlmacigos> lista;
    int layout;
    Activity activity;

    public BKAlmacigosAdapter(List<BKAlmacigos> lista, int layout, Activity activity){
        this.lista = lista;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BKAlmacigosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //se genera la vista
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new BKAlmacigosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BKAlmacigosAdapter.BKAlmacigosHolder holder, int position) {

        BKAlmacigos bkAlmacigos = lista.get(position);
        //Se les pasa el parametro que se encuentra en firebase
        holder.txidbkpa.setText(bkAlmacigos.getA_Id()); //ID
        holder.txusbkpa.setText(bkAlmacigos.getC_Usuario()); //ID
        holder.txfbkpa.setText(bkAlmacigos.getE_Fecha_Plantacion()); //
        holder.txranbkpa.setText(bkAlmacigos.getG_Rancho_Plantacion()); //
        holder.txcamabkpa.setText(bkAlmacigos.getJ_Cama()); //
        holder.txposisionbkpa.setText(bkAlmacigos.getK_Posicion()); //
        holder.txladbkpa.setText(bkAlmacigos.getL_Lado()); //
        holder.txvarbkpa.setText(bkAlmacigos.getO_Variedad_Seleccion()); //
        holder.txclonbkpa.setText(bkAlmacigos.getP_Clon()); //
        holder.txprodbkpa.setText(bkAlmacigos.getR_Producto_Plantado()); //
        holder.txqtybkpa.setText(bkAlmacigos.getW_Total_Macetas_Plantadas()); //
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class BKAlmacigosHolder extends RecyclerView.ViewHolder{
        //se agregan los elementos del layout a esta clase
        TextView txidbkpa, txusbkpa, txfbkpa, txranbkpa, txcamabkpa, txposisionbkpa,
                txladbkpa, txvarbkpa, txclonbkpa, txprodbkpa, txqtybkpa;

        public BKAlmacigosHolder(@NonNull View itemView) {
            super(itemView);

            txidbkpa = itemView.findViewById(R.id.txidbkpa);
            txusbkpa = itemView.findViewById(R.id.txusbkpa);
            txfbkpa = itemView.findViewById(R.id.txfbkpa);
            txranbkpa = itemView.findViewById(R.id.txranbkpa);
            txcamabkpa = itemView.findViewById(R.id.txcamabkpa);
            txposisionbkpa = itemView.findViewById(R.id.txposisionbkpa);
            txladbkpa = itemView.findViewById(R.id.txladbkpa);
            txvarbkpa = itemView.findViewById(R.id.txvarbkpa);
            txclonbkpa = itemView.findViewById(R.id.txclonbkpa);
            txprodbkpa = itemView.findViewById(R.id.txprodbkpa);
            txqtybkpa = itemView.findViewById(R.id.txqtybkpa);

        }
    }
}
