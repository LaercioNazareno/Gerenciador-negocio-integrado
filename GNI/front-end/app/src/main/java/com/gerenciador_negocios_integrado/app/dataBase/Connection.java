package com.gerenciador_negocios_integrado.app.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Connection extends SQLiteOpenHelper {

    private static final String name = "gni_db";
    private static final int version = 1;


    public Connection(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table user(id integer primary key autoincrement," +
                                     "name varchar(50), " +
                                     "last_name varchar(50), " +
                                     "email varchar(50), " +
                                     "password varchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
