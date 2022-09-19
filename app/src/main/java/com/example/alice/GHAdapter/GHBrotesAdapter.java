package com.example.alice.GHAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alice.GHModelo.GreenBrotes;
import com.example.alice.R;

import java.util.List;

public class GHBrotesAdapter extends RecyclerView.Adapter<GHBrotesAdapter.BrotesHolder> {
    List<GreenBrotes> lista;
    int layout;
    Activity activity;

    public GHBrotesAdapter(List<GreenBrotes> lista, int layout, Activity activity){
        this.lista = lista;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public BrotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return  new BrotesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrotesHolder holder, int position) {

        GreenBrotes greenBrotes = lista.get(position);

        holder.txidvb.setText(greenBrotes.getA_Id()); //ID
        holder.txusvb.setText(greenBrotes.getC_Usuario()); // usuario
        holder.txfpvb.setText(greenBrotes.getE_Fecha_Plantacion()); // Fecha Plantación
        holder.txproyectovb.setText(greenBrotes.getI_Proyecto()); // Proyecto
        holder.txvarvb.setText(greenBrotes.getK_P_Variedad_Seleccion()); // Variedad
        holder.txqtyvb.setText(greenBrotes.getY_Total_planta_plantada()); // Cantidad Plantada
        holder.txsecvb.setText(greenBrotes.getM_Sector()); // Setor
        holder.txtunelvb.setText(greenBrotes.getN_Tunel()); // Tunel
        holder.txladovb.setText(greenBrotes.getO_Lado()); // Lado
        holder.txcamavb.setText(greenBrotes.getP_Cama()); // Cama

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public class BrotesHolder extends RecyclerView.ViewHolder{

        TextView txidvb, txusvb, txfpvb, txproyectovb, txvarvb, txqtyvb, txsecvb, txtunelvb, txladovb, txcamavb;

        public BrotesHolder(@NonNull View itemView) {
            super(itemView);

            txidvb = itemView.findViewById(R.id.txidvb);
            txusvb  = itemView.findViewById(R.id.txusvb);
            txfpvb = itemView.findViewById(R.id.txfvb);
            txproyectovb = itemView.findViewById(R.id.txproyectovb);
            txvarvb = itemView.findViewById(R.id.txvarvb);
            txqtyvb = itemView.findViewById(R.id.txqtyvb);
            txsecvb = itemView.findViewById(R.id.txsecvb);
            txtunelvb = itemView.findViewById(R.id.txtunelvb);
            txladovb = itemView.findViewById(R.id.txladovb);
            txcamavb = itemView.findViewById(R.id.txcamavb);
        }
    }
}
