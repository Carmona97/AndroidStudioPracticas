package com.example.pruebamenus;

import static com.example.pruebamenus.R.id.op1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.menu);

        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView dia = findViewById(R.id.resultado);

        int id = item.getItemId();
        if (id == R.id.op1 || id == R.id.op2 || id == R.id.op3 || id == R.id.op4
                || id == R.id.op5 || id == R.id.op6 || id == R.id.op7) {
            dia.setText("Pulsado "+item.getTitle());
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }




}