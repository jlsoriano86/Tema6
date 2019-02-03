package com.example.tema6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView personas;
    ImageView bloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personas = (ImageView) findViewById(R.id.imagenPersonas);
        personas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personas = new Intent(MainActivity.this, com.example.tema6.personas.class);
                startActivity(personas);
            }
        });

        bloc = (ImageView) findViewById(R.id.imagenBloc);
        bloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bloc = new Intent(MainActivity.this, com.example.tema6.bloc.class);
                startActivity(bloc);
            }
        });

    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        MenuBuilder m = (MenuBuilder) menu;
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.opcPersonas:
                Intent personas = new Intent(MainActivity.this, com.example.tema6.personas.class);
                startActivity(personas);
                break;
            case R.id.opcBloc:
                Intent bloc = new Intent(MainActivity.this, com.example.tema6.bloc.class);
                startActivity(bloc);
                break;

        }
        return true;
    }
}
