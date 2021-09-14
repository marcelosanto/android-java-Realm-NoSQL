package com.marcelosantos.appbancodedadosmeusclientes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.marcelosantos.appbancodedadosmeusclientes.database.AppDataBase;
import com.marcelosantos.appbancodedadosmeusclientes.model.Cliente;
import com.marcelosantos.appbancodedadosmeusclientes.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}