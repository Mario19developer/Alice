package com.example.alice.GHAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alice.GHModelo.GreenAlmacigos;
import com.example.alice.R;

import java.util.List;

public class GHAlmacigosAdapter extends RecyclerView.Adapter<GHAlmacigosAdapter.AlmacigosHolder> {
    //se agrega e
    List <GreenAlmacigos> lista;
    int layout;
    Activity activity;

    public GHAlmacigosAdapter(List<GreenAlmacigos> lista, int layout, Activity activity){

        this.lista = lista;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AlmacigosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //se genera la vista
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new AlmacigosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GHAlmacigosAdapter.AlmacigosHolder holder, int position) {

        //se carga toda la informacion a las listas
        GreenAlmacigos greenAlmacigos = lista.get(position);

        //Se les pasa el parametro que se encuentra en firebase
        holder.txidva.setText(greenAlmacigos.getA_Id()); //ID
        holder.txusva.setText(greenAlmacigos.getC_Usuario());
        holder.txfva.setText(greenAlmacigos.getE_Fecha_Plantacion()); //
        holder.txranva.setText(greenAlmacigos.getG_Rancho_Plantacion()); //
        holder.txvarva.setText(greenAlmacigos.getP_Variedad_Seleccion());
        holder.txqtyva.setText(greenAlmacigos.getU_Catidad_Plantada());
        holder.txsecva.setText(greenAlmacigos.getJ_Sector());
        holder.txtunelva.setText(greenAlmacigos.getK_Tunel());
        holder.txladova.setText(greenAlmacigos.getL_Lado());
        holder.txcamava.setText(greenAlmacigos.getM_Cama());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class AlmacigosHolder extends RecyclerView.ViewHolder{
        //se agregan los elementos del layout a esta clase
        TextView txidva, txusva, txfva, txranva, txvarva, txqtyva, txsecva, txtunelva, txladova, txcamava;


        public AlmacigosHolder(@NonNull View itemView) {
            super(itemView);

            //seteo de layout
            txidva = itemView.findViewById(R.id.txidva);
            txusva  = itemView.findViewById(R.id.txusva);
            txfva = itemView.findViewById(R.id.txfva);
            txranva = itemView.findViewById(R.id.txranva);
            txvarva = itemView.findViewById(R.id.txvarva);
            txqtyva = itemView.findViewById(R.id.txqtyva);
            txsecva = itemView.findViewById(R.id.txsecva);
            txtunelva = itemView.findViewById(R.id.txtunelva);
            txladova = itemView.findViewById(R.id.txladova);
            txcamava = itemView.findViewById(R.id.txcamava);

        }
    }
}
