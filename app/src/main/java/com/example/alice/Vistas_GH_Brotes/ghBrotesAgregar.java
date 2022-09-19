package com.example.alice.Vistas_GH_Brotes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alice.GHModelo.GreenBrotes;
import com.example.alice.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ghBrotesAgregar extends Fragment {

    TextView txtusupib, txtfrpib, txtsempib, txtzonpib, txtpuespib;
    EditText edfppib, edcultivopib, edloteorpib, edotvarpib, edclonpib, edsecpib, edtunelpib, edcamapib, edccppib, edtpccpib, edpstpib, edtotalpib, edcmpib, edcodlotepib, ednotapib;
    Spinner sprppib, spordenclientepib, spproyectopib, spvarpib, spladopib, spproplanpib, spcaliplanpib, spncospib, spncavpib, spnvolchapib;
    Button btncalcularpib, btnguardarpib;

    public ghBrotesAgregar() {
        // Required empty public constructor
    }

    //listas de llenado Rancho
    String[] Ran = {"" +
            "Invernadero",
            "Tuneles Infinitas"
    };

    //listas de llenado tipo de planta
    String[] Proy = {
            "Tray Plants",
            "Dorman Long Cane",
            "Green Long Cane",
            "",
    };

    //listas de llenado Variedad
    String[] Rasp = {
            "",
            "Carmina",
            "Centella",
            "Esperanza",
            "Maravilla",
            "Marilyn",
            "Mya",
            "Pilar",
            "Reyna",
            "RM0513.2",
            "Yazmin"
    };

    //listas de llenado
    String[] Lado = {"" +
            "Norte",
            "Sur"
    };

    //listas de llenado
    String[] Prodplan = {"" +
            "Norte",
            "Sur"
    };

    //listas de llenado tipo de planta
    String[] CapMace = {
            "",
            "Cajas",
            "Cooler",
            "Cooler 10 lts ",
            "Cooler 7 lts",
            "Fresh",
            "Fresh 10 lts ",
            "Fresh 7 lts",
            "TP Verde"
    };

    //listas de llenado tipo de planta
    String[] Culti = {
            "Frambuesa",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gh_brotes_agregar, container, false);

        //Variable Fecha (d)
        Date d = new Date();

        txtusupib = view.findViewById(R.id.txtusupib);
        txtfrpib = view.findViewById(R.id.txtfrpib);
        txtsempib = view.findViewById(R.id.txtsempib);
        txtzonpib = view.findViewById(R.id.txtzonpib);
        txtpuespib = view.findViewById(R.id.txtpuespib);
        edfppib = view.findViewById(R.id.edfppib);
        sprppib = view.findViewById(R.id.sprppib);
        edcultivopib = view.findViewById(R.id.edcultivopib);
        edloteorpib = view.findViewById(R.id.edloteorpib);
        spvarpib = view.findViewById(R.id.spvarpib);
        edotvarpib = view.findViewById(R.id.edotvarpib);
        edclonpib = view.findViewById(R.id.edclonpib);
        edsecpib = view.findViewById(R.id.edsecpib);
        edtunelpib = view.findViewById(R.id.edtunelpib);
        spordenclientepib = view.findViewById(R.id.spordenclientepib);
        spproyectopib = view.findViewById(R.id.spproyectopib);
        spladopib = view.findViewById(R.id.spladopib);
        edcamapib = view.findViewById(R.id.edcamapib);
        spproplanpib = view.findViewById(R.id.spproplanpib);
        spcaliplanpib = view.findViewById(R.id.spcaliplanpib);
        spncospib = view.findViewById(R.id.spncospib);
        spncavpib = view.findViewById(R.id.spncavpib);
        spnvolchapib = view.findViewById(R.id.spnvolchapib);
        edccppib = view.findViewById(R.id.edccppib);
        edtpccpib = view.findViewById(R.id.edtpccpib);
        edpstpib = view.findViewById(R.id.edpstpib);
        btncalcularpib = view.findViewById(R.id.btncalcularpib);
        edtotalpib = view.findViewById(R.id.edtotalpib);
        edcmpib = view.findViewById(R.id.edcmpib);
        edcodlotepib = view.findViewById(R.id.edcodlotepib);
        ednotapib = view.findViewById(R.id.ednotapib);
        btncalcularpib = view.findViewById(R.id.btncalcularpib);
        btnguardarpib = view.findViewById(R.id.btnguardarpib);


        //Sacamos la fecha completa
        SimpleDateFormat fecc = new SimpleDateFormat("dd/MM/yyyy");
        String fechaComString = fecc.format(d);

        //Sacamos el año
        SimpleDateFormat feac = new SimpleDateFormat("yy");
        String fechaanString = feac.format(d);

        //Sacamos la semana completa
        SimpleDateFormat fesc = new SimpleDateFormat("ww");
        String fechasemString = fesc.format(d);

        txtfrpib.setText(fechaComString);
        edfppib.setText(fechaComString);
        txtsempib.setText(fechaanString+fechasemString);

        //se ocupara para generar el lote
        String semanagh = "GH"+fechaanString+fechasemString;
        String semanatn = "TI"+fechaanString+fechasemString;

        // se llena en spinner en el fragment
        sprppib.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,Ran)); // Rancho
        spproyectopib.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, Proy));// Proyecto
        spvarpib.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,Rasp)); //Variedad
        spladopib.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,Lado)); // Lado


        //agrega los datos del usuario
        recivirdatospib();

        btncalcularpib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ns1 = spncavpib.getSelectedItem().toString();// cavidades
                String ns2 = edccppib.getText().toString();//charolas completas
                String ns3 = edpstpib.getText().toString();//planta suelta

                if (ns1.equals("") || ns2.equals("") || ns3.equals("")) {
                    // Detener ejecución del método
                    Toast.makeText(ghBrotesAgregar.this.getContext(),"Revisa datos", Toast.LENGTH_SHORT).show();

                    return;
                }

                float n1 = Float.parseFloat(ns1);
                float n2 = Float.parseFloat(ns2);
                float n3 = Float.parseFloat(ns3);

                float v1 = n1 * n2;// Planta por charola Completa
                float v2 = (n1 * n2 + n3);//Total Planta Plantada

                String r1 = String.valueOf(v1);//
                String r2 = String.valueOf(v2);

                edtpccpib.setText(r1);
                edtotalpib.setText(r2);
            }
        });

        edcodlotepib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //genera codigo almacigo
                edcodlotepib.setText("");
                String vranpia = sprppib.getSelectedItem().toString();
                String vcamapia = edcamapib.getText().toString();
                String vvariedadpia = spvarpib.getSelectedItem().toString();
                String votvar = edotvarpib.getText().toString();
                String vclonpia = edclonpib.getText().toString();


                // si es diferente a tuneles Ubicacion, año, semana, cultivo, variedad, cama. (infinitas GH2134-RASP-MRYN-1)
                if (sprppib.getSelectedItem() != "Tuneles Infinitas")
                {
                    if (spvarpib.getSelectedItem() != "")
                    {
                        edcodlotepib.setText(semanagh +"-" + vvariedadpia  + "-" + vclonpia + "-" + vcamapia);
                    }
                    else {
                        edcodlotepib.setText(semanagh +"-" + votvar + "-" + vclonpia + "-" + vcamapia);
                    }
                }
                else//si es diferente a invernadero Ubicacion, año, semana, cultivo, variedad, cama. (TI2134-RASP-MRYN-1)
                {
                    if (spvarpib.getSelectedItem() != "")
                    {
                        edcodlotepib.setText(semanatn +"-" + vvariedadpia + "-" + vclonpia + "-" + vcamapia);
                    }
                    else {
                        edcodlotepib.setText(semanatn +"-" + votvar + "-" + vclonpia + "-" + vcamapia);
                    }
                }
            }
        });

        btnguardarpib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GreenBrotes greenBrotes = new GreenBrotes();
                String Catpib = "Plantación Brotes";

                //genera codigo almacigo
                edcodlotepib.setText("");
                String vranpia = sprppib.getSelectedItem().toString();
                String vcamapia = edcamapib.getText().toString();
                String vvariedadpia = spvarpib.getSelectedItem().toString();
                String votvar = edotvarpib.getText().toString();
                String vclonpia = edclonpib.getText().toString();

                // si es diferente a tuneles Ubicacion, año, semana, cultivo, variedad, cama. (infinitas GH2134-RASP-MRYN-1)
                if (sprppib.getSelectedItem() != "Tuneles Infinitas")
                {
                    if (spvarpib.getSelectedItem() != "")
                    {
                        edcodlotepib.setText(semanagh +"-" + vvariedadpia  + "-" + vclonpia + "-" + vcamapia);
                    }
                    else {
                        edcodlotepib.setText(semanagh +"-" + votvar + "-" + vclonpia + "-" + vcamapia);
                    }
                }
                else//si es diferente a invernadero Ubicacion, año, semana, cultivo, variedad, cama. (TI2134-RASP-MRYN-1)
                {
                    if (spvarpib.getSelectedItem() != "")
                    {
                        edcodlotepib.setText(semanatn +"-" + vvariedadpia + "-" + vclonpia + "-" + vcamapia);
                    }
                    else {
                        edcodlotepib.setText(semanatn +"-" + votvar + "-" + vclonpia + "-" + vcamapia);
                    }
                }

                String totalpib = edtotalpib.getText().toString(); //y

                if (totalpib.equals("")){
                    validacionespib();
                    Toast.makeText(ghBrotesAgregar.this.getActivity(),"Revisa, Datos Faltantes", Toast.LENGTH_LONG).show();
                }
                else {
                    //validacion de spinner para activar en editext otra Variedad
                    if (spvarpib.getSelectedItem() != "") {
                        //Codigo
                        //A_ID
                        greenBrotes.setB_Categoria(Catpib);
                        greenBrotes.setC_Usuario(txtusupib.getText().toString());
                        greenBrotes.setD_Fecha_Registro(txtfrpib.getText().toString());
                        greenBrotes.setE_Fecha_Plantacion(edfppib.getText().toString());
                        greenBrotes.setF_Rancho_Plantacion(sprppib.getSelectedItem().toString());
                        greenBrotes.setG_Cultivo(edcultivopib.getText().toString());
                        greenBrotes.setH_Orden_Cliente(spordenclientepib.getSelectedItem().toString());
                        greenBrotes.setI_Proyecto(spproyectopib.getSelectedItem().toString());
                        greenBrotes.setJ_Lote_Origen(edloteorpib.getText().toString());
                        greenBrotes.setK_P_Variedad_Seleccion(spvarpib.getSelectedItem().toString());
                        greenBrotes.setL_Q_Clon(edclonpib.getText().toString());
                        greenBrotes.setM_Sector(edsecpib.getText().toString());
                        greenBrotes.setN_Tunel(edtunelpib.getText().toString());
                        greenBrotes.setO_Lado(spladopib.getSelectedItem().toString());
                        greenBrotes.setP_Cama(edcamapib.getText().toString());
                        greenBrotes.setQ_Producto_Plantado(spproplanpib.getSelectedItem().toString());
                        greenBrotes.setR_Calidad_material(spcaliplanpib.getSelectedItem().toString());
                        greenBrotes.setS_Numero_Cosecha(spncospib.getSelectedItem().toString());
                        greenBrotes.setT_Cavidad_Plantada(spncavpib.getSelectedItem().toString());
                        greenBrotes.setV_Charolas_completas_plantadas(edccppib.getText().toString());
                        greenBrotes.setW_Plantas_por_charola_completa(edtpccpib.getText().toString());
                        greenBrotes.setX_Plantas_por_charola_incompletas(edpstpib.getText().toString());
                        greenBrotes.setY_Total_planta_plantada(edtotalpib.getText().toString());
                        greenBrotes.setZ_Qty_Planta_mal_plantada(edcmpib.getText().toString());
                        greenBrotes.setZA_Lote_brotes(edcodlotepib.getText().toString());
                        greenBrotes.setZB_Nota(ednotapib.getText().toString());

                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference reference = database.getReference("Green House 2022").child("Plantación Brotes");

                        Toast.makeText(ghBrotesAgregar.this.getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        reference.push().setValue(greenBrotes);

                        limpiardatospib();
                    }
                    else {
                        //Codigo
                        //A_ID
                        greenBrotes.setB_Categoria(Catpib);
                        greenBrotes.setC_Usuario(txtusupib.getText().toString());
                        greenBrotes.setD_Fecha_Registro(txtfrpib.getText().toString());
                        greenBrotes.setE_Fecha_Plantacion(edfppib.getText().toString());
                        greenBrotes.setF_Rancho_Plantacion(sprppib.getSelectedItem().toString());
                        greenBrotes.setG_Cultivo(edcultivopib.getText().toString());
                        greenBrotes.setH_Orden_Cliente(spordenclientepib.getSelectedItem().toString());
                        greenBrotes.setI_Proyecto(spproyectopib.getSelectedItem().toString());
                        greenBrotes.setJ_Lote_Origen(edloteorpib.getText().toString());
                        greenBrotes.setK_P_Variedad_Seleccion(edotvarpib.getText().toString());
                        greenBrotes.setL_Q_Clon(edclonpib.getText().toString());
                        greenBrotes.setM_Sector(edsecpib.getText().toString());
                        greenBrotes.setN_Tunel(edtunelpib.getText().toString());
                        greenBrotes.setO_Lado(spladopib.getSelectedItem().toString());
                        greenBrotes.setP_Cama(edcamapib.getText().toString());
                        greenBrotes.setQ_Producto_Plantado(spproplanpib.getSelectedItem().toString());
                        greenBrotes.setR_Calidad_material(spcaliplanpib.getSelectedItem().toString());
                        greenBrotes.setS_Numero_Cosecha(spncospib.getSelectedItem().toString());
                        greenBrotes.setT_Cavidad_Plantada(spncavpib.getSelectedItem().toString());
                        greenBrotes.setV_Charolas_completas_plantadas(edccppib.getText().toString());
                        greenBrotes.setW_Plantas_por_charola_completa(edtpccpib.getText().toString());
                        greenBrotes.setX_Plantas_por_charola_incompletas(edpstpib.getText().toString());
                        greenBrotes.setY_Total_planta_plantada(edtotalpib.getText().toString());
                        greenBrotes.setZ_Qty_Planta_mal_plantada(edcmpib.getText().toString());
                        greenBrotes.setZA_Lote_brotes(edcodlotepib.getText().toString());
                        greenBrotes.setZB_Nota(ednotapib.getText().toString());

                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference reference = database.getReference("Green House 2022").child("Plantación Brotes");

                        Toast.makeText(ghBrotesAgregar.this.getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        reference.push().setValue(greenBrotes);

                        limpiardatospib();
                    }
                }
            }
        });

        return view;
    }

    private void limpiardatospib() {
        edloteorpib.setText("");
        edsecpib.setText("");
        edtunelpib.setText("");
        edcamapib.setText("");
        edclonpib.setText("");
        edotvarpib.setText("");
        edccppib.setText("");
        edtpccpib.setText("");
        edpstpib.setText("");
        edtotalpib.setText("");
    }

    private void validacionespib() {
        String camapia = edcamapib.getText().toString();
        String cc = edccppib.getText().toString();
        String tpc = edtpccpib.getText().toString();
        String total = edtotalpib.getText().toString();

        if (camapia.equals("")||cc.equals("")||tpc.equals("")||total.equals("")){
            edcamapib.setError("Requerido");
            edtpccpib.setError("Requerido");
            edtotalpib.setError("Requerido");

        }
    }

    private void recivirdatospib() {
        Bundle extras = getActivity().getIntent().getExtras();
        String d1 = extras.getString("da1");
        String d2 = extras.getString("da2");
        String d3 = extras.getString("da3");
        txtusupib.setText(d1);
        txtzonpib.setText(d2);
        txtpuespib.setText(d3);
    }
}