package com.example.alice.Vistas_BK_Consolidacion;

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

import com.example.alice.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;


public class bkConsolidacionAgregar extends Fragment {

    TextView txtusubkco, txtfecharbkco, txtsbkco, txtzonbkco, txtpuebkco;

    EditText edfechplabkco, edotvarbkco, edclonbkco, edtcharcombkco, edtplachacombkco, edtplansuelbkco, edtotplanconsolidadapbkco, ednotabkco;

    TextInputLayout ti1bkco, ti2bkco, ti3bkco, ti4bkco, ti5bkco, ti6bkco, ti7bkco, ti8bkco, ti9bkco, ti10bkco, ti11bkco, ti12bkco;

    AutoCompleteTextView auranbkco, auvarbkco, auproplabkco, aucavchapbbkco, aucavchaptbkco, aucalidadbkco;

    Button btncalcbkco, btnguadarbkco;

    String usu;

    boolean u1;


    public bkConsolidacionAgregar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bk_consolidacion_agregar, container, false);

        //Variable Fecha (d)
        Date d = new Date();

        txtusubkco = view.findViewById(R.id.txtusubkco);
        txtfecharbkco = view.findViewById(R.id.txtfecharbkco);
        txtsbkco = view.findViewById(R.id.txtsbkco);
        txtzonbkco = view.findViewById(R.id.txtzonbkco);
        txtpuebkco = view.findViewById(R.id.txtpuebkco);
        edfechplabkco = view.findViewById(R.id.edfechplabkco);
        auranbkco = view.findViewById(R.id.auranbkco);
        auvarbkco = view.findViewById(R.id.auvarbkco);
        edotvarbkco = view.findViewById(R.id.edotvarbkco);
        edclonbkco = view.findViewById(R.id.edclonbkco);
        auproplabkco = view.findViewById(R.id.auproplabkco);
        aucavchapbbkco = view.findViewById(R.id.aucavchapbbkco);
        aucavchaptbkco = view.findViewById(R.id.aucavchaptbkco);
        aucalidadbkco = view.findViewById(R.id.aucalidadbkco);
        edtcharcombkco = view.findViewById(R.id.edtcharcombkco);
        edtplachacombkco = view.findViewById(R.id.edtplachacombkco);
        edtplansuelbkco = view.findViewById(R.id.edtplansuelbkco);
        edtotplanconsolidadapbkco = view.findViewById(R.id.edtotplanconsolidadapbkco);
        btncalcbkco = view.findViewById(R.id.btncalcbkco);
        ednotabkco = view.findViewById(R.id.ednotabkco);
        btnguadarbkco = view.findViewById(R.id.btnguadarbkco);

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
        txtfecharbkco.setText(fechahora);
        //Se visualiza la semana
        txtsbkco.setText(fechasem);
        //se visualiza la fecha
        edfechplabkco.setText(fechaCom);

        //llenado de ranchos
        String [] items1 = { "", "Maravilla", "Granados", "El Moral"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter1 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items1);
        auranbkco.setAdapter(itemAdapter1);

        //llenado de variedad
        String [] items2 = { "", "BT304.3", "BT311.4", "BV773.13", "BW150.1", "BZ1055.1", "BZ1070.1", "BZ1077.1", "Delaney",
                "Catherine", "Elvira", "Laurita", "Nigel", "Normita", "Paulina", "Rebeca", "Victoria", "Valeria"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter2 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items2);
        auvarbkco.setAdapter(itemAdapter2);

        //llenado de producto
        String [] items3 = { "", "Tray Plants", "TC´s"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter3 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items3);
        auproplabkco.setAdapter(itemAdapter3);

        //llenado de calibre de la planta
        String [] items4 = { "", "A", "B", "C", "D", "E", "F"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter4 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items4);
        aucalidadbkco.setAdapter(itemAdapter4);

        //llenado de calibre de la planta
        String [] items5 = { "", "1", "40", "45", "50", "54", "72", "77", "84", "128", "200", "280", "288"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter5 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items5);
        aucavchapbbkco.setAdapter(itemAdapter5);
        aucavchaptbkco.setAdapter(itemAdapter5);




        return view;
    }
}