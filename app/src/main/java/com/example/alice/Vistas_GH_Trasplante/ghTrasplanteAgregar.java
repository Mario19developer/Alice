package com.example.alice.Vistas_GH_Trasplante;

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

import com.example.alice.R;
import com.example.alice.GHModelo.GreenTrasplante;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ghTrasplanteAgregar extends Fragment {

    TextView txtusupit, txtfrpit, txtsempit, txtzonpit, txtpuespit;
    EditText edfppit, edcultivopit, edloteorpit, edotvarpit, edclonpit, edsecpit, edtunelpit, edproplanpit, edcamapit, edtotalpit, edccppit, edtpccpit, edpstpit, ednotapit;
    Spinner sprppit, spproyectopit, spvarpit, spladopit, spcaliplanpit, spncavpit;
    Button btncalcularpit, btnguardarpit;

    public ghTrasplanteAgregar() {
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
        View view =  inflater.inflate(R.layout.fragment_gh_trasplante_agregar, container, false);

        //Variable Fecha (d)
        Date d = new Date();

        //seteo
        txtusupit = view.findViewById(R.id.txtusupit);
        txtfrpit = view.findViewById(R.id.txtfrpit);
        txtsempit = view.findViewById(R.id.txtsempit);
        txtzonpit = view.findViewById(R.id.txtzonpit);
        txtpuespit = view.findViewById(R.id.txtpuespit);
        edfppit = view.findViewById(R.id.edfppit);
        sprppit = view.findViewById(R.id.sprppit);
        edcultivopit = view.findViewById(R.id.edcultivopit);
        spproyectopit = view.findViewById(R.id.spproyectopit);
        edloteorpit = view.findViewById(R.id.edloteorpit);
        spvarpit = view.findViewById(R.id.spvarpit);
        edotvarpit = view.findViewById(R.id.edotvarpit);
        edclonpit = view.findViewById(R.id.edclonpit);
        edsecpit = view.findViewById(R.id.edsecpit);
        edtunelpit = view.findViewById(R.id.edtunelpit);
        spladopit = view.findViewById(R.id.spladopit);
        edcamapit = view.findViewById(R.id.edcamapit);
        edproplanpit = view.findViewById(R.id.edproplanpit);
        spcaliplanpit = view.findViewById(R.id.spcaliplanpit);
        spncavpit = view.findViewById(R.id.spncavpit);
        edccppit = view.findViewById(R.id.edccppit);
        edtpccpit = view.findViewById(R.id.edtpccpit);
        edpstpit = view.findViewById(R.id.edpstpit);
        edtotalpit = view.findViewById(R.id.edtotalpit);
        btncalcularpit = view.findViewById(R.id.btncalcularpit);
        ednotapit = view.findViewById(R.id.ednotapit);
        btnguardarpit = view.findViewById(R.id.btnguardarpit);

        //Sacamos la fecha completa
        SimpleDateFormat fecc = new SimpleDateFormat("dd/MM/yyyy");
        String fechaComString = fecc.format(d);

        //Sacamos el año
        SimpleDateFormat feac = new SimpleDateFormat("yy");
        String fechaanString = feac.format(d);

        //Sacamos la semana completa
        SimpleDateFormat fesc = new SimpleDateFormat("ww");
        String fechasemString = fesc.format(d);

        // se muestra el texto en el layout
        txtfrpit.setText(fechaComString);
        edfppit.setText(fechaComString);
        txtsempit.setText(fechaanString+fechasemString);

        //se ocupara para generar el lote
        String semanagh = "GH"+fechaanString+fechasemString;
        String semanatn = "TI"+fechaanString+fechasemString;

        // se llena en spinner en el fragment
        sprppit.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,Ran)); // Rancho
        spproyectopit.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, Proy));// Proyecto
        spvarpit.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,Rasp)); //Variedad
        spladopit.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,Lado)); // Lado

        //agrega los datos del usuario
        recivirdatospit();

        btncalcularpit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ns1 = spncavpit.getSelectedItem().toString();// cavidades
                String ns2 = edccppit.getText().toString();//charolas completas
                String ns3 = edpstpit.getText().toString();//planta suelta

                if (ns1.equals("") || ns2.equals("") || ns3.equals("")) {
                    // Detener ejecución del método
                    Toast.makeText(ghTrasplanteAgregar.this.getContext(),"Revisa datos", Toast.LENGTH_SHORT).show();

                    return;
                }

                float n1 = Float.parseFloat(ns1);
                float n2 = Float.parseFloat(ns2);
                float n3 = Float.parseFloat(ns3);

                float v1 = n1 * n2;// Planta por charola Completa
                float v2 = (n1 * n2 + n3);//Total Planta Plantada

                String r1 = String.valueOf(v1);//
                String r2 = String.valueOf(v2);

                edtpccpit.setText(r1);
                edtotalpit.setText(r2);
            }
        });


        //Agregar lote de plantación
        //Agregar Lote de Transplante


        btnguardarpit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GreenTrasplante greenTrasplante = new GreenTrasplante();

                String catpit = "Trasplante";

                //id
                greenTrasplante.setB_Categoria(catpit); // b_Categoria
                greenTrasplante.setC_Usuario(txtusupit.getText().toString()); // c_Usuario
                greenTrasplante.setD_Fecha_Registro(txtfrpit.getText().toString()); // d_Fecha_Registro
                greenTrasplante.setE_Fecha_Trasplante(edfppit.getText().toString()); // e_Fecha_Trasplante
                greenTrasplante.setF_Rancho_Plantacion(sprppit.getSelectedItem().toString()); // f_Rancho_Plantacion
                greenTrasplante.setG_Cultivo(edcultivopit.getText().toString()); // g_Cultivo
                greenTrasplante.setH_Proyecto(spproyectopit.getSelectedItem().toString()); // h_Proyecto
                greenTrasplante.setI_Lote_Origen(edloteorpit.getText().toString()); // i_Lote_Origen
                greenTrasplante.setJ_Variedad_Seleccion(spvarpit.getSelectedItem().toString()); // j_Variedad_Seleccion
                greenTrasplante.setK_Sector(edsecpit.getText().toString()); // k_Sector
                greenTrasplante.setL_Tunel(edtunelpit.getText().toString()); // l_Tunel
                greenTrasplante.setM_Lado(spladopit.getSelectedItem().toString()); // m_Lado
                greenTrasplante.setN_Cama(edcamapit.getText().toString()); // n_Cama
                greenTrasplante.setO_Lote_Trasplantado(edproplanpit.getText().toString()); // o_Lote_Trasplantado revisar si sera el lote el que coloquen o cual es la información que estaran tomando
                greenTrasplante.setP_Calidad_Material(spcaliplanpit.getSelectedItem().toString()); // p_Calidad_material
                greenTrasplante.setQ_Cavidad_Trasplantada(spncavpit.getSelectedItem().toString()); // q_Cavidad_Plantada
                greenTrasplante.setR_Charolas_completas_plantadas(edccppit.getText().toString());// r_Charolas_completas_plantadas
                greenTrasplante.setS_Plantas_por_charola_completa(edtpccpit.getText().toString());// s_Plantas_por_charola_completa
                greenTrasplante.setT_Plantas_Sueltas(edpstpit.getText().toString()); // t_Plantas_Suelta
                greenTrasplante.setU_Total_planta_plantada(edtotalpit.getText().toString()); // u_Total_planta_plantada
                greenTrasplante.setV_Semana_Trasplante(fechasemString); // v_Semana_Trasplante
                greenTrasplante.setW_Semana_Entregae(fechasemString); // w_Semana_Entregae generar el calculo y condicional dependiendo de la calidad de planta //
                greenTrasplante.setX_Nota(ednotapit.getText().toString()); // x_Nota

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Green House 2023").child("Trasplante");

                Toast.makeText(ghTrasplanteAgregar.this.getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                reference.push().setValue(greenTrasplante);

            }
        });

        return view;
    }

    private void limpiardatospit() {
        edloteorpit.setText("");
        edsecpit.setText("");
        edtunelpit.setText("");
        edcamapit.setText("");
        edclonpit.setText(""); // Clon
        edotvarpit.setText(""); // Otra Variedad
        edccppit.setText(""); // 1
        edtpccpit.setText(""); // 2
        edpstpit.setText(""); // 3
        edtotalpit.setText(""); // 4
    }

    private void validacionespit() {
        String camapia = edcamapit.getText().toString();
        String cc = edccppit.getText().toString();
        String tpc = edtpccpit.getText().toString();
        String total = edtotalpit.getText().toString();

        if (camapia.equals("") || cc.equals("") || tpc.equals("") || total.equals("")) {
            edcamapit.setError("Requerido");
            edtpccpit.setError("Requerido");
            edtotalpit.setError("Requerido");

        }
    }

    private void recivirdatospit () {
        Bundle extras = getActivity().getIntent().getExtras();
        String d1 = extras.getString("da1");
        String d2 = extras.getString("da2");
        String d3 = extras.getString("da3");
        txtusupit.setText(d1);
        txtzonpit.setText(d2);
        txtpuespit.setText(d3);
    }
}