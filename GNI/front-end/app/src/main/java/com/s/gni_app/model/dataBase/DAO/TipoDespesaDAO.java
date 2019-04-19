package com.s.gni_app.model.dataBase.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.s.gni_app.model.dataBase.Conexao;
import com.s.gni_app.model.intancia.TipoDespesa;

import java.util.ArrayList;
import java.util.List;

public class TipoDespesaDAO {

    private Conexao conexao;
    private SQLiteDatabase base;

    public TipoDespesaDAO(Context context){

        conexao = new Conexao(context);
        base = conexao.getWritableDatabase();
    }

    public long create(TipoDespesa tipoDespesa){

        ContentValues values = new ContentValues();
        values.put("nome", tipoDespesa.getNome());
        values.put("periodicidade", tipoDespesa.getPeriodicidade());
        return base.insert("tipoDespesa", null,values);
    }

    public List<TipoDespesa> listTipoDespesas(){

        List<TipoDespesa> tipoDespesaList = new ArrayList<>();
        Cursor cursor = base.query("tipoDespesa", new String[]{"nome","periodicidade","id"},null,null, null,null,null);

        while(cursor.moveToNext()){
            TipoDespesa tipo = new TipoDespesa();
            tipo.setNome(cursor.getString(0));
            tipo.setPeriodicidade(cursor.getInt(1));
            tipo.setId(cursor.getInt(2));
            tipoDespesaList.add(tipo);
        }


        return tipoDespesaList;
    }

}
