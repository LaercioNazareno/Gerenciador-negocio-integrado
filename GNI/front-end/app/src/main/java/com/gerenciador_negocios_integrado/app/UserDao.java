package com.gerenciador_negocios_integrado.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UserDao {

    private Connection connection;
    private SQLiteDatabase base;

    public UserDao(Context context){

        connection = new Connection(context);
        base = connection.getWritableDatabase();

    }

    public long inserir(User user){

        ContentValues  values = new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("last_name", user.getLastName());
        values.put("password",user.getPassword());
        return base.insert("user",null, values);
    }

}
