package com.example.alice.GHAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alice.GHModelo.GreenTrasplante;
import com.example.alice.R;

import java.util.List;

public class GHTrasplanteAdapter extends RecyclerView.Adapter<GHTrasplanteAdapter.TrasplanteHolder> {
    List<GreenTrasplante> lista;
    int layout;
    Activity activity;

    public GHTrasplanteAdapter(List<GreenTrasplante> lista, int layout, Activity activity){
        this.lista = lista;
        this.layout = layout;
        this.activity = activity;
    }

    @NonNull
    @Override
    public TrasplanteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new TrasplanteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GHTrasplanteAdapter.TrasplanteHolder holder, int position) {

        GreenTrasplante greenTrasplante = lista.get(position);

        holder.txtidt.setText(greenTrasplante.getA_Id());
        holder.txusut.setText(greenTrasplante.getC_Usuario());
        holder.txfpt.setText(greenTrasplante.getE_Fecha_Trasplante());
        holder.txproyectot.setText(greenTrasplante.getH_Proyecto());
        holder.txvart.setText(greenTrasplante.getJ_Variedad_Seleccion());
        holder.txqtyt.setText(greenTrasplante.getU_Total_planta_plantada());
        holder.txsect.setText(greenTrasplante.getK_Sector());
        holder.txtunelt.setText(greenTrasplante.getL_Tunel());
        holder.txladot.setText(greenTrasplante.getM_Lado());
        holder.txcamat.setText(greenTrasplante.getN_Cama());
        holder.txtloteorigent.setText(greenTrasplante.getI_Lote_Origen());
        holder.txtproductot.setText(greenTrasplante.getO_Lote_Trasplantado());
        holder.txcalidadt.setText(greenTrasplante.getP_Calidad_Material());
        //holder.txtsemanatt.setText(greenTrasplante.getP_Calidad_material());
        //holder.txsemanaentrega.setText(greenTrasplante.);

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class TrasplanteHolder extends RecyclerView.ViewHolder{
        TextView txtidt, txusut, txfpt, txproyectot, txvart, txqtyt, txsect, txtunelt, txladot, txcamat, txtloteorigent, txtproductot, txcalidadt, txtsemanatt, txsemanaentrega;


        public TrasplanteHolder(@NonNull View itemView) {
            super(itemView);

            //Seteo de datos
            txtidt = itemView.findViewById(R.id.txtidt);
            txusut = itemView.findViewById(R.id.txusut);
            txfpt = itemView.findViewById(R.id.txfpt);
            txproyectot = itemView.findViewById(R.id.txproyectot);
            txvart = itemView.findViewById(R.id.txvart);
            txqtyt = itemView.findViewById(R.id.txqtyt);
            txsect = itemView.findViewById(R.id.txsect);
            txtunelt = itemView.findViewById(R.id.txtunelt);
            txladot = itemView.findViewById(R.id.txladot);
            txcamat = itemView.findViewById(R.id.txcamat);
            txtloteorigent = itemView.findViewById(R.id.txtloteorigent);
            txtproductot = itemView.findViewById(R.id.txtproductot);
            txcalidadt = itemView.findViewById(R.id.txcalidadt);
            txtsemanatt = itemView.findViewById(R.id.txtsemanatt);
            txsemanaentrega = itemView.findViewById(R.id.txsemanaentrega);

        }
    }
}
