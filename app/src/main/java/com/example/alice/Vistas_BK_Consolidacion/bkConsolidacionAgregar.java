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
import android.widget.Toast;

import com.example.alice.BKModelo.BKConsolidacion;
import com.example.alice.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class bkConsolidacionAgregar extends Fragment {

    TextView txtusubkco, txtfecharbkco, txtsbkco, txtzonbkco, txtpuebkco;
    EditText edfechconbkco, edotvarbkco, edclonbkco, edtcharcombkco, edtplachacombkco, edtplansuelbkco, edtotplanconsolidadapbkco, ednotabkco;
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
        edfechconbkco = view.findViewById(R.id.edfechconbkco);
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
        edfechconbkco.setText(fechaCom);

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

        recivirdatosabkco();

        btncalcbkco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculartotaltrozosbkco();
            }
        });

        btnguadarbkco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BKConsolidacion bkConsolidacion = new BKConsolidacion();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Blackberry_2023").child("Consolidación");

                //se extrae el texto de los campos
                String catbkpa = "Consolidación";

                String usubkco = txtusubkco.getText().toString();
                String fecharbkco = txtfecharbkco.getText().toString();
                String fechpbkco = edfechconbkco.getText().toString();
                String zonbkpco = txtzonbkco.getText().toString();
                String ranbkco = auranbkco.getText().toString();
                String varbkco = auvarbkco.getText().toString();
                String otvarbkco = edotvarbkco.getText().toString();
                String clonbkco = edclonbkco.getText().toString();
                String proplabkco = auproplabkco.getText().toString();
                String cavchapbbkco = aucavchapbbkco.getText().toString();
                String cavchaptbkco = aucavchaptbkco.getText().toString();
                String calidadbkco = aucalidadbkco.getText().toString();
                String charcombkco = edtcharcombkco.getText().toString();
                String plachacombkco = edtplachacombkco.getText().toString();
                String plansuelbkco = edtplansuelbkco.getText().toString();
                String totplanconsolidadapbkco = edtotplanconsolidadapbkco.getText().toString();
                String notabkco = ednotabkco.getText().toString();


                if (edtotplanconsolidadapbkco.getText().toString().equals("")){
                    validacionesbkco();
                    Toast.makeText(getActivity(),"Revisa, Datos Faltantes", Toast.LENGTH_LONG).show();
                }else{
                    if (edotvarbkco.getText().toString().equals("")){
                        bkConsolidacion.setB_Categoria(catbkpa);
                        bkConsolidacion.setC_Usuario(usubkco);
                        bkConsolidacion.setD_Fecha_Registro(fecharbkco);
                        bkConsolidacion.setE_Fecha_Consolidacion(fechpbkco);
                        bkConsolidacion.setF_Zona(zonbkpco);
                        bkConsolidacion.setG_Rancho(ranbkco);
                        bkConsolidacion.setH_Variedad_Seleccion(varbkco);
                        bkConsolidacion.setI_Clon(clonbkco);
                        bkConsolidacion.setJ_Producto_Plantado(proplabkco);
                        bkConsolidacion.setK_Cavidad_Plantada(cavchapbbkco);
                        bkConsolidacion.setL_Cavidad_Transplantada(cavchaptbkco);
                        bkConsolidacion.setM_Calidad_de_Planta(calidadbkco);
                        bkConsolidacion.setN_QTY_Charolas_Completas_Plantadas(charcombkco);
                        bkConsolidacion.setO_QTY_Planta_por_charola_Completa(plachacombkco);
                        bkConsolidacion.setP_QTY_Planta_por_charola_Suelta(plansuelbkco);
                        bkConsolidacion.setQ_Total_Planta_Plantada(totplanconsolidadapbkco);
                        bkConsolidacion.setR_Nota(notabkco);
                        reference.push().setValue(bkConsolidacion);
                        Toast.makeText(getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        limpiarbkco();
                    }
                    else {
                        bkConsolidacion.setB_Categoria(catbkpa);
                        bkConsolidacion.setC_Usuario(usubkco);
                        bkConsolidacion.setD_Fecha_Registro(fecharbkco);
                        bkConsolidacion.setE_Fecha_Consolidacion(fechpbkco);
                        bkConsolidacion.setF_Zona(zonbkpco);
                        bkConsolidacion.setG_Rancho(ranbkco);
                        bkConsolidacion.setH_Variedad_Seleccion(otvarbkco);
                        bkConsolidacion.setI_Clon(clonbkco);
                        bkConsolidacion.setJ_Producto_Plantado(proplabkco);
                        bkConsolidacion.setK_Cavidad_Plantada(cavchapbbkco);
                        bkConsolidacion.setL_Cavidad_Transplantada(cavchaptbkco);
                        bkConsolidacion.setM_Calidad_de_Planta(calidadbkco);
                        bkConsolidacion.setN_QTY_Charolas_Completas_Plantadas(charcombkco);
                        bkConsolidacion.setO_QTY_Planta_por_charola_Completa(plachacombkco);
                        bkConsolidacion.setP_QTY_Planta_por_charola_Suelta(plansuelbkco);
                        bkConsolidacion.setQ_Total_Planta_Plantada(totplanconsolidadapbkco);
                        bkConsolidacion.setR_Nota(notabkco);
                        reference.push().setValue(bkConsolidacion);
                        Toast.makeText(getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        limpiarbkco();
                    }
                }
            }
        });

        return view;

    }

    private void validacionesbkco() {

        String v1 = edtcharcombkco.getText().toString();
        String v2 = edtplachacombkco.getText().toString();
        String v3 = edtotplanconsolidadapbkco.getText().toString();

        if (v1.equals("") && v2.equals("") && v3.equals("")){
            edtcharcombkco.setError("Requerido");
            edtplachacombkco.setError("Requerido");
            edtotplanconsolidadapbkco.setError("Requerido");
        }
    }

    private void limpiarbkco(){
        edtcharcombkco.setText("");
        edtplachacombkco.setText("");
        edtotplanconsolidadapbkco.setText("");
        edtplansuelbkco.setText("0");

    }

    private void calculartotaltrozosbkco(){
        String ns1 = aucavchaptbkco.getText().toString();
        String ns2 = edtcharcombkco.getText().toString();
        String ns3 = edtplansuelbkco.getText().toString();

        if (ns1.equals("") || ns2.equals("") || ns3.equals("")) {
            // Detener ejecución del método
            Toast.makeText(getActivity(),"Revisa datos", Toast.LENGTH_SHORT).show();
            return;
        }

        //Convertimos texto a numero pero usamos boleano para el punto decimal
        Double n1 = Double.parseDouble(ns1);// convertimos y pasamos el primer valor
        Double n2 = Double.parseDouble(ns2);// convertimos y pasamos el segundo valor
        Double n3 = Double.parseDouble(ns3);// convertimos y pasamos el segundo valor

        Double v1 = n1 * n2;// Planta por charola Completa
        Double v2 = (n1 * n2 + n3);//Total Planta Plantada

        DecimalFormat precision = new DecimalFormat("0.0");

        edtplachacombkco.setText(precision.format(v1));
        edtotplanconsolidadapbkco.setText(precision.format(v2));

    }

    private void recivirdatosabkco() {

        Bundle extras = getActivity().getIntent().getExtras();
        String d1 = extras.getString("bk1");
        String d2 = extras.getString("bk2");
        String d3 = extras.getString("bk3");
        txtusubkco.setText(d1);
        txtzonbkco.setText(d2);
        txtpuebkco.setText(d3);

    }
}