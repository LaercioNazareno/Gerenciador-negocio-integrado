package com.s.gni_app.model.dataBase.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.s.gni_app.model.dataBase.Conexao;
import com.s.gni_app.model.intancia.Despesa;
import com.s.gni_app.model.intancia.Receita;

import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO {

    private Conexao conexao;
    private SQLiteDatabase base;

    public ReceitaDAO(Context context) {

        conexao = new Conexao(context);
        base = conexao.getWritableDatabase();
    }

    public long create(Receita receita) {

        ContentValues values = new ContentValues();
        values.put("valor", receita.getValor());
        values.put("tipoId", receita.getTipoId());
        values.put("data", receita.getData());
        return base.insert("receita", null, values);
    }

    public List<Receita> listDespesas() {

        List<Receita> receitaList = new ArrayList<>();
        Cursor cursor = base.query("receita", new String[]{"valor", "tipoId", "data"}, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Receita receita = new Receita();
            receita.setTipoId(cursor.getInt(1));
            receita.setValor(cursor.getDouble(0));
            receita.setData(cursor.getString(2));
            receitaList.add(receita);
        }

        return receitaList;
    }
}