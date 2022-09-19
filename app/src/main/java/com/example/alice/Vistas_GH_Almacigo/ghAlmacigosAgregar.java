package com.example.alice.Vistas_GH_Almacigo;

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

import com.example.alice.GHModelo.GreenAlmacigos;
import com.example.alice.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ghAlmacigosAgregar extends Fragment {

    //se agregan los elementos del layout a esta clase
    TextView txtusupia,txtfrpia, txtsempia, txtzonpia, txtpuespia;
    EditText edfppia,  edcodoripia, edsecpia, edtunelpia, edcamapia, edanchcampia, edlargcampia, edotvarpia, edclonpia, edqtyplanpia, edlotepia, ednotapia;
    Spinner sprppia, spcultivopia, spladopia,spvarpia, spmatestpia, sppresmatpia, spcapmacepia, spproyectopia;
    Button btnguardarpia;

    //listas de llenado Rancho
    String[] Ran = {"" +
            "Invernadero",
            "Tuneles Infinitas"
    };

    //listas de llenado Lado
    String[] Lado = {"" +
            "Norte",
            "Sur"
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

    //listas de llenado tipo maceta
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
    String[] Proy = {
            "Tray Plants",
            "Dorman Long Cane",
            "Green Long Cane",
            "",
    };

    //listas de llenado cultivo
    String[] Culti = {
            "Frambuesa",
    };

    public ghAlmacigosAgregar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gh_almacigos_agregar, container, false);

        //Variable Fecha (d)
        Date d = new Date();

        //seteo de layout
        txtusupia = view.findViewById(R.id.txtusupia);
        txtfrpia = view.findViewById(R.id.txtfrpia);
        txtsempia = view.findViewById(R.id.txtsempia);
        txtzonpia = view.findViewById(R.id.txtzonpia);
        txtpuespia = view.findViewById(R.id.txtpuespia);
        edfppia = view.findViewById(R.id.edfppia);
        sprppia = view.findViewById(R.id.sprppia);
        spcultivopia = view.findViewById(R.id.spcultivopia);
        edcodoripia = view.findViewById(R.id.edcodoripia);
        edsecpia = view.findViewById(R.id.edsecpia);
        edtunelpia = view.findViewById(R.id.edtunelpia);
        spladopia = view.findViewById(R.id.spladopia);
        edcamapia = view.findViewById(R.id.edcamapia);
        edanchcampia = view.findViewById(R.id.edanchcampia);
        edlargcampia = view.findViewById(R.id.edlargcampia);
        spvarpia = view.findViewById(R.id.spvarpia);
        edotvarpia = view.findViewById(R.id.edotvarpia);
        edclonpia = view.findViewById(R.id.edclonpia);
        spmatestpia = view.findViewById(R.id.spmatestpia);
        sppresmatpia = view.findViewById(R.id.sppresmatpia);
        spcapmacepia = view.findViewById(R.id.spcapmacepia);
        edqtyplanpia = view.findViewById(R.id.edqtyplanpia);
        edlotepia = view.findViewById(R.id.edlotepia);
        spproyectopia = view.findViewById(R.id.spproyectopia);
        ednotapia = view.findViewById(R.id.ednotapia);
        btnguardarpia = view.findViewById(R.id.btnguardarpia);

        //Sacamos la fecha completa
        SimpleDateFormat fecc = new SimpleDateFormat("dd/MM/yyyy");
        String fechaComString = fecc.format(d);

        //Sacamos la semana completa
        SimpleDateFormat feac = new SimpleDateFormat("yy");
        String fechaanString = feac.format(d);

        //Sacamos la semana completa
        SimpleDateFormat fesc = new SimpleDateFormat("ww");
        String fechasemString = fesc.format(d);

        //se agrega la fecha, año, semana
        txtfrpia.setText(fechaComString);
        edfppia.setText(fechaComString);
        txtsempia.setText("Y"+fechaanString+"W"+fechasemString);

        //se ocupara para generar el lote
        String semanagh = "GH"+fechaanString+fechasemString;
        String semanatn = "TI"+fechaanString+fechasemString;

        // se llena en spinner en el fragment
        sprppia.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,Ran)); // Rancho
        spvarpia.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,Rasp)); //Variedad
        spproyectopia.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,Proy)); // proyecto
        spcapmacepia.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,CapMace)); //tipo planta
        spcultivopia.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,Culti)); // Sector
        spladopia.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,Lado)); //Lado

        //agrega los datos del usuario
        recivirdatosarp();

        //se crea el codigo de lote
        edlotepia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //genera codigo almacigo
                edlotepia.setText("");
                String vranpia = sprppia.getSelectedItem().toString();
                String vcamapia = edcamapia.getText().toString();
                String vvariedadpia = spvarpia.getSelectedItem().toString();
                String votvar = edotvarpia.getText().toString();
                String vclonpia = edclonpia.getText().toString();

                // si es diferente a tuneles infinitas GH2134-RASP-MRYN-1 todavia no podemos gererar el codigo de la variedad probable matriz
                if (sprppia.getSelectedItem() != "Tuneles Infinitas")
                {
                    if (spvarpia.getSelectedItem() != "")
                    {
                        edlotepia.setText( semanagh+"-" + vvariedadpia);
                    }
                    else {
                        edlotepia.setText(semanagh +"-" + votvar);
                    }
                }
                else                    {
                    if (spvarpia.getSelectedItem() != "")
                    {
                        edlotepia.setText(semanatn +"-" + vvariedadpia);
                    }
                    else {
                        edlotepia.setText(semanatn +"-" + votvar);
                    }
                }
            }
        });

        btnguardarpia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //se estancia la base de firebasa
                GreenAlmacigos greenAlmacigos = new GreenAlmacigos();
                String Cat = "Plantación Almacigos"; // se agrega como parametro
                String Zon = "Libres"; // se agrega la zona

                //genera codigo almacigo
                edlotepia.setText("");
                String vvariedadpia = spvarpia.getSelectedItem().toString();
                String votvar = edotvarpia.getText().toString();
                String qtyplanpia = edqtyplanpia.getText().toString();

                //se genera el codigo lote si el usuario no lo creo
                // si es diferente a tuneles infinitas GH2134-RASP-MRYN-1 todavia no podemos gererar el codigo de la variedad probable matriz
                if (sprppia.getSelectedItem() != "Tuneles Infinitas")
                {
                    if (spvarpia.getSelectedItem() != "")
                    {
                        edlotepia.setText( semanagh+"-" + vvariedadpia);
                    }
                    else {
                        edlotepia.setText(semanagh +"-" + votvar);
                    }
                }
                else                    {
                    if (spvarpia.getSelectedItem() != "")
                    {
                        edlotepia.setText(semanatn +"-" + vvariedadpia);
                    }
                    else {
                        edlotepia.setText(semanatn +"-" + votvar);
                    }
                }

                //se valida campos vacios
                if (qtyplanpia.equals("")){
                    validacionespia();
                    Toast.makeText(ghAlmacigosAgregar.this.getActivity(),"Revisa, Faltan datos", Toast.LENGTH_LONG).show();
                }
                else {
                    //validacion de spinner para activar en editext otra Variedad
                    if (spvarpia.getSelectedItem() != ""){
                        //se pasan parametros a la base de datos.
                        greenAlmacigos.setB_Categoria(Cat);
                        greenAlmacigos.setC_Usuario(txtusupia.getText().toString());
                        greenAlmacigos.setD_Fecha_Registro(txtfrpia.getText().toString());
                        greenAlmacigos.setE_Fecha_Plantacion(edfppia.getText().toString());
                        greenAlmacigos.setF_Zona(Zon);
                        greenAlmacigos.setG_Rancho_Plantacion(sprppia.getSelectedItem().toString());
                        greenAlmacigos.setH_Cultivo(spcultivopia.getSelectedItem().toString());
                        greenAlmacigos.setI_Codigo_de_Origen(edcodoripia.getText().toString());
                        greenAlmacigos.setJ_Sector(edsecpia.getText().toString());
                        greenAlmacigos.setK_Tunel(edtunelpia.getText().toString());
                        greenAlmacigos.setL_Lado(spladopia.getSelectedItem().toString());
                        greenAlmacigos.setM_Cama(edcamapia.getText().toString());
                        greenAlmacigos.setN_Ancho_Cama(edanchcampia.getText().toString());
                        greenAlmacigos.setO_Largo_Cama(edlargcampia.getText().toString());
                        greenAlmacigos.setP_Variedad_Seleccion(spvarpia.getSelectedItem().toString());
                        greenAlmacigos.setQ_Clon(edclonpia.getText().toString());
                        greenAlmacigos.setR_Material_Establecido(spmatestpia.getSelectedItem().toString());
                        greenAlmacigos.setS_Presentacion_Material(sppresmatpia.getSelectedItem().toString());
                        greenAlmacigos.setT_Capacidad_de_Maceta(spcapmacepia.getSelectedItem().toString());
                        greenAlmacigos.setU_Catidad_Plantada(edqtyplanpia.getText().toString());
                        greenAlmacigos.setV_Lote_Asignado(edlotepia.getText().toString());
                        greenAlmacigos.setW_Nota_Plantacion(ednotapia.getText().toString());
                        greenAlmacigos.setX_Proyecto(spproyectopia.getSelectedItem().toString());
                        //se instancia la base de datos
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        //si lo anterior es correcto se mandan los datos a la base de datos
                        DatabaseReference reference = database.getReference("Green House 2022").child("Plantación Almacigos");
                        //se manda mensaje
                        Toast.makeText(ghAlmacigosAgregar.this.getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        //se mandan los valores a los getter an setter
                        reference.push().setValue(greenAlmacigos);
                        //se limipan los campos
                        limpiardatospia();
                    }
                    else {

                        //se pasan parametros a la base de datos.
                        greenAlmacigos.setB_Categoria(Cat);
                        greenAlmacigos.setC_Usuario(txtusupia.getText().toString());
                        greenAlmacigos.setD_Fecha_Registro(txtfrpia.getText().toString());
                        greenAlmacigos.setE_Fecha_Plantacion(edfppia.getText().toString());
                        greenAlmacigos.setF_Zona(Zon);
                        greenAlmacigos.setG_Rancho_Plantacion(sprppia.getSelectedItem().toString());
                        greenAlmacigos.setH_Cultivo(spcultivopia.getSelectedItem().toString());
                        greenAlmacigos.setI_Codigo_de_Origen(edcodoripia.getText().toString());
                        greenAlmacigos.setJ_Sector(edsecpia.getText().toString());
                        greenAlmacigos.setK_Tunel(edtunelpia.getText().toString());
                        greenAlmacigos.setL_Lado(spladopia.getSelectedItem().toString());
                        greenAlmacigos.setM_Cama(edcamapia.getText().toString());
                        greenAlmacigos.setN_Ancho_Cama(edanchcampia.getText().toString());
                        greenAlmacigos.setO_Largo_Cama(edlargcampia.getText().toString());
                        greenAlmacigos.setP_Variedad_Seleccion(edotvarpia.getText().toString());
                        greenAlmacigos.setQ_Clon(edclonpia.getText().toString());
                        greenAlmacigos.setR_Material_Establecido(spmatestpia.getSelectedItem().toString());
                        greenAlmacigos.setS_Presentacion_Material(sppresmatpia.getSelectedItem().toString());
                        greenAlmacigos.setT_Capacidad_de_Maceta(spcapmacepia.getSelectedItem().toString());
                        greenAlmacigos.setU_Catidad_Plantada(edqtyplanpia.getText().toString());
                        greenAlmacigos.setV_Lote_Asignado(edlotepia.getText().toString());
                        greenAlmacigos.setW_Nota_Plantacion(ednotapia.getText().toString());
                        greenAlmacigos.setX_Proyecto(spproyectopia.getSelectedItem().toString());
                        //se instancia la base de datos
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        // si todo lo anterior es correcto se mandan los datos a la base de datos
                        DatabaseReference reference = database.getReference("Green House 2022").child("Plantación Almacigos");
                        //se manda mensaje
                        Toast.makeText(ghAlmacigosAgregar.this.getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        //se mandan los valores a los getter an setter
                        reference.push().setValue(greenAlmacigos);
                        //se limipan los campos
                        limpiardatospia();

                    }
                }
            }
        });

        return view;
    }

    //se validan datos
    private void validacionespia () {
        String camapia = edcamapia.getText().toString();
        String canppa = edqtyplanpia.getText().toString();

        if (canppa.equals("")||camapia.equals("")){
            edcamapia.setError("Requerido");
            edqtyplanpia.setError("Requerido");
        }
    }

    //se genera la limpieza de los datos
    private void limpiardatospia (){
        edcamapia.setText("");
        edclonpia.setText("");
        edotvarpia.setText("");
        edqtyplanpia.setText("");
    }

    //llena la información del usuario
    private void recivirdatosarp() {
        Bundle extras = getActivity().getIntent().getExtras();
        String d1 = extras.getString("da1");
        String d2 = extras.getString("da2");
        String d3 = extras.getString("da3");
        txtusupia.setText(d1);
        txtzonpia.setText(d2);
        txtpuespia.setText(d3);
    }
}