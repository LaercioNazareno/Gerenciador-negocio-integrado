package com.s.gni_app.model.dataBase.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.s.gni_app.model.dataBase.Conexao;
import com.s.gni_app.model.intancia.TipoReceita;

import java.util.ArrayList;
import java.util.List;

public class TipoReceitaDAO {

    private Conexao conexao;
    private SQLiteDatabase base;

    public TipoReceitaDAO(Context context){

        conexao = new Conexao(context);
        base = conexao.getWritableDatabase();
    }

    public long create(TipoReceita tipoReceita){

        ContentValues values = new ContentValues();
        values.put("nome", tipoReceita.getNome());
        return base.insert("tipoReceita", null,values);
    }

    public List<TipoReceita> listTipoReceita(){

        List<TipoReceita> tipoDespesaList = new ArrayList<>();
        Cursor cursor = base.query("tipoReceita", new String[]{"nome"},null,null, null,null,null);

        while(cursor.moveToNext()){
            TipoReceita tipo = new TipoReceita();
            tipo.setNome(cursor.getString(0));
            tipoDespesaList.add(tipo);
        }

        return tipoDespesaList;
    }
}
