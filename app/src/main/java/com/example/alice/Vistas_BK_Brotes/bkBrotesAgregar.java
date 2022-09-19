package com.example.alice.Vistas_BK_Brotes;

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

import com.example.alice.BKModelo.BKBrotes;
import com.example.alice.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class bkBrotesAgregar extends Fragment {

    TextView txtusubkpb, txtfecharbkpb, txtsbkpb, txtzonbkpb, txtpuebkpb;
    EditText edfechpbkpb, edcambkpb, edposbkpb, edotvarbkpb, edclonbkpb, edtcharcombkpb,
            edtplachacombkpb, edtplansuelbkpb, edtotplanpbkpb, edloteorigenbkpb, ednotabkpb;

    TextInputLayout ti1bkpb, ti2bkpb, ti3bkpb, ti4bkpb, ti5bkpb, ti6bkpb, ti7bkpb, ti8bkpb, ti9bkpb,
            ti10bkpb, ti11bkpb, ti12bkpb, ti13bkpb, ti14bkpb, ti15bkpb, ti16bkpb;

    AutoCompleteTextView auranbkpb, auladbkpb, auvarbkpb, auproplabkpb, auncosechabkpb, aucavchabkpb;

    Button btncalclarbkpb, btnguadarbkpb;

    String aa1;
    boolean a1;

    public bkBrotesAgregar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bk_brotes_agregar, container, false);

        //Variable Fecha (d)
        Date d = new Date();

        txtusubkpb = view.findViewById(R.id.txtusubkpb);
        txtfecharbkpb = view.findViewById(R.id.txtfecharbkpb);
        txtsbkpb = view.findViewById(R.id.txtsbkpb);
        txtzonbkpb= view.findViewById(R.id.txtzonbkpb);
        txtpuebkpb = view.findViewById(R.id.txtpuebkpb);
        edfechpbkpb = view.findViewById(R.id.edfechpbkpb);
        auranbkpb = view.findViewById(R.id.auranbkpb);
        edcambkpb = view.findViewById(R.id.edcambkpb);
        edposbkpb = view.findViewById(R.id.edposbkpb);
        auladbkpb = view.findViewById(R.id.auladbkpb);
        auvarbkpb = view.findViewById(R.id.auvarbkpb);
        edotvarbkpb = view.findViewById(R.id.edotvarbkpb);
        edclonbkpb = view.findViewById(R.id.edclonbkpb);
        auproplabkpb = view.findViewById(R.id.auproplabkpb);
        auncosechabkpb = view.findViewById(R.id.auncosechabkpb);
        aucavchabkpb = view.findViewById(R.id.aucavchabkpb);
        edtcharcombkpb = view.findViewById(R.id.edtcharcombkpb);
        edtplachacombkpb = view.findViewById(R.id.edtplachacombkpb);
        edtplansuelbkpb = view.findViewById(R.id.edtplansuelbkpb);
        btncalclarbkpb = view.findViewById(R.id.btncalclarbkpb);
        edtotplanpbkpb = view.findViewById(R.id.edtotplanpbkpb);
        edloteorigenbkpb = view.findViewById(R.id.edloteorigenbkpb);
        ednotabkpb = view.findViewById(R.id.ednotabkpb);
        btnguadarbkpb = view.findViewById(R.id.btnguadarbkpb);

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
        txtfecharbkpb.setText(fechahora);
        //Se visualiza la semana
        txtsbkpb.setText(fechasem);
        //se visualiza la fecha
        edfechpbkpb.setText(fechaCom);

        //llenado de ranchos
        String [] items1 = { "", "Maravilla", "Granados", "El Moral"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter1 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items1);
        auranbkpb.setAdapter(itemAdapter1);

        //llenado de variedad
        String [] items2 = { "", "BT304.3", "BT311.4", "BV773.13", "BW150.1", "BZ1055.1", "BZ1070.1", "BZ1077.1", "Delaney",
                "Catherine", "Elvira", "Laurita", "Nigel", "Normita", "Paulina", "Rebeca", "Victoria", "Valeria"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter2 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items2);
        auvarbkpb.setAdapter(itemAdapter2);

        //llenado de producto
        String [] items3 = { "", "Tray Plants", "TC´s"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter3 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items3);
        auproplabkpb.setAdapter(itemAdapter3);

        //llenado de cavidad de la planta
        String [] items4 = { "", "1", "40", "45", "50", "54", "72", "77", "84", "128", "200", "280", "288"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter4 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items4);
        aucavchabkpb.setAdapter(itemAdapter4);

        //llenado de Numero de cosecha
        String [] items5 = { "", "A", "B", "C", "D", "E", "F", "G"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter5 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items5);
        auncosechabkpb.setAdapter(itemAdapter5);

        //llenado de Numero de cosecha
        String [] items6 = { "", "Norte", "Sur"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter6 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items6);
        auladbkpb.setAdapter(itemAdapter6);

        //agrega los datos del usuario
        recivirdatosabkpb();

        btncalclarbkpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculartotaltrozosbkpa();
            }
        });

        btnguadarbkpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //traemos la clase Brotes Blackberry para hacer el llenado en la bd
                BKBrotes bkBrotes = new BKBrotes();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Blackberry_2023").child("Plantacion Brotes");

                //se extrae el texto de los campos
                String catbkpa = "Plantación Brotes";

                String usubkpb = txtusubkpb.getText().toString();
                String fecharbkpb = txtfecharbkpb.getText().toString();
                String fechpbkpb = edfechpbkpb.getText().toString();
                String zonbkpbs = txtzonbkpb.getText().toString();
                String ranbkpb = auranbkpb.getText().toString();
                String cambkpb = edcambkpb.getText().toString();
                String posbkpb = edposbkpb.getText().toString();
                String ladbkpb = auladbkpb.getText().toString();
                String varbkpb = auvarbkpb.getText().toString();
                String otvarbkpb = edotvarbkpb.getText().toString();
                String clonbkpb = edclonbkpb.getText().toString();
                String proplabkpb = auproplabkpb.getText().toString();
                String ncosechabkpb = auncosechabkpb.getText().toString();
                String cavchabkpb = aucavchabkpb.getText().toString();
                String tcharcombkpb = edtcharcombkpb.getText().toString();
                String plachacombkpb = edtplachacombkpb.getText().toString();
                String plansuelbkpb = edtplansuelbkpb.getText().toString();
                String totplanpbkpb = edtotplanpbkpb.getText().toString();
                String loteorigenbkpb = edloteorigenbkpb.getText().toString();
                String notabkpb = ednotabkpb.getText().toString();

                if (edtotplanpbkpb.getText().toString().equals("")){
                    validacionesbkpb();
                    Toast.makeText(getActivity(),"Revisa, Datos Faltantes", Toast.LENGTH_LONG).show();
                }else {
                    if (edotvarbkpb.getText().toString().equals("")){
                        //si esta vacio otra variedad se agregara el spinner
                        bkBrotes.setB_Categoria(catbkpa);
                        bkBrotes.setC_Usuario(usubkpb);
                        bkBrotes.setD_Fecha_Registro(fecharbkpb);
                        bkBrotes.setE_Fecha_Plantacion(fechpbkpb);
                        bkBrotes.setF_Zona(zonbkpbs);
                        bkBrotes.setG_Rancho_Plantacion(ranbkpb);
                        bkBrotes.setH_Cama_Origen(cambkpb);
                        bkBrotes.setI_Posicion_Origen(posbkpb);
                        bkBrotes.setJ_Lado_Origen(ladbkpb);
                        bkBrotes.setK_Variedad_Seleccion(varbkpb);
                        bkBrotes.setL_Clon(clonbkpb);
                        bkBrotes.setM_Producto_Plantado(proplabkpb);
                        bkBrotes.setN_Numero_de_Cosecha(ncosechabkpb);
                        bkBrotes.setO_Cavidad_Plantada(cavchabkpb);
                        bkBrotes.setP_QTY_Charolas_Completas_Plantadas(tcharcombkpb);
                        bkBrotes.setQ_QTY_Planta_por_charola_Completa(plachacombkpb);
                        bkBrotes.setR_QTY_Planta_por_charola_Suelta(plansuelbkpb);
                        bkBrotes.setS_Total_Planta_Plantada(totplanpbkpb);
                        bkBrotes.setT_Codigo_Asignado(loteorigenbkpb);
                        bkBrotes.setU_Nota(notabkpb);
                        reference.push().setValue(bkBrotes);
                        Toast.makeText(getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        limpiarbkpb();
                    }
                    else {
                        //y si no se agregarar la otra variedad
                        bkBrotes.setB_Categoria(catbkpa);
                        bkBrotes.setC_Usuario(usubkpb);
                        bkBrotes.setD_Fecha_Registro(fecharbkpb);
                        bkBrotes.setE_Fecha_Plantacion(fechpbkpb);
                        bkBrotes.setF_Zona(zonbkpbs);
                        bkBrotes.setG_Rancho_Plantacion(ranbkpb);
                        bkBrotes.setH_Cama_Origen(cambkpb);
                        bkBrotes.setI_Posicion_Origen(posbkpb);
                        bkBrotes.setJ_Lado_Origen(ladbkpb);
                        bkBrotes.setK_Variedad_Seleccion(otvarbkpb);
                        bkBrotes.setL_Clon(clonbkpb);
                        bkBrotes.setM_Producto_Plantado(proplabkpb);
                        bkBrotes.setN_Numero_de_Cosecha(ncosechabkpb);
                        bkBrotes.setO_Cavidad_Plantada(cavchabkpb);
                        bkBrotes.setP_QTY_Charolas_Completas_Plantadas(tcharcombkpb);
                        bkBrotes.setQ_QTY_Planta_por_charola_Completa(plachacombkpb);
                        bkBrotes.setR_QTY_Planta_por_charola_Suelta(plansuelbkpb);
                        bkBrotes.setS_Total_Planta_Plantada(totplanpbkpb);
                        bkBrotes.setT_Codigo_Asignado(loteorigenbkpb);
                        bkBrotes.setU_Nota(notabkpb);
                        reference.push().setValue(bkBrotes);
                        Toast.makeText(getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        limpiarbkpb();
                    }
                }
            }
        });

        return view;

    }

    private void limpiarbkpb(){
        edtotplanpbkpb.setText("");
        edtcharcombkpb.setText("");
        edtplansuelbkpb.setText("");
        edcambkpb.setText("");
    }

    private void validacionesbkpb(){
        String v1 = edtotplanpbkpb.getText().toString();
        String v2 = edtcharcombkpb.getText().toString();
        String v3 = edtplansuelbkpb.getText().toString();
        String v4 = edcambkpb.getText().toString();

        if (v1.equals("") && v2.equals("") && v3.equals("") && v4.equals("")){
            edtotplanpbkpb.setError("Requerido");
            edtcharcombkpb.setError("Requerido");
            edtplansuelbkpb.setError("Requerido");
            edcambkpb.setError("Requerido");
        }

    }

    private void calculartotaltrozosbkpa(){
        String ns1 = aucavchabkpb.getText().toString();
        String ns2 = edtcharcombkpb.getText().toString();
        String ns3 = edtplansuelbkpb.getText().toString();

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

        edtplachacombkpb.setText(precision.format(v1));
        edtotplanpbkpb.setText(precision.format(v2));

    }

    private void recivirdatosabkpb() {
        Bundle extras = getActivity().getIntent().getExtras();
        String d1 = extras.getString("bk1");
        String d2 = extras.getString("bk2");
        String d3 = extras.getString("bk3");
        txtusubkpb.setText(d1);
        txtzonbkpb.setText(d2);
        txtpuebkpb.setText(d3);
    }
}