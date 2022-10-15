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

public class MenuBlackberry extends AppCompatActivity {

    TextView txtusumbk, txtfechambk, txtsmbk, txtzonmbk, txtpuesmbk;
    ImageButton ibpalmacigosmbk, ibpbrotesmbk, ibconmormbk, ibtraspmbk, ibconsombk, ibempmbk;

    String usuz, zonz, puez = "";

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_blackberry);

        //Variable Fecha (Dias y Semanas)
        Date d = new Date();

        txtusumbk = findViewById(R.id.txtusumbk);
        txtfechambk = findViewById(R.id.txtfechambk);
        txtsmbk = findViewById(R.id.txtsmbk);
        txtzonmbk = findViewById(R.id.txtzonmbk);
        txtpuesmbk = findViewById(R.id.txtpuesmbk);

        ibpalmacigosmbk = findViewById(R.id.ibpalmacigosmbk);
        ibpbrotesmbk = findViewById(R.id.ibpbrotesmbk);
        ibconmormbk = findViewById(R.id.ibconmormbk);
        ibtraspmbk = findViewById(R.id.ibtraspmbk);
        ibconsombk = findViewById(R.id.ibconsombk);
        ibempmbk = findViewById(R.id.ibempmbk);

        //Sacamos la fecha completa & Semana
        SimpleDateFormat fecc = new SimpleDateFormat("dd/MM/yyyy");
        String fechaComString = fecc.format(d);

        SimpleDateFormat fec = new SimpleDateFormat("ww");
        String fechacom = fec.format(d);

        txtfechambk.setText(fechaComString);
        txtsmbk.setText(fechacom);

        //Almacigos
        ibpalmacigosmbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bkAlmaciogos = new Intent (MenuBlackberry.this, BkMenuAlmacigos.class);

                usuz = txtusumbk.getText().toString();
                zonz = txtzonmbk.getText().toString();
                puez = txtpuesmbk.getText().toString();

                bkAlmaciogos.putExtra("bk1",usuz);
                bkAlmaciogos.putExtra("bk2",zonz);
                bkAlmaciogos.putExtra("bk3",puez);

                startActivity(bkAlmaciogos);
            }
        });

        //Brotes
        ibpbrotesmbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bkBrotes = new Intent (MenuBlackberry.this, BkMenuBrotes.class);

                usuz = txtusumbk.getText().toString();
                zonz = txtzonmbk.getText().toString();
                puez = txtpuesmbk.getText().toString();

                bkBrotes.putExtra("bk1",usuz);
                bkBrotes.putExtra("bk2",zonz);
                bkBrotes.putExtra("bk3",puez);

                startActivity(bkBrotes);
            }
        });

        //Trasplante
        ibtraspmbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bkTrasplante = new Intent (MenuBlackberry.this, BkMenuTrasplante.class);

                usuz = txtusumbk.getText().toString();
                zonz = txtzonmbk.getText().toString();
                puez = txtpuesmbk.getText().toString();

                bkTrasplante.putExtra("bk1",usuz);
                bkTrasplante.putExtra("bk2",zonz);
                bkTrasplante.putExtra("bk3",puez);

                startActivity(bkTrasplante);
            }
        });

        //Mortandad
        ibconmormbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bkMortandad = new Intent (MenuBlackberry.this, BkMenuMortandad.class);

                usuz = txtusumbk.getText().toString();
                zonz = txtzonmbk.getText().toString();
                puez = txtpuesmbk.getText().toString();

                bkMortandad.putExtra("bk1",usuz);
                bkMortandad.putExtra("bk2",zonz);
                bkMortandad.putExtra("bk3",puez);

                startActivity(bkMortandad);
            }
        });

        //Consolidacion
        ibconsombk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bkConsolidacion = new Intent (MenuBlackberry.this, BkMenuConsolidacion.class);

                usuz = txtusumbk.getText().toString();
                zonz = txtzonmbk.getText().toString();
                puez = txtpuesmbk.getText().toString();

                bkConsolidacion.putExtra("bk1",usuz);
                bkConsolidacion.putExtra("bk2",zonz);
                bkConsolidacion.putExtra("bk3",puez);

                startActivity(bkConsolidacion);
            }
        });

        ibempmbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bkEmpaque = new Intent(MenuBlackberry.this, BkMenuEmpaque.class);

                usuz = txtusumbk.getText().toString();
                zonz = txtzonmbk.getText().toString();
                puez = txtpuesmbk.getText().toString();

                bkEmpaque.putExtra("bk1", usuz);
                bkEmpaque.putExtra("bk2", zonz);
                bkEmpaque.putExtra("bk3", puez);

                startActivity(bkEmpaque);
            }
        });

        recivirdatosmp();
    }

    //Empaque
    private void recivirdatosmp() {
        Bundle extras = getIntent().getExtras();
        String d1 = extras.getString("da1");
        String d2 = extras.getString("da2");
        String d3 = extras.getString("da3");
        txtusumbk.setText(d1);
        txtzonmbk.setText(d2);
        txtpuesmbk.setText(d3);
    }
}