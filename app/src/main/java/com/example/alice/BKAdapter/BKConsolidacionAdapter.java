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

    public BKConsolidacionAdapter (List<BKConsolidacion> lista, int layout, Activity activity){
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
        //Se les pasa el parametro que se encuentra en firebase
        holder.txidbkco.setText(bkConsolidacion.getA_Id());
        holder.txusbkco.setText(bkConsolidacion.getC_Usuario());
        holder.txfrbkco.setText(bkConsolidacion.getD_Fecha_Registro());
        holder.txfbkco.setText(bkConsolidacion.getE_Fecha_Consolidacion());
        holder.txranbkco.setText(bkConsolidacion.getG_Rancho());
        holder.txproductobkco.setText(bkConsolidacion.getJ_Producto_Plantado());
        holder.txcalidadbkco.setText(bkConsolidacion.getM_Calidad_de_Planta());
        holder.txvarbkco.setText(bkConsolidacion.getH_Variedad_Seleccion());
        holder.txclonbkco.setText(bkConsolidacion.getI_Clon());
        holder.txcvtrasbkco.setText(bkConsolidacion.getL_Cavidad_Transplantada());
        holder.txqtybkco.setText(bkConsolidacion.getQ_Total_Planta_Plantada());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class BKConsolidacionHolder extends RecyclerView.ViewHolder{

        //se agregan los elementos del layout a esta clase
        TextView txidbkco, txusbkco, txfbkco, txfrbkco, txranbkco, txproductobkco, txcalidadbkco,
                txvarbkco, txclonbkco, txcvtrasbkco, txqtybkco;

        public BKConsolidacionHolder(@NonNull View itemView) {
            super(itemView);

            txidbkco = itemView.findViewById(R.id.txidbkco);
            txusbkco = itemView.findViewById(R.id.txusbkco);
            txfrbkco = itemView.findViewById(R.id.txfrbkco);
            txfbkco = itemView.findViewById(R.id.txfbkco);
            txranbkco = itemView.findViewById(R.id.txranbkco);
            txproductobkco = itemView.findViewById(R.id.txproductobkco);
            txcalidadbkco = itemView.findViewById(R.id.txcalidadbkco);
            txvarbkco = itemView.findViewById(R.id.txvarbkco);
            txclonbkco = itemView.findViewById(R.id.txclonbkco);
            txcvtrasbkco = itemView.findViewById(R.id.txcvtrasbkco);
            txqtybkco = itemView.findViewById(R.id.txqtybkco);
        }
    }
}
