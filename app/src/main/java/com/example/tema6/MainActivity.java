package com.example.tema6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
