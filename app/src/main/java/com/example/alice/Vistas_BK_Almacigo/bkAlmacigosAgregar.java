package com.example.alice.Vistas_BK_Almacigo;

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
import com.example.alice.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bkAlmacigosAgregar extends Fragment {

    TextView txtusubkpa, txtfechrebkpa, txtsbkpa, txtzonbkpa, txtpuebkpa;
    EditText edfechpbkpa, edcodplabkpa, edcamabkpa, edposibkpa, edanchocamabkpa, edlargocamabkpa, edotravarbkpa,
            edclonbkpa, edtipopruebbkpa, edlibtotplabkpa, edpromtroplabkpa, edttroplabkpa,edmacetastotalesbkpa, ednotabkpa;
    TextInputLayout ti1bkpa, ti2bkpa, ti3bkpa, ti4bkpa, ti5bkpa, ti6bkpa, ti7bkpa, ti8bkpa, ti9bkpa, ti10bkpa, ti11bkpa,
            ti12bkpa, ti13bkpa, ti14bkpa;
    AutoCompleteTextView auranchobkpa, auladobkpa, auvariedadbkpa, auprodplanbkpa, aucalplantbkpa;
    Button btncalcularbkpa, btnguardarbkpa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bk_almacigos_agregar, container, false);

        //Variable Fecha (d)
        Date d = new Date();

        txtusubkpa = view.findViewById(R.id.txtusubkpa);
        txtfechrebkpa = view.findViewById(R.id.txtfechrebkpa);
        txtsbkpa = view.findViewById(R.id.txtsbkpa);
        txtzonbkpa = view.findViewById(R.id.txtzonbkpa);
        txtpuebkpa = view.findViewById(R.id.txtpuebkpa);
        edfechpbkpa = view.findViewById(R.id.edfechpbkpa);
        auranchobkpa = view.findViewById(R.id.auranchobkpa);
        edcodplabkpa = view.findViewById(R.id.edcodplabkpa);
        edcamabkpa = view.findViewById(R.id.edcamabkpa);
        edposibkpa = view.findViewById(R.id.edposibkpa);
        auladobkpa = view.findViewById(R.id.auladobkpa);
        edanchocamabkpa = view.findViewById(R.id.edanchocamabkpa);
        edlargocamabkpa = view.findViewById(R.id.edlargocamabkpa);
        auvariedadbkpa = view.findViewById(R.id.auvariedadbkpa);
        edotravarbkpa = view.findViewById(R.id.edotravarbkpa);
        edclonbkpa = view.findViewById(R.id.edclonbkpa);
        auprodplanbkpa = view.findViewById(R.id.auprodplanbkpa);
        edtipopruebbkpa = view.findViewById(R.id.edtipopruebbkpa);
        aucalplantbkpa = view.findViewById(R.id.aucalplantbkpa);
        edlibtotplabkpa = view.findViewById(R.id.edlibtotplabkpa);
        edpromtroplabkpa = view.findViewById(R.id.edpromtroplabkpa);
        edttroplabkpa = view.findViewById(R.id.edttroplabkpa);
        btncalcularbkpa = view.findViewById(R.id.btncalcularbkpa);
        edmacetastotalesbkpa = view.findViewById(R.id.edmacetastotalesbkpa);
        ednotabkpa = view.findViewById(R.id.ednotabkpa);
        btnguardarbkpa = view.findViewById(R.id.btnguardarbkpa);

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
        txtfechrebkpa.setText(fechahora);
        //Se visualiza la semana
        txtsbkpa.setText(fechasem);
        //se visualiza la fecha
        edfechpbkpa.setText(fechaCom);

        //llenado de ranchos
        String [] items1 = { "", "Maravilla", "Granados", "El Moral"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter1 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items1);
        auranchobkpa.setAdapter(itemAdapter1);

        //llenado de variedad
        String [] items2 = { "", "BT304.3", "BT311.4", "BV773.13", "BW150.1", "BZ1055.1", "BZ1070.1", "BZ1077.1", "Delaney",
                "Catherine", "Elvira", "Laurita", "Nigel", "Normita", "Paulina", "Rebeca", "Victoria", "Valeria"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter2 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items2);
        auvariedadbkpa.setAdapter(itemAdapter2);

        //llenado de producto
        String [] items3 = { "", "RBM", "Cajas"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter3 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items3);
        auprodplanbkpa.setAdapter(itemAdapter3);

        //llenado de calibre de la planta
        String [] items4 = { "", "Chico", "Mediano", "Gruezo"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter4 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items4);
        aucalplantbkpa.setAdapter(itemAdapter4);

        //llenado de Numero de cosecha
        String [] items5 = { "", "Norte", "Sur"};
        //Sea gregar el array adapter y se especifica la ubicacion del Variedad
        ArrayAdapter<String> itemAdapter5 = new ArrayAdapter<>(getActivity(), R.layout.s_dropdown_item,items5);
        auladobkpa.setAdapter(itemAdapter5);

        //agrega los datos del usuario
        recivirdatosabkpa();

        btncalcularbkpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculartotaltrozosbkpa();
            }
        });

        btnguardarbkpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //traemos la clase Brotes Blackberry para hacer el llenado en la bd
                BKAlmacigos bkAlmacigos = new BKAlmacigos();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Blackberry_2023").child("Plantacion Almacigos");

                String semana = txtsbkpa.getText().toString();
                String rancho = auranchobkpa.getText().toString() ;
                String variedad = auvariedadbkpa.getText().toString();
                String ovariedad = edotravarbkpa.getText().toString();
                String clon  = edclonbkpa.getText().toString() ;

                String codebkpa = semana+rancho+variedad+ovariedad+clon.trim();

                //se extrae el texto de los campos
                String catbkpa = "Plantación Almacigos";
                String usubkpa = txtusubkpa.getText().toString();
                String fechrebkpa = txtfechrebkpa.getText().toString();
                String fechpbkpa = edfechpbkpa.getText().toString();
                String zonbkpa = txtzonbkpa.getText().toString();
                String ranchobkpa = auranchobkpa.getText().toString();
                String codplabkpa = edcodplabkpa.getText().toString();
                String cultbkpa = "Blackberry";
                String camabkpa = edcamabkpa.getText().toString();
                String posibkpa = edposibkpa.getText().toString();
                String ladobkpa = auladobkpa.getText().toString();
                String anchocamabkpa = edanchocamabkpa.getText().toString();
                String largocamabkpa = edlargocamabkpa.getText().toString();
                String variedadbkpa = auvariedadbkpa.getText().toString();
                String otravarbkpa = edotravarbkpa.getText().toString();
                String clonbkpa = edclonbkpa .getText().toString();
                String prodplanbkpa = auprodplanbkpa.getText().toString();
                String tipopruebbkpa = edtipopruebbkpa.getText().toString();
                String calplantbkpa = aucalplantbkpa.getText().toString();
                String libtotplabkpa = edlibtotplabkpa.getText().toString();
                String promtroplabkpa = edpromtroplabkpa.getText().toString();
                String ttroplabkpa = edttroplabkpa.getText().toString();
                String macetastotalesbkpa = edmacetastotalesbkpa.getText().toString();
                String notabkpa = ednotabkpa.getText().toString();

                if (libtotplabkpa.equals("")){
                    validacionesbkpa();
                    Toast.makeText(getActivity(),"Revisa, Datos Faltantes", Toast.LENGTH_LONG).show();
                }
                else {
                    if (edotravarbkpa.getText().toString().equals("")){
                        bkAlmacigos.setB_Categoria(catbkpa);
                        bkAlmacigos.setC_Usuario(usubkpa);
                        bkAlmacigos.setD_Fecha_Registro(fechrebkpa);
                        bkAlmacigos.setE_Fecha_Plantacion(fechpbkpa);
                        bkAlmacigos.setF_Zona_Plantacion(zonbkpa);
                        bkAlmacigos.setG_Rancho_Plantacion(ranchobkpa);
                        bkAlmacigos.setH_Codigo_Origen(codplabkpa);
                        bkAlmacigos.setI_Cultivo(cultbkpa);
                        bkAlmacigos.setJ_Cama(camabkpa);
                        bkAlmacigos.setK_Posicion(posibkpa);
                        bkAlmacigos.setL_Lado(ladobkpa);
                        bkAlmacigos.setM_Ancho_Cama(anchocamabkpa);
                        bkAlmacigos.setN_Largo_Cama(largocamabkpa);
                        bkAlmacigos.setO_Variedad_Seleccion(variedadbkpa);
                        bkAlmacigos.setP_Clon(clonbkpa);
                        bkAlmacigos.setQ_Prueba(tipopruebbkpa);
                        bkAlmacigos.setR_Producto_Plantado(prodplanbkpa);
                        bkAlmacigos.setS_Calibre_de_Planta_Plantada(calplantbkpa);
                        bkAlmacigos.setT_Libras_Totales_Plantadas(libtotplabkpa);
                        bkAlmacigos.setU_Promedio_de_Trozos_Plantados(promtroplabkpa);
                        bkAlmacigos.setV_Total_de_Trozos_Plantados(ttroplabkpa);
                        bkAlmacigos.setW_Total_Macetas_Plantadas(macetastotalesbkpa);
                        bkAlmacigos.setX_Nota_Plantacion(notabkpa);
                        bkAlmacigos.setY_Codigo_Almacigos(codebkpa);
                        reference.push().setValue(bkAlmacigos);
                        Toast.makeText(getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        limpiarbkpa();
                    }
                    else {
                        bkAlmacigos.setB_Categoria(catbkpa);
                        bkAlmacigos.setC_Usuario(usubkpa);
                        bkAlmacigos.setD_Fecha_Registro(fechrebkpa);
                        bkAlmacigos.setE_Fecha_Plantacion(fechpbkpa);
                        bkAlmacigos.setF_Zona_Plantacion(zonbkpa);
                        bkAlmacigos.setG_Rancho_Plantacion(ranchobkpa);
                        bkAlmacigos.setH_Codigo_Origen(codplabkpa);
                        bkAlmacigos.setI_Cultivo(cultbkpa);
                        bkAlmacigos.setJ_Cama(camabkpa);
                        bkAlmacigos.setK_Posicion(posibkpa);
                        bkAlmacigos.setL_Lado(ladobkpa);
                        bkAlmacigos.setM_Ancho_Cama(anchocamabkpa);
                        bkAlmacigos.setN_Largo_Cama(largocamabkpa);
                        bkAlmacigos.setO_Variedad_Seleccion(otravarbkpa);
                        bkAlmacigos.setP_Clon(clonbkpa);
                        bkAlmacigos.setQ_Prueba(tipopruebbkpa);
                        bkAlmacigos.setR_Producto_Plantado(prodplanbkpa);
                        bkAlmacigos.setS_Calibre_de_Planta_Plantada(calplantbkpa);
                        bkAlmacigos.setT_Libras_Totales_Plantadas(libtotplabkpa);
                        bkAlmacigos.setU_Promedio_de_Trozos_Plantados(promtroplabkpa);
                        bkAlmacigos.setV_Total_de_Trozos_Plantados(ttroplabkpa);
                        bkAlmacigos.setW_Total_Macetas_Plantadas(macetastotalesbkpa);
                        bkAlmacigos.setX_Nota_Plantacion(notabkpa);
                        bkAlmacigos.setY_Codigo_Almacigos(codebkpa);
                        reference.push().setValue(bkAlmacigos);
                        Toast.makeText(getActivity(),"Datos Guardados Exitosamente", Toast.LENGTH_SHORT).show();
                        limpiarbkpa();
                    }
                }
            }
        });

        return view;

    }

    private void validacionesbkpa() {
        String v1 = edmacetastotalesbkpa.getText().toString();
        String v2 = edcamabkpa.getText().toString();
        String v3 = edlibtotplabkpa.getText().toString();
        String v4 = edpromtroplabkpa.getText().toString();
        String v5 = edttroplabkpa.getText().toString();

        if (v1.equals("") && v2.equals("") && v3.equals("") && v4.equals("") && v5.equals("")){
            edmacetastotalesbkpa.setError("Requerido");
            edcamabkpa.setError("Requerido");
            edlibtotplabkpa.setError("Requerido");
            edpromtroplabkpa.setError("Requerido");
            edttroplabkpa.setError("Requerido");
        }
    }

    private void limpiarbkpa(){
        edcodplabkpa.setText("");
        edcamabkpa.setText("");
        edposibkpa.setText("");
        edcodplabkpa.setText("");
        edcodplabkpa.setText("");
        edcodplabkpa.setText("");
        edclonbkpa.setText("");
        edlibtotplabkpa.setText("");
        edpromtroplabkpa.setText("");
        edttroplabkpa.setText("");
        edmacetastotalesbkpa.setText("");
    }

    private void calculartotaltrozosbkpa(){
        String ns1 = edlibtotplabkpa.getText().toString();
        String ns2 = edpromtroplabkpa.getText().toString();

        if (ns1.equals("") || ns2.equals("")){
            Toast.makeText(getActivity(),"Revisar Datos", Toast.LENGTH_SHORT).show();
            return;
        }

        //Convertimos texto a numero pero usamos boleano para el punto decimal
        Double n1 = Double.parseDouble(ns1);// convertimos y pasamos el primer valor
        Double n2 = Double.parseDouble(ns2);// convertimos y pasamos el segundo valor

        Double v1 = (n1 * n2);// mutiplica Planta por charola Completa

        //String r1 = String.valueOf(v1);//Convertimos el valor entero a texto

        DecimalFormat precision = new DecimalFormat("0.0"); //
        edttroplabkpa.setText(precision.format(v1));

    }

    private void recivirdatosabkpa() {

        Bundle extras = getActivity().getIntent().getExtras();
        String d1 = extras.getString("bk1");
        String d2 = extras.getString("bk2");
        String d3 = extras.getString("bk3");
        txtusubkpa.setText(d1);
        txtzonbkpa.setText(d2);
        txtpuebkpa.setText(d3);

    }
}