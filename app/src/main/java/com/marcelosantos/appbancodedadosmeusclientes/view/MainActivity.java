package com.marcelosantos.appbancodedadosmeusclientes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.marcelosantos.appbancodedadosmeusclientes.controller.ClienteORMController;
import com.marcelosantos.appbancodedadosmeusclientes.database.AppDataBase;
import com.marcelosantos.appbancodedadosmeusclientes.model.Cliente;
import com.marcelosantos.appbancodedadosmeusclientes.R;
import com.marcelosantos.appbancodedadosmeusclientes.model.ClienteORM;

public class MainActivity extends AppCompatActivity {

    ClienteORMController clienteORMController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienteORMController = new ClienteORMController();

        ClienteORM orm = new ClienteORM();
        orm.setNome("Marcello");
        orm.setIdade(30);
        orm.setPreco(12.98);
        orm.setSalario(2.000);
        orm.setDataCadastro("14/09/2021");
        orm.setHoraCadastro("12:12");

        clienteORMController.insert(orm);

    }
}