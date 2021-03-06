package com.marcelosantos.appbancodedadosmeusclientes.controller;

import com.marcelosantos.appbancodedadosmeusclientes.model.ClienteORM;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class ClienteORMController {

    public void insert(ClienteORM obj){

        Realm realm = Realm.getDefaultInstance();

        Number primaryKey = realm.where(ClienteORM.class).max("id");

        final int autoIncrementPrimaryKey = (primaryKey == null) ? 1 : primaryKey.intValue() + 1;

        obj.setId(autoIncrementPrimaryKey);

        realm.beginTransaction();
        realm.copyToRealm(obj);
        realm.commitTransaction();
        realm.close();
    }

    public void update(ClienteORM obj){

        Realm realm = Realm.getDefaultInstance();

        ClienteORM clienteORM = realm.where(ClienteORM.class).equalTo("id", obj.getId())
                .findFirst();

        realm.beginTransaction();

        if (clienteORM != null) {
            clienteORM.setNome(obj.getNome());
            clienteORM.setIdade(obj.getIdade());
            clienteORM.setPreco(obj.getPreco());
            clienteORM.setIdade(obj.getIdade());
            clienteORM.setSalario(obj.getSalario());
            clienteORM.setDataCadastro(obj.getDataCadastro());
            clienteORM.setHoraCadastro(obj.getHoraCadastro());
            clienteORM.setAtivo(obj.isAtivo());

            realm.commitTransaction();
            realm.close();
        }

    }

    public void delete(ClienteORM obj){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmResults<ClienteORM> results = realm.where(ClienteORM.class).equalTo("id",
                obj.getId()).findAll();

        results.deleteAllFromRealm();
        realm.commitTransaction();
        realm.close();
    }

    public List<ClienteORM> listar(){

        Realm realm = null;

        RealmResults<ClienteORM> results = null;

        List<ClienteORM> list = new ArrayList<>();

        try {
            realm = Realm.getDefaultInstance();

            results = realm.where(ClienteORM.class).findAll();

            list = realm.copyToRealm(results);

        } catch (RealmException e) {
            e.printStackTrace();
        } finally {
            realm.close();
        }

        return list;
    }
}
