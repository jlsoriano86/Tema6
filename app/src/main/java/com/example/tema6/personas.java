package com.example.tema6;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import static android.Manifest.permission.CALL_PHONE;

public class personas extends AppCompatActivity {
    ImageView imagen1;
    ImageView imagen2;
    ImageView imagen3;
    ImageView imagen4;
    ImageView imagen5;
    ImageView imagen6;
    SharedPreferences preferences;
    String datos = "";
    String telefono, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);
        imagen1 = findViewById(R.id.imagen1);
        imagen2 = findViewById(R.id.imagen2);
        imagen3 = findViewById(R.id.imagen3);
        imagen4 = findViewById(R.id.imagen4);
        imagen5 = findViewById(R.id.imagen5);
        imagen6 = findViewById(R.id.imagen6);
        // Asociamos el menú contextual al control
        registerForContextMenu(imagen1);
        registerForContextMenu(imagen2);
        registerForContextMenu(imagen3);
        registerForContextMenu(imagen4);
        registerForContextMenu(imagen5);
        registerForContextMenu(imagen6);

        imagen1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               telefono = "telefono1";
               email = "email1";
                return false;
            }
        });
        imagen2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                telefono = "telefono2";
                email = "email2";
                return false;
            }
        });
        imagen3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                telefono = "telefono3";
                email = "email3";
                return false;
            }
        });
        imagen4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                telefono = "telefono4";
                email = "email4";
                return false;
            }
        });

        imagen5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                telefono = "telefono5";
                email = "email5";
                return false;
            }
        });


        imagen6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                telefono = "telefono6";
                email = "email6";
                return false;
            }
        });

    }



        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_personas, menu);
        }
        @Override
        public boolean onContextItemSelected(MenuItem item) {

            preferences = getSharedPreferences("contactos", MODE_PRIVATE);
            switch (item.getItemId()) {
                case R.id.opcionCtx1:
                    datos = preferences.getString(telefono, null);
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        Intent i1 = new Intent(Intent.ACTION_CALL);
                        //datos = preferences.getString(telefono, null);
                        i1.setData(Uri.parse(datos));
                        startActivity(i1);
                    } else {
                        requestPermissions(new String[]{CALL_PHONE}, 1);
                    }
                    break;
                case R.id.opcionCtx2:
                    datos = preferences.getString(email, null);
                    Intent i2 = new Intent(Intent.ACTION_SEND);
                    i2.setType("text/plain");
                    i2.putExtra(Intent.EXTRA_SUBJECT, "Asunto de prueba");
                    i2.putExtra(Intent.EXTRA_TEXT, "Probando el envío");
                    //datos = preferences.getString(email, null);
                    i2.putExtra(Intent.EXTRA_EMAIL, new String[]{datos});
                    startActivity(i2);
                    break;
                case R.id.opcionCtx3:  // Acción a realizar por contextual 3
                    Intent i3 = new Intent (personas.this, com.example.tema6.editarPersonaActivity.class);
                    startActivity(i3);
                    break;
            }
            return true;



            }
}
