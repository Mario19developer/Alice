package com.example.alice.Vistas_BK_Mortandad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alice.BKModelo.BKMortandad;
import com.example.alice.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class bkMortandadAgregar extends Fragment {

    TextView txtusubkcm, txtfecharbkcm, txtsbkcm, txtzonbkcm, txtpuebkcm;
    EditText edfechplabkcm, edcambkcm, edposbkcm, edotravarbkcm, edclonbkcm, edtotplanpbkcm, ednotabkcm;
    TextInputLayout ti1bkcm, ti2bkcm, ti3bkcm, ti4bkcm, ti5bkcm, ti6bkcm, ti7bkcm, ti8bkcm, ti9bkcm, ti10bkcm, ti11bkcm, ti12bkcm, ti13bkcm, ti14bkcm;
    AutoCompleteTextView auetapaconbkcm, auladobkcm, auranbkcm, auvarbkcm, auproplabkcm, auncosechabkcm, aucavchabkcm;
    Button btnguadarbkcm;

    String aa1;
    boolean a1;

    public bkMortandadAgregar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bk_mortandad_agregar, container, false);

        //Variable Fecha (d)
        Date d = new Date();

        txtusubkcm = view.findViewById(R.id.txtusubkcm);
        txtfecharbkcm = view.findViewById(R.id.txtfecharbkcm);
        txtsbkcm = view.findViewById(R.id.txtsbkcm);
        txtzonbkcm = view.findViewById(R.id.txtzonbkcm);
        txtpuebkcm = view.findViewById(R.id.txtpuebkcm);
        auetapaconbkcm = view.findViewById(R.id.auetapaconbkcm);
        edfechplabkcm = view.findViewById(R.id.edfechplabkcm);
        auranbkcm = view.findViewById(R.id.auranbkcm);
        edcambkcm = view.findViewById(R.id.edcambkcm);
        edposbkcm = view.findViewById(R.id.edposbkcm);
        auladobkcm = view.findViewById(R.id.auladobkcm);
        auvarbkcm = view.findViewById(R.id.auvarbkcm);
        edotravarbkcm = view.findViewById(R.id.edotravarbkcm);
        edclonbkcm = view.findViewById(R.id.edclonbkcm);
        auproplabkcm = view.findViewById(R.id.auproplabkcm);
        auncosechabkcm = view.findViewById(R.id.auncosechabkcm);
        aucavchabkcm = view.findViewById(R.id.aucavchabkcm);
        edtotplanpbkcm = view.findViewById(R.id.edtotplanpbkcm);
        ednotabkcm = view.findViewById(R.id.ednotabkcm);
        btnguadarbkcm = view.findViewById(R.id.btnguadarbkcm);

        //Sacamos la fecha y la hora
        SimpleDateFormat fechah = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechahora = fechah.format(d);

        //Sacamos la fecha
        SimpleDateFormat semana = new SimpleDateFormat("ww");
        String fechasem = semana.format(d);

        //Sacamos la fecha
        SimpleDateFormat fecc = new SimpleDateFormat("dd/MM/yyyy");
        String fechaCom = fecc.format(d);

        //Se visualiza la fecha y hora
        txtfecharbkcm.setText(fechahora);
        //Se visualiza la semana
        txtsbkcm.setText(fechasem);
        //se visualiza la fecha
        edfechplabkcm.setText(fechaCom);

        //llenado de ranchos
        String [] items1 = { "", "Maravilla", "Granados", "El Moral"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter1 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items1);
        auranbkcm.setAdapter(itemAdapter1);

        //llenado de variedad
        String [] items2 = { "", "BT304.3", "BT311.4", "BV773.13", "BW150.1", "BZ1055.1", "BZ1070.1", "BZ1077.1", "Delaney",
                "Catherine", "Elvira", "Laurita", "Nigel", "Normita", "Paulina", "Rebeca", "Victoria", "Valeria"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter2 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items2);
        auvarbkcm.setAdapter(itemAdapter2);

        //llenado de producto
        String [] items3 = { "", "Tray Plants", "TC´s"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter3 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items3);
        auproplabkcm.setAdapter(itemAdapter3);

        //llenado de cavidad de la planta
        String [] items4 = { "", "1", "40", "45", "50", "54", "72", "77", "84", "128", "200", "280", "288"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter4 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items4);
        aucavchabkcm.setAdapter(itemAdapter4);

        //llenado de Numero de cosecha
        String [] items5 = { "", "A", "B", "C", "D", "E", "F", "G"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter5 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items5);
        auncosechabkcm.setAdapter(itemAdapter5);

        //llenado de Numero de cosecha
        String [] items6 = { "", "Despues de Plantación Brotes", "Despues de Trasplante", "", "", "", "", ""};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter6 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items6);
        auetapaconbkcm.setAdapter(itemAdapter6);

        //llenado de Numero de cosecha
        String [] items7 = { "", "Norte", "Sur"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter7 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items7);
        auladobkcm.setAdapter(itemAdapter7);

        //agrega los datos del usuario
        recivirdatosabkcm();

        btnguadarbkcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //traemos la clase Mortandad Blackberry para hacer el llenado en la bd
                BKMortandad bkMortandad = new BKMortandad();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Blackberry_2023").child("Conteos_Mortandad");

                //se extrae el texto de los campos
                String catbkcm = "Conteos Mortandad";
                String usubkcm = txtusubkcm.getText().toString();
                String fecharbkcm = txtfecharbkcm .getText().toString();
                String zonbkcm = txtzonbkcm.getText().toString();
                String fechplabkcm = edfechplabkcm.getText().toString();
                String etapaconbkcm = auetapaconbkcm.getText().toString();
                String ranbkcm = auranbkcm.getText().toString();
                String cambkcm = edcambkcm.getText().toString();
                String posbkcm = edposbkcm.getText().toString();
                String ladbkcm = auladobkcm.getText().toString();
                String varbkcm = auvarbkcm.getText().toString();
                String otravarbkcm = edotravarbkcm.getText().toString();
                String clonbkcm = edclonbkcm.getText().toString();
                String proplabkcm = auproplabkcm.getText().toString();
                String ncosechabkcm = auncosechabkcm.getText().toString();
                String cavchabkcm = aucavchabkcm.getText().toString();
                String totplanpbkcm = edtotplanpbkcm.getText().toString();
                String notabkcm = ednotabkcm.getText().toString();

                if (totplanpbkcm.equals("")){
                    validacionesbkcm();
                    Toast.makeText(getActivity(),"Revisa, Datos Faltantes", Toast.LENGTH_LONG).show();
                }
                else {
                    if (edotravarbkcm.getText().toString().equals("")){
                        bkMortandad.setB_Categoria(catbkcm);
                        bkMortandad.setC_Usuario(usubkcm);
                        bkMortandad.setD_Fecha_Registro(fecharbkcm);
                        bkMortandad.setE_Fecha_Muestreo(fechplabkcm);
                        bkMortandad.setF_Etapa_Conteo(etapaconbkcm);
                        bkMortandad.setG_Zona(zonbkcm);
                        bkMortandad.setH_Rancho_Plantacion(ranbkcm);
                        bkMortandad.setI_Cama(cambkcm);
                        bkMortandad.setJ_Posicion(posbkcm);
                        bkMortandad.setK_Lado(ladbkcm);
                        bkMortandad.setL_Variedad_Seleccion(varbkcm);
                        bkMortandad.setM_Clon(clonbkcm);
                        bkMortandad.setN_Producto_Plantado(proplabkcm);
                        bkMortandad.setO_Numero_de_Cosecha(ncosechabkcm);
                        bkMortandad.setP_Cavidad_Plantada(cavchabkcm);
                        bkMortandad.setQ_Cantidad_Planta_Muerta(totplanpbkcm);
                        bkMortandad.setR_Nota(notabkcm);
                        reference.push().setValue(bkMortandad);
                        Toast.makeText(getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        limpiarbkcm();

                    }else {

                        bkMortandad.setB_Categoria(catbkcm);
                        bkMortandad.setC_Usuario(usubkcm);
                        bkMortandad.setD_Fecha_Registro(fecharbkcm);
                        bkMortandad.setE_Fecha_Muestreo(fechplabkcm);
                        bkMortandad.setF_Etapa_Conteo(etapaconbkcm);
                        bkMortandad.setG_Zona(zonbkcm);
                        bkMortandad.setH_Rancho_Plantacion(ranbkcm);
                        bkMortandad.setI_Cama(cambkcm);
                        bkMortandad.setJ_Posicion(posbkcm);
                        bkMortandad.setK_Lado(ladbkcm);
                        bkMortandad.setL_Variedad_Seleccion(otravarbkcm);
                        bkMortandad.setM_Clon(clonbkcm);
                        bkMortandad.setN_Producto_Plantado(proplabkcm);
                        bkMortandad.setO_Numero_de_Cosecha(ncosechabkcm);
                        bkMortandad.setP_Cavidad_Plantada(cavchabkcm);
                        bkMortandad.setQ_Cantidad_Planta_Muerta(totplanpbkcm);
                        bkMortandad.setR_Nota(notabkcm);
                        reference.push().setValue(bkMortandad);
                        Toast.makeText(getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        limpiarbkcm();
                    }
                }
            }
        });

        return view;

    }

    private void validacionesbkcm() {
        String v1 = edcambkcm.getText().toString();
        String v2 = edtotplanpbkcm.getText().toString();

        if (v1.equals("") && v2.equals("") ){
            edcambkcm.setError("Requerido");
            edtotplanpbkcm.setError("Requerido");
        }
    }

    private void limpiarbkcm(){
        edcambkcm.setText("");
        edposbkcm.setText("");
        edclonbkcm.setText("");
        edtotplanpbkcm.setText("");
        auetapaconbkcm.setText("");
    }

    private void recivirdatosabkcm() {
        Bundle extras = getActivity().getIntent().getExtras();
        String d1 = extras.getString("bk1");
        String d2 = extras.getString("bk2");
        String d3 = extras.getString("bk3");
        txtusubkcm.setText(d1);
        txtzonbkcm.setText(d2);
        txtpuebkcm.setText(d3);
    }
}