package com.example.proyectot45;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar miProgreso = findViewById(R.id.miProgreso);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                miProgreso.setVisibility(View.GONE);
                Intent intent = new Intent(MainActivity.this,Pantalla2.class);
                startActivity(intent);
            }
        }, 3000);

    }
}