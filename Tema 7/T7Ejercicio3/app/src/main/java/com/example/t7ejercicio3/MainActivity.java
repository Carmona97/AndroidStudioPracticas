package com.example.t7ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button misPrefs = findViewById(R.id.definePrefs);
        misPrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verDependencias = new Intent(MainActivity.this,ActividadPreferencias.class);
                startActivity(verDependencias);
            }
        });
    }
}