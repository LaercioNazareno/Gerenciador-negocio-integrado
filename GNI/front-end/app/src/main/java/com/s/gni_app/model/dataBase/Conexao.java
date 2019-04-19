package com.s.gni_app.model.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "gni_db";
    private static final int version = 1;


    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table user(id integer primary key autoincrement," +
                "name varchar(50), " +
                "last_name varchar(50), " +
                "email varchar(50), " +
                "password varchar(10))");

        db.execSQL("create table tipoDespesa(id integer primary key autoincrement," +
                "nome varchar(50)," +
                "periodicidade integer)");

        db.execSQL("create table tipoReceita(id integer primary key autoincrement," +
                "nome varchar(50))");

        db.execSQL("create table despesa(id integer primary key autoincrement," +
                "titulo varchar(50)," +
                "tipoId integer,"+
                "valor real,"+
                "data varchar(50))");

        db.execSQL("create table receita(id integer primary key autoincrement," +
                "tipoId integer,"+
                "valor real,"+
                "data varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
