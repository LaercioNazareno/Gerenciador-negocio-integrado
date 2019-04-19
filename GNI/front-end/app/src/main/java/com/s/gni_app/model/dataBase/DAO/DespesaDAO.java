package com.s.gni_app.model.dataBase.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.s.gni_app.model.dataBase.Conexao;
import com.s.gni_app.model.intancia.Despesa;
import com.s.gni_app.model.intancia.TipoDespesa;

import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {

    private Conexao conexao;
    private SQLiteDatabase base;

    public DespesaDAO(Context context){

        conexao = new Conexao(context);
        base = conexao.getWritableDatabase();
    }

    public long create(Despesa despesa){

        ContentValues values = new ContentValues();
        values.put("titulo", despesa.getTitulo());
        values.put("tipoId", despesa.getTipo());
        values.put("valor", despesa.getValor());
        values.put("data", despesa.getData());
        return base.insert("despesa", null,values);
    }

    public List<Despesa> listDespesas(){

        List<Despesa> despesaList = new ArrayList<>();
        Cursor cursor = base.query("despesa", new String[]{"titulo","tipoId","valor","data"},null,null, null,null,null);

        while(cursor.moveToNext()){
            Despesa despesa = new Despesa();
            despesa.setTitulo(cursor.getString(0));
            despesa.setTipo(cursor.getInt(1));
            despesa.setValor(cursor.getDouble(2));
            despesa.setData(cursor.getString(3));
            despesaList.add(despesa);
        }


        return despesaList;
    }

}
