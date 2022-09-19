package com.example.alice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class SMainActivity extends AppCompatActivity {

    //Se instancian los elementos del layout
    ImageButton ibtmenu_mp, ibtcerrar_mp;
    TextView txtusump, txtfechamp, txtsemmp, txtzonmp, txtpuesmp;

    //variables para envio a siguiente interfaz
    String usamp, zonamp, puestomp = "";

    //Se intancia la autentificacion de firebase y la base de datos
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //Variable Fecha (d)
        Date d = new Date();

        ibtmenu_mp = findViewById(R.id.ibtmenu_mp);
        ibtcerrar_mp = findViewById(R.id.ibtcerrar_mp);
        txtusump = findViewById(R.id.txtusump);
        txtfechamp = findViewById(R.id.txtfechamp);
        txtsemmp = findViewById(R.id.txtsemmp);
        txtzonmp = findViewById(R.id.txtzonmp);
        txtpuesmp = findViewById(R.id.txtpuesmp);

        //Sacamos la fecha completa
        SimpleDateFormat fecc = new SimpleDateFormat("dd/MM/yyyy");
        String fechaComString = fecc.format(d);

        /*se saca el año
        SimpleDateFormat feca = new SimpleDateFormat("yy");
        String fechaacom = feca.format(d);
         */

        //se saca la semana
        SimpleDateFormat fec = new SimpleDateFormat("ww");
        String fechacom = fec.format(d);

        //se pasa el concepto de fecha, año y semana
        txtfechamp.setText(fechaComString);
        txtsemmp.setText(fechacom);

        ibtmenu_mp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zonai = txtzonmp.getText().toString();

                switch (zonai){
                    case "Tangancicuaro":
                    case "CD. Guzman":

                        Intent mpbb = new Intent(SMainActivity.this, MenuBlackberry.class);
                        usamp = txtusump.getText().toString();
                        zonamp = txtzonmp.getText().toString();
                        puestomp = txtpuesmp.getText().toString();
                        mpbb.putExtra("da1",usamp);
                        mpbb.putExtra("da2",zonamp);
                        mpbb.putExtra("da3",puestomp);
                        startActivity(mpbb);//Blackberry

                        break;

                    default:
                        Intent mpgh = new Intent(SMainActivity.this,MenuGreenHouse.class);
                        usamp = txtusump.getText().toString();
                        zonamp = txtzonmp.getText().toString();
                        puestomp = txtpuesmp.getText().toString();
                        mpgh.putExtra("da1",usamp);
                        mpgh.putExtra("da2",zonamp);
                        mpgh.putExtra("da3",puestomp);
                        startActivity(mpgh);//Raspberry
                }
            }
        });

        //Cierra la sesion iniciada, en caso de que no se aplique este
        //paso la sesion puede permancer abierta durante muchos dias
        //Cerrar Sesion
        ibtcerrar_mp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();// finaliza la sesion
                startActivity(new Intent(SMainActivity.this, SLogin.class));
                finish();
            }
        });

        getUserinfo();

    }

    //trae el usuario que inicio sesión
    private void getUserinfo(){
        String id = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){

                    //se trae el registro de la base de datos user para trasforarlo en texto ya en el layout
                    // String name = dataSnapshot.child("Nombre").getValue().toString();
                    String email = Objects.requireNonNull(dataSnapshot.child("Email").getValue()).toString();
                    String puesto = Objects.requireNonNull(dataSnapshot.child("Puesto").getValue()).toString();
                    String zona = Objects.requireNonNull(dataSnapshot.child("Zona").getValue()).toString();

                    //se traspasa el concepto al layout
                    txtusump.setText(email);
                    txtzonmp.setText(zona);
                    txtpuesmp.setText(puesto);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}