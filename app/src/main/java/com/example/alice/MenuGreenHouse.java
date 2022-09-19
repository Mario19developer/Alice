package com.example.alice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuGreenHouse extends AppCompatActivity {

    //Se instancian los elementos del layout
    ImageButton ibtalmacigomgh, ibtcosechaamgh, ibtbrotesmgh, ibtmortandadmgh, ibttrasplantemgh, ibtactivimgh, ibtcerrarmgh;
    TextView txtusumgh, txtfechamgh, txtsemmgh, txtzonmgh, txtpuesmgh;


    String useremgh, zonmgh, puegh = "";

    //Se intancia la autentificacion de firebase y la base de datos
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_green_house);

        //mAuth = FirebaseAuth.getInstance();
        //mDatabase = FirebaseDatabase.getInstance().getReference();

        //Variable Fecha (d)
        Date d = new Date();

        //seteo de layout
        ibtalmacigomgh = findViewById(R.id.ibtalmacigomgh);
        ibtcosechaamgh = findViewById(R.id.ibtcosechaamgh);
        ibtbrotesmgh = findViewById(R.id.ibtbrotesmgh);
        ibtmortandadmgh = findViewById(R.id.ibtmortandadmgh);
        ibttrasplantemgh = findViewById(R.id.ibttrasplantemgh);
        ibtactivimgh = findViewById(R.id.ibtactivimgh);
        ibtcerrarmgh = findViewById(R.id.ibtcerrarmgh);
        txtusumgh = findViewById(R.id.txtusumgh);
        txtfechamgh = findViewById(R.id.txtfechamgh);
        txtsemmgh = findViewById(R.id.txtsemmgh);
        txtzonmgh = findViewById(R.id.txtzonmgh);
        txtpuesmgh = findViewById(R.id.txtpuesmgh);

        //Sacamos la fecha completa
        SimpleDateFormat fecc = new SimpleDateFormat("dd/MM/yyyy");
        String fechaComString = fecc.format(d);

        //se saca el año
        SimpleDateFormat feca = new SimpleDateFormat("yy");
        String fechaacom = feca.format(d);

        /*se saca la semana
        SimpleDateFormat fec = new SimpleDateFormat("ww");
        String fechacom = fec.format(d);
         */

        //se pasa el concepto de fecha, año y semana
        txtfechamgh.setText(fechaComString);

        //Plantación Almacigos
        ibtalmacigomgh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pialmacigo = new Intent(MenuGreenHouse.this, GhMenuAlmacigos.class);

                //se toma el usuario actual
                useremgh = txtusumgh.getText().toString();
                zonmgh = txtzonmgh.getText().toString();
                puegh = txtpuesmgh.getText().toString();

                //se mandadan como parametros
                pialmacigo.putExtra("da1",useremgh);
                pialmacigo.putExtra("da2",zonmgh);
                pialmacigo.putExtra("da3",puegh);

                startActivity(pialmacigo);
            }
        });

        //Plantacion Brotes
        ibtbrotesmgh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pibrotes = new Intent(MenuGreenHouse.this, GhMenuBrotes.class);

                //se toma el usuario actual
                useremgh = txtusumgh.getText().toString();
                zonmgh = txtzonmgh.getText().toString();
                puegh = txtpuesmgh.getText().toString();

                //se mandadan como parametros
                pibrotes.putExtra("da1",useremgh);
                pibrotes.putExtra("da2",zonmgh);
                pibrotes.putExtra("da3",puegh);

                startActivity(pibrotes);
            }
        });

        //Trasplante
        ibttrasplantemgh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pitrasplante = new Intent(MenuGreenHouse.this, GhMenuTrasplante.class);

                //se toma el usuario actual
                useremgh = txtusumgh.getText().toString();
                zonmgh = txtzonmgh.getText().toString();
                puegh = txtpuesmgh.getText().toString();

                //se mandadan como parametros
                pitrasplante.putExtra("da1",useremgh);
                pitrasplante.putExtra("da2",zonmgh);
                pitrasplante.putExtra("da3",puegh);

                startActivity(pitrasplante);
            }
        });

        recivirdatosmp();
    }

    private void recivirdatosmp() {
        Bundle extras = getIntent().getExtras();
        String d1 = extras.getString("da1");
        String d2 = extras.getString("da2");
        String d3 = extras.getString("da3");
        txtusumgh.setText(d1);
        txtzonmgh.setText(d2);
        txtpuesmgh.setText(d3);
    }
}