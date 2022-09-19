package com.example.alice.BKAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alice.BKModelo.BKBrotes;
import com.example.alice.R;

import java.util.List;

public class BKBrotesAdapter extends RecyclerView.Adapter<BKBrotesAdapter.BKBrotesHolder>{

    //se agrega e
    List<BKBrotes> lista;
    int layout;
    Activity activity;

    public BKBrotesAdapter (List<BKBrotes> lista, int layout, Activity activity){
        this.lista = lista;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BKBrotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //se genera la vista
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new BKBrotesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BKBrotesAdapter.BKBrotesHolder holder, int position) {

        BKBrotes bkBrotes = lista.get(position);
        //Se les pasa el parametro que se encuentra en firebase
        holder.txidbkpb.setText(bkBrotes.getA_Id()); //ID
        holder.txusbkpb.setText(bkBrotes.getC_Usuario()); //ID
        holder.txfbkpb.setText(bkBrotes.getE_Fecha_Plantacion()); //
        holder.txranbkpb.setText(bkBrotes.getG_Rancho_Plantacion()); //
        holder.txcamabkpb.setText(bkBrotes.getH_Cama_Origen()); //
        holder.txposisionbkpb.setText(bkBrotes.getI_Posicion_Origen()); //
        holder.txladbkpb.setText(bkBrotes.getJ_Lado_Origen()); //
        holder.txvarbkpb.setText(bkBrotes.getK_Variedad_Seleccion()); //
        holder.txclonbkpb.setText(bkBrotes.getL_Clon()); //
        holder.txprodbkpb.setText(bkBrotes.getM_Producto_Plantado()); //
        holder.txqtybkpb.setText(bkBrotes.getS_Total_Planta_Plantada()); //
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class BKBrotesHolder extends RecyclerView.ViewHolder{

        //se agregan los elementos del layout a esta clase
        TextView txidbkpb, txusbkpb, txfbkpb, txranbkpb, txcamabkpb, txposisionbkpb, txladbkpb,
                txvarbkpb, txclonbkpb, txprodbkpb, txqtybkpb;

        public BKBrotesHolder(@NonNull View itemView) {
            super(itemView);

            txidbkpb = itemView.findViewById(R.id.txidbkpb);
            txusbkpb = itemView.findViewById(R.id.txusbkpb);
            txfbkpb = itemView.findViewById(R.id.txfbkpb);
            txranbkpb = itemView.findViewById(R.id.txranbkpb);
            txcamabkpb = itemView.findViewById(R.id.txcamabkpb);
            txposisionbkpb = itemView.findViewById(R.id.txposisionbkpb);
            txladbkpb = itemView.findViewById(R.id.txladbkpb);
            txvarbkpb = itemView.findViewById(R.id.txvarbkpb);
            txclonbkpb = itemView.findViewById(R.id.txclonbkpb);
            txprodbkpb = itemView.findViewById(R.id.txprodbkpb);
            txqtybkpb = itemView.findViewById(R.id.txqtybkpb);
        }
    }
}
