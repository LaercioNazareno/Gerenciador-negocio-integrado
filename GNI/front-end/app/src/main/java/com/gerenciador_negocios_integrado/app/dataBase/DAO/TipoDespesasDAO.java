package com.gerenciador_negocios_integrado.app.dataBase.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gerenciador_negocios_integrado.app.dataBase.Connection;
import com.gerenciador_negocios_integrado.app.model.TipoDespesas;

import java.util.ArrayList;
import java.util.List;

public class TipoDespesasDAO {

    private Connection connection;
    private SQLiteDatabase base;

    public TipoDespesasDAO(Context context){

        connection = new Connection(context);
        base = connection.getWritableDatabase();

    }

    public long insert(TipoDespesas user){

        ContentValues values = new ContentValues();
        values.put("tipo", user.getTipo());
        values.put("nome", user.getNome());
        return base.insert("tipo",null, values);
    }

    public List<TipoDespesas> tipoDespesasList(){

        List<TipoDespesas> tipoDespesasList = new ArrayList<>();

        Cursor cursor = base.query("tipo", new String[]{"nome","tipo"},null,null, null,null,null);

        while(cursor.moveToNext()){

           TipoDespesas tipo = new TipoDespesas();
           tipo.setNome(cursor.getString(0));
           tipo.setTipo(cursor.getString(1));
           tipoDespesasList.add(tipo);
        }

        return tipoDespesasList;
    }
}
