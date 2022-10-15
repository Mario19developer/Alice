package com.example.alice.BKAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alice.BKModelo.BKEmpaque;
import com.example.alice.R;

import java.util.List;

public class BKEmpaqueAdapter extends RecyclerView.Adapter<BKEmpaqueAdapter.BKEmpaqueHolder> {
    //
    List<BKEmpaque> lista;
    int layout;
    Activity activity;

    public BKEmpaqueAdapter(List<BKEmpaque> lista, int layout, Activity activity){
        this.lista = lista;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BKEmpaqueHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //se genera la vista
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new BKEmpaqueHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BKEmpaqueAdapter.BKEmpaqueHolder holder, int position) {
        BKEmpaque bkEmpaque = lista.get(position);
        //Se les pasa el parametro que se encuentra en firebase
        holder.txidbkem.setText(bkEmpaque.getA_Id()); //ID
        holder.txusbkem.setText(bkEmpaque.getC_Usuario()); //ID
        holder.txfrbkem.setText(bkEmpaque.getD_Fecha_Registro()); //ID
        holder.txfbkem.setText(bkEmpaque.getE_Fecha_Empaque()); //ID
        holder.txranbkem.setText(bkEmpaque.getG_Rancho()); //ID
        holder.txdestinobkem.setText(bkEmpaque.getM_Destino()); //ID
        holder.txvarbkem.setText(bkEmpaque.getH_Variedad_Seleccion()); //ID
        holder.txclonbkem.setText(bkEmpaque.getI_Clon()); //ID
        holder.txprodbkem.setText(bkEmpaque.getJ_Producto_Plantado()); //ID
        holder.txcvempabkem.setText(bkEmpaque.getK_Cavidad_Trasplantada()); //ID
        holder.txqtybkem.setText(bkEmpaque.getL_Total_Planta_Plantada()); //ID
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class BKEmpaqueHolder extends RecyclerView.ViewHolder{
        TextView txidbkem, txusbkem, txfrbkem, txfbkem, txranbkem, txdestinobkem, txprodbkem, txcvempabkem,
                txvarbkem, txclonbkem, txqtybkem;

        public BKEmpaqueHolder(@NonNull View itemView) {
            super(itemView);

            txidbkem = itemView.findViewById(R.id.txidbkem);
            txusbkem = itemView.findViewById(R.id.txusbkem);
            txfrbkem = itemView.findViewById(R.id.txfrbkem);
            txfbkem = itemView.findViewById(R.id.txfbkem);
            txranbkem = itemView.findViewById(R.id.txranbkem);
            txdestinobkem = itemView.findViewById(R.id.txdestinobkem);
            txvarbkem = itemView.findViewById(R.id.txvarbkem);
            txclonbkem = itemView.findViewById(R.id.txclonbkem);
            txprodbkem = itemView.findViewById(R.id.txprodbkem);
            txcvempabkem = itemView.findViewById(R.id.txcvempabkem);
            txqtybkem = itemView.findViewById(R.id.txqtybkem);
        }
    }
}
