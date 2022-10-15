package com.example.alice.Vistas_BK_Trasplante;

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

import com.example.alice.BKModelo.BKTrasplante;
import com.example.alice.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class bkTrasplanteAgregar extends Fragment {

    TextView txtusubktr, txtfecharbktr, txtsbktr, txtzonbktr, txtpuebktr;
    EditText edfechtbktr, edcambktr, edposbktr, edotvarbktr, edclonbktr, edtcharcompbktr,
            edtplachacompbktr, edtplansuelpbktr, edtotplanpbktr, ednotabktr, edorigenalmacigobktr;
    TextInputLayout ti1bktr, ti2bktr, ti3bktr, ti4bktr, ti5bktr, ti6bktr, ti7bktr, ti8bktr, ti9bktr,
            ti10bktr, ti11bktr, ti12bktr, ti13bktr, ti14bktr, ti15bktr;
    AutoCompleteTextView auranbktr, auladbktr, auvarbktr, auproplabktr, auncosbktr, aucavchapbktr, aucavchatbktr ;
    Button btncalcbktr, btnguadarbktr;
    String aa1;
    boolean a1;

    public bkTrasplanteAgregar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bk_trasplante_agregar, container, false);

        //Variable Fecha (d)
        Date d = new Date();

        txtusubktr = view.findViewById(R.id.txtusubktr);
        txtfecharbktr = view.findViewById(R.id.txtfecharbktr);
        txtsbktr = view.findViewById(R.id.txtsbktr);
        txtzonbktr= view.findViewById(R.id.txtzonbktr);
        txtpuebktr = view.findViewById(R.id.txtpuebktr);
        edfechtbktr = view.findViewById(R.id.edfechtbktr);
        auranbktr = view.findViewById(R.id.auranbktr);
        edcambktr = view.findViewById(R.id.edcambktr);
        edposbktr = view.findViewById(R.id.edposbktr);
        auladbktr = view.findViewById(R.id.auladbktr);
        auvarbktr = view.findViewById(R.id.auvarbktr);
        edotvarbktr = view.findViewById(R.id.edotvarbktr);
        edclonbktr = view.findViewById(R.id.edclonbktr);
        auproplabktr = view.findViewById(R.id.auproplabktr);
        auncosbktr = view.findViewById(R.id.auncosbktr);
        aucavchapbktr = view.findViewById(R.id.aucavchapbktr);
        aucavchatbktr = view.findViewById(R.id.aucavchatbktr);
        edtcharcompbktr = view.findViewById(R.id.edtcharcompbktr);
        edtplachacompbktr = view.findViewById(R.id.edtplachacompbktr);
        edtplansuelpbktr = view.findViewById(R.id.edtplansuelpbktr);
        edtotplanpbktr = view.findViewById(R.id.edtotplanpbktr);
        btncalcbktr = view.findViewById(R.id.btncalcbktr);
        edorigenalmacigobktr = view.findViewById(R.id.edorigenalmacigobktr);
        ednotabktr = view.findViewById(R.id.ednotabktr);
        btnguadarbktr = view.findViewById(R.id.btnguadarbktr);

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
        txtfecharbktr.setText(fechahora);
        //Se visualiza la semana
        txtsbktr.setText(fechasem);
        //se visualiza la fecha
        edfechtbktr.setText(fechaCom);

        //llenado de ranchos
        String [] items1 = { "", "Maravilla", "Granados", "El Moral"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter1 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items1);
        auranbktr.setAdapter(itemAdapter1);

        //llenado de variedad
        String [] items2 = { "", "BT304.3", "BT311.4", "BV773.13", "BW150.1", "BZ1055.1", "BZ1070.1", "BZ1077.1", "Delaney",
                "Catherine", "Elvira", "Laurita", "Nigel", "Normita", "Paulina", "Rebeca", "Victoria", "Valeria"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter2 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items2);
        auvarbktr.setAdapter(itemAdapter2);

        //llenado de producto
        String [] items3 = { "", "Tray Plants", "TC´s"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter3 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items3);
        auproplabktr.setAdapter(itemAdapter3);

        //llenado de cavidad de la planta
        String [] items4 = { "", "1", "40", "45", "50", "54", "72", "77", "84", "128", "200", "280", "288"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter4 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items4);
        aucavchapbktr.setAdapter(itemAdapter4);
        aucavchatbktr.setAdapter(itemAdapter4);

        //llenado de Numero de cosecha
        String [] items5 = { "", "A", "B", "C", "D", "E", "F", "G"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter5 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items5);
        auncosbktr.setAdapter(itemAdapter5);

        //llenado de Numero de cosecha
        String [] items6 = { "", "Norte", "Sur"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter6 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items6);
        auladbktr.setAdapter(itemAdapter6);

        //agrega los datos del usuario
        recivirdatosabktr();

        btncalcbktr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculartotalbktr();
            }
        });

        btnguadarbktr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //traemos la clase Brotes Blackberry para hacer el llenado en la bd

                BKTrasplante bkTrasplante = new BKTrasplante();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Blackberry_2023").child("Trasplante");

                //se extrae el texto de los campos
                String catbktr = "Trasplante";
                String usubktr = txtusubktr.getText().toString();
                String fecharbktr = txtfecharbktr.getText().toString();
                String fechpbktr = edfechtbktr.getText().toString();
                String zonbkptr = txtzonbktr.getText().toString();
                String ranbktr = auranbktr.getText().toString();
                String cambktr = edcambktr.getText().toString();
                String posbktr = edposbktr.getText().toString();
                String ladbktr = auladbktr.getText().toString();
                String varbktr = auvarbktr.getText().toString();
                String otvarbktr = edotvarbktr.getText().toString();
                String clonbktr = edclonbktr.getText().toString();
                String proplabktr = auproplabktr.getText().toString();
                String ncosbktr = auncosbktr.getText().toString();
                String cavchapbktr = aucavchapbktr.getText().toString();
                String cavchatbktr = aucavchatbktr.getText().toString();
                String tcharcompbktr = edtcharcompbktr.getText().toString();
                String tplachacompbktr = edtplachacompbktr.getText().toString();
                String tplansuelpbktr = edtplansuelpbktr.getText().toString();
                String totplanpbktr = edtotplanpbktr.getText().toString();
                String origenalmacigobktr = edorigenalmacigobktr.getText().toString();
                String notabktr = ednotabktr.getText().toString();

                if (edtotplanpbktr.getText().toString().equals("")){
                    validacionesbktr();
                    Toast.makeText(getActivity(),"Revisa, Datos Faltantes", Toast.LENGTH_LONG).show();
                }else {
                    if (edotvarbktr.getText().toString().equals("")){
                        bkTrasplante.setB_Categoria(catbktr);
                        bkTrasplante.setC_Usuario(usubktr);
                        bkTrasplante.setD_Fecha_Registro(fecharbktr);
                        bkTrasplante.setE_Fecha_Trasplante(fechpbktr);
                        bkTrasplante.setF_Zona(zonbkptr);
                        bkTrasplante.setG_Rancho(ranbktr);
                        bkTrasplante.setH_Cama(cambktr);
                        bkTrasplante.setI_Posicion(posbktr);
                        bkTrasplante.setJ_Lado(ladbktr);
                        bkTrasplante.setK_Variedad_Seleccion(varbktr);
                        bkTrasplante.setL_Clon(clonbktr);
                        bkTrasplante.setM_Producto_Plantado(proplabktr);
                        bkTrasplante.setN_Numero_de_Cosecha(ncosbktr);
                        bkTrasplante.setO_Cavidad_Brotes(cavchapbktr);
                        bkTrasplante.setP_Cavidad_Trasplantada(cavchatbktr);
                        bkTrasplante.setQ_QTY_Charolas_Completas_Plantadas(tcharcompbktr);
                        bkTrasplante.setR_QTY_Planta_por_charola_Completa(tplachacompbktr);
                        bkTrasplante.setS_QTY_Planta_por_charola_Suelta(tplansuelpbktr);
                        bkTrasplante.setT_Total_Planta_Plantada(totplanpbktr);
                        bkTrasplante.setU_Codigo_Almacigo(origenalmacigobktr);
                        bkTrasplante.setV_Nota(notabktr);
                        reference.push().setValue(bkTrasplante);
                        Toast.makeText(getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        limpiarbktr();
                    }
                    else {
                        bkTrasplante.setB_Categoria(catbktr);
                        bkTrasplante.setC_Usuario(usubktr);
                        bkTrasplante.setD_Fecha_Registro(fecharbktr);
                        bkTrasplante.setE_Fecha_Trasplante(fechpbktr);
                        bkTrasplante.setF_Zona(zonbkptr);
                        bkTrasplante.setG_Rancho(ranbktr);
                        bkTrasplante.setH_Cama(cambktr);
                        bkTrasplante.setI_Posicion(posbktr);
                        bkTrasplante.setJ_Lado(ladbktr);
                        bkTrasplante.setK_Variedad_Seleccion(otvarbktr);
                        bkTrasplante.setL_Clon(clonbktr);
                        bkTrasplante.setM_Producto_Plantado(proplabktr);
                        bkTrasplante.setN_Numero_de_Cosecha(ncosbktr);
                        bkTrasplante.setO_Cavidad_Brotes(cavchapbktr);
                        bkTrasplante.setP_Cavidad_Trasplantada(cavchatbktr);
                        bkTrasplante.setQ_QTY_Charolas_Completas_Plantadas(tcharcompbktr);
                        bkTrasplante.setR_QTY_Planta_por_charola_Completa(tplachacompbktr);
                        bkTrasplante.setS_QTY_Planta_por_charola_Suelta(tplansuelpbktr);
                        bkTrasplante.setT_Total_Planta_Plantada(totplanpbktr);
                        bkTrasplante.setU_Codigo_Almacigo(origenalmacigobktr);
                        bkTrasplante.setV_Nota(notabktr);
                        reference.push().setValue(bkTrasplante);
                        Toast.makeText(getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        limpiarbktr();
                    }
                }
            }
        });

        return view;

    }

    private void validacionesbktr() {

        String v1 = edcambktr.getText().toString();
        String v2 = edtotplanpbktr.getText().toString();
        String v3 = auvarbktr.getText().toString();

        if (v1.equals("") && v2.equals("") && v3.equals("")){
            edcambktr.setError("Requerido");
            edtotplanpbktr.setError("Requerido");
            auvarbktr.setError("Requerido");
        }
    }

    private void limpiarbktr() {
        edcambktr.setText("");
        edposbktr.setText("");
        auladbktr.setText("");
        edtplansuelpbktr.setText("");
        edtotplanpbktr.setText("");

    }

    private void calculartotalbktr() {
        String ns1 = aucavchatbktr.getText().toString();
        String ns2 = edtcharcompbktr.getText().toString();
        String ns3 = edtplansuelpbktr.getText().toString();

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

        edtplachacompbktr.setText(precision.format(v1));
        edtotplanpbktr.setText(precision.format(v2));
    }

    private void recivirdatosabktr() {
        Bundle extras = getActivity().getIntent().getExtras();
        String d1 = extras.getString("bk1");
        String d2 = extras.getString("bk2");
        String d3 = extras.getString("bk3");
        txtusubktr.setText(d1);
        txtzonbktr.setText(d2);
        txtpuebktr.setText(d3);
    }
}