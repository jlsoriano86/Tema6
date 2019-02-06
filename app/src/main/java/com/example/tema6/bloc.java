package com.example.tema6;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class bloc extends AppCompatActivity {
    SharedPreferences preferences;
    EditText txtBloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloc);
        preferences = getSharedPreferences("preferenciasBloc", MODE_PRIVATE);
        txtBloc = findViewById(R.id.txtBloc);
        txtBloc.setMovementMethod(new ScrollingMovementMethod());
        txtBloc.setText(preferences.getString("bloc", ""));
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("bloc", txtBloc.getText().toString());
        editor.commit();
        return false;
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_guardar_bloc, menu);
        MenuBuilder m = (MenuBuilder) menu;
        m.setOptionalIconsVisible(true);
        return true;
    }


}
