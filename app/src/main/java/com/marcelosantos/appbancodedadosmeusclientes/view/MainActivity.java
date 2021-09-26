package com.marcelosantos.appbancodedadosmeusclientes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.marcelosantos.appbancodedadosmeusclientes.controller.ClienteORMController;
import com.marcelosantos.appbancodedadosmeusclientes.database.AppDataBase;
import com.marcelosantos.appbancodedadosmeusclientes.model.Cliente;
import com.marcelosantos.appbancodedadosmeusclientes.R;
import com.marcelosantos.appbancodedadosmeusclientes.model.ClienteORM;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ClienteORMController clienteORMController;

    List<ClienteORM> listaDeClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienteORMController = new ClienteORMController();
/*
        ClienteORM orm = new ClienteORM();
        orm.setId(1);
        orm.setNome("Marcelo Santos");
        orm.setIdade(30);
        orm.setPreco(24.99);
        orm.setSalario(2.500);
        orm.setDataCadastro("16/09/2021");
        orm.setHoraCadastro("00:12");

        clienteORMController.update(orm);
*/
        listaDeClientes = clienteORMController.listar();

        for (ClienteORM obj: listaDeClientes){
            Log.d("db_cliente", "onCreate: "+obj.getId()+" "+obj.getNome());
        }
    }
}