package com.marcelosantos.appbancodedadosmeusclientes.controller;

import com.marcelosantos.appbancodedadosmeusclientes.model.ClienteORM;

import io.realm.Realm;

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
}
