package com.example.alice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SLogin extends AppCompatActivity {

    //Agregacion de elementos de layout
    EditText email, password;
    Button login;
    TextView registrar;

    //Parametros de error
    boolean isEmailValid, isPasswordValid;
    TextInputLayout emailError, passError;

    //Se pasa el usuario y la contraseña como variables para proceder a generar el login
    private String emaill = "";
    private String passwordl = "";

    //Se trae la autentificacion de Firebase
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Se genera la intancia de la base de datos Firebase
        mAuth = FirebaseAuth.getInstance();

        //Seteo de layout hacia la clase
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        login = findViewById(R.id.Login);
        registrar = findViewById(R.id.Regitrar);
        emailError = (TextInputLayout) findViewById(R.id.EmailError);
        passError =  (TextInputLayout) findViewById(R.id.PassError);

        //Se revisan la validaciones del inicio de sesión para ingresar el sistema
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emaill = email.getText().toString();
                passwordl = password.getText().toString();
                Validacion(); //Constructor de validación.

            }
        });

        //Se registra un nuevo usuario
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // redirect to RegisterActivity
                Intent intent = new Intent(getApplicationContext(), Registrar.class);
                startActivity(intent);
            }
        });
    }

    //Se genera el metodo de validacion si las condiciones se cumplen procede a inciar sesion.
    private void Validacion() {
        // Check for a valid email address.
        if (email.getText().toString().isEmpty()) {
            emailError.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            emailError.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else  {
            isEmailValid = true;
            emailError.setErrorEnabled(false);
        }

        // Check for a valid password.
        if (password.getText().toString().isEmpty()) {
            passError.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else if (password.getText().length() < 6) {
            passError.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        } else  {
            isPasswordValid = true;
            passError.setErrorEnabled(false);
        }

        if (isEmailValid && isPasswordValid) {
            Toast.makeText(getApplicationContext(), "Por favor Espere...", Toast.LENGTH_SHORT).show();
            LoginUser();
        }
    }

    //Revisa que el usuario este registrado en la base de datos de Firebase
    private void LoginUser() {
        mAuth.signInWithEmailAndPassword(emaill, passwordl).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(SLogin.this, SMainActivity.class));
                    Toast.makeText(SLogin.this, "Bienvenido" + emaill, Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(SLogin.this, "No se pudo iniciar sesion comprueba los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Mantinen la sesion activa en el menu pricipal
    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser()!= null){
            startActivity(new Intent(SLogin.this, SMainActivity.class));
            finish();
        }
    }
}