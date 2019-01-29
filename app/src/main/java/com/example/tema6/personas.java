package com.example.tema6;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_personas, menu);
        }
        @Override
        public boolean onContextItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.opcionCtx1:  // Acción a realizar por contextual 1
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        Intent i42 = new Intent(Intent.ACTION_CALL);
                        i42.setData(Uri.parse("tel:954112233"));
                        startActivity(i42);
                    } else {
                        requestPermissions(new String[]{CALL_PHONE}, 1);
                    }
                    break;
                case R.id.opcionCtx2:  // Acción a realizar por contextual 2
                    Intent i41 = new Intent(Intent.ACTION_SEND);
                    i41.setType("text/plain");
                    i41.putExtra(Intent.EXTRA_SUBJECT, "Asunto de prueba");
                    i41.putExtra(Intent.EXTRA_TEXT, "Probando el envío");
                    i41.putExtra(Intent.EXTRA_EMAIL, new String[]{"mi@email.es"});
                    startActivity(i41);
                    break;
                case R.id.opcionCtx3:  // Acción a realizar por contextual 3
            }
            return true;



            }
}
