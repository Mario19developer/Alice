package com.example.alice.Vistas_BK_Empaque;

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

import com.example.alice.BKModelo.BKAlmacigos;
import com.example.alice.BKModelo.BKEmpaque;
import com.example.alice.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class bkEmpaqueAgregar extends Fragment {

    TextView txtusubkem, txtfecharbkem, txtsbkem, txtzonbkem, txtpuebkem;
    EditText edfechbkem, edotvarbkem, edclonbkem, edtotplantbkem, ednotabkem;
    TextInputLayout ti1bkem, ti2bkem, ti3bkem, ti4bkem, ti5bkem, ti6bkem, ti7bkem,
            ti8bkem, ti9bkem,  ti10bkem;
    AutoCompleteTextView auranbkem, auvarbkem, auproplabkem, aucavchatbkem, audestinobkem;
    Button btnguadarbkem;

    String usua;

    boolean u1a;

    public bkEmpaqueAgregar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bk_empaque_agregar, container, false);

        //Variable Fecha (d)
        Date d = new Date();

        txtusubkem = view.findViewById(R.id.txtusubkem);
        txtfecharbkem = view.findViewById(R.id.txtfecharbkem);
        txtsbkem = view.findViewById(R.id.txtsbkem);
        txtzonbkem = view.findViewById(R.id.txtzonbkem);
        txtpuebkem = view.findViewById(R.id.txtpuebkem);
        edfechbkem = view.findViewById(R.id.edfechbkem);
        edotvarbkem = view.findViewById(R.id.edotvarbkem);
        edclonbkem = view.findViewById(R.id.edclonbkem);
        edtotplantbkem = view.findViewById(R.id.edtotplantbkem);
        ednotabkem = view.findViewById(R.id.ednotabkem);
        auranbkem = view.findViewById(R.id.auranbkem);
        auvarbkem = view.findViewById(R.id.auvarbkem);
        auproplabkem = view.findViewById(R.id.auproplabkem);
        aucavchatbkem = view.findViewById(R.id.aucavchatbkem);
        audestinobkem = view.findViewById(R.id.audestinobkem);
        btnguadarbkem = view.findViewById(R.id.btnguadarbkem);

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
        txtfecharbkem.setText(fechahora);
        //Se visualiza la semana
        txtsbkem.setText(fechasem);
        //se visualiza la fecha
        edfechbkem.setText(fechaCom);

        //llenado de ranchos
        String [] items1 = { "", "Maravilla", "Granados", "El Moral"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter1 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items1);
        auranbkem.setAdapter(itemAdapter1);

        //llenado de variedad
        String [] items2 = { "", "BT304.3", "BT311.4", "BV773.13", "BW150.1", "BZ1055.1", "BZ1070.1", "BZ1077.1", "Delaney",
                "Catherine", "Elvira", "Laurita", "Nigel", "Normita", "Paulina", "Rebeca", "Victoria", "Valeria"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter2 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items2);
        auvarbkem.setAdapter(itemAdapter2);

        //llenado de producto
        String [] items3 = { "", "Tray Plants", "TC´s"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter3 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items3);
        auproplabkem.setAdapter(itemAdapter3);

        //llenado de cavidad de la planta
        String [] items4 = { "", "1", "40", "45", "50", "54", "72", "77", "84", "128", "200", "280", "288"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter4 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items4);
        aucavchatbkem.setAdapter(itemAdapter4);

        //llenado de Numero de cosecha
        String [] items6 = { "", "Cooler Frialsa", "Guzman", "Jocotepec", "Tangancicuaro"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter6 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items6);
        audestinobkem.setAdapter(itemAdapter6);

        recivirdatosabkem();

        //
        btnguadarbkem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //traemos la clase Brotes Blackberry para hacer el llenado en la bd
                BKEmpaque bkEmpaque = new BKEmpaque();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Blackberry_2023").child("Empaque");

                //se extrae el texto de los campos
                String catbkem = "Consolidación";

                String usubkem = txtusubkem.getText().toString();
                String fecharbkem = txtfecharbkem.getText().toString();
                String fechbkem = edfechbkem.getText().toString();
                String zonbkem = txtzonbkem.getText().toString();
                String ranbkem = auranbkem.getText().toString();
                String varbkem = auvarbkem.getText().toString();
                String otvarbkem = edotvarbkem.getText().toString();
                String clonbkem = edclonbkem.getText().toString();
                String proplabkem = auproplabkem.getText().toString();
                String cavchatbkem = aucavchatbkem.getText().toString();
                String totplantbkem = edtotplantbkem.getText().toString();
                String destinobkem = audestinobkem.getText().toString();
                String notabkem = ednotabkem.getText().toString();

                if (edtotplantbkem.getText().toString().equals("")){
                    validacionesbkem();
                    Toast.makeText(getActivity(),"Revisa, Datos Faltantes", Toast.LENGTH_LONG).show();
                }else {
                    if (edotvarbkem.getText().toString().equals("")){
                        bkEmpaque.setB_Categoria(catbkem);
                        bkEmpaque.setC_Usuario(usubkem);
                        bkEmpaque.setD_Fecha_Registro(fecharbkem);
                        bkEmpaque.setE_Fecha_Empaque(fechbkem);
                        bkEmpaque.setF_Zona(zonbkem);
                        bkEmpaque.setG_Rancho(ranbkem);
                        bkEmpaque.setH_Variedad_Seleccion(varbkem);
                        bkEmpaque.setI_Clon(clonbkem);
                        bkEmpaque.setJ_Producto_Plantado(proplabkem);
                        bkEmpaque.setK_Cavidad_Trasplantada(cavchatbkem);
                        bkEmpaque.setL_Total_Planta_Plantada(totplantbkem);
                        bkEmpaque.setM_Destino(destinobkem);
                        bkEmpaque.setN_Nota(notabkem);
                        reference.push().setValue(bkEmpaque);
                        Toast.makeText(getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        limpiarbkem();
                    }
                    else{
                        bkEmpaque.setB_Categoria(catbkem);
                        bkEmpaque.setC_Usuario(usubkem);
                        bkEmpaque.setD_Fecha_Registro(fecharbkem);
                        bkEmpaque.setE_Fecha_Empaque(fechbkem);
                        bkEmpaque.setF_Zona(zonbkem);
                        bkEmpaque.setG_Rancho(ranbkem);
                        bkEmpaque.setH_Variedad_Seleccion(otvarbkem);
                        bkEmpaque.setI_Clon(clonbkem);
                        bkEmpaque.setJ_Producto_Plantado(proplabkem);
                        bkEmpaque.setK_Cavidad_Trasplantada(cavchatbkem);
                        bkEmpaque.setL_Total_Planta_Plantada(totplantbkem);
                        bkEmpaque.setM_Destino(destinobkem);
                        bkEmpaque.setN_Nota(notabkem);
                        reference.push().setValue(bkEmpaque);
                        Toast.makeText(getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        limpiarbkem();
                    }
                }
            }
        });

        return view;

    }

    private void validacionesbkem() {
        String v1 = edtotplantbkem.getText().toString();
        String v2 = auranbkem.getText().toString();
        String v3 = audestinobkem.getText().toString();

        if (v1.equals("") && v2.equals("") && v3.equals("")){
            edtotplantbkem.setError("Requerido");
            auranbkem.setError("Requerido");
            audestinobkem.setError("Requerido");
        }
    }

    private void limpiarbkem() {
        edtotplantbkem.setText("");
        audestinobkem.setText("");
    }

    private void recivirdatosabkem() {
        Bundle extras = getActivity().getIntent().getExtras();
        String d1 = extras.getString("bk1");
        String d2 = extras.getString("bk2");
        String d3 = extras.getString("bk3");
        txtusubkem.setText(d1);
        txtzonbkem.setText(d2);
        txtpuebkem.setText(d3);
    }
}