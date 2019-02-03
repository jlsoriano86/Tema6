package com.example.tema6;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class editarPersonaActivity extends AppCompatActivity {
    ImageView imagen1,imagen2,imagen3,imagen4, imagen5,imagen6;
    SharedPreferences preferences;
    EditText txtTelefono, txtEmail;
    String email = "", telefono = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_persona);
        imagen1= findViewById(R.id.imagenEditar1);
        imagen2= findViewById(R.id.imagenEditar2);
        imagen3= findViewById(R.id.imagenEditar3);
        imagen4= findViewById(R.id.imagenEditar4);
        imagen5= findViewById(R.id.imagenEditar5);
        imagen6= findViewById(R.id.imagenEditar6);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);


        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);

    }

    public void guardarDatos(View view)
    {
        preferences = getSharedPreferences("contactos", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(telefono, txtTelefono.getText().toString());
        editor.putString(email, txtEmail.getText().toString());
        editor.commit();
    }


    public void guardarDatos1(View view) {
        telefono = "telefono1";
        email = "email1";
    }

    public void guardarDatos2(View view) {
        telefono = "telefono2";
        email = "email2";
    }

    public void guardarDatos3(View view) {
        telefono = "telefono3";
        email = "email3";
    }

    public void guardarDatos4(View view) {
        telefono = "telefono4";
        email = "email4";
    }

    public void guardarDatos5(View view) {
        telefono = "telefono5";
        email = "email5";
    }

    public void guardarDatos6(View view) {
        telefono = "telefono6";
        email = "email6";
    }
}
