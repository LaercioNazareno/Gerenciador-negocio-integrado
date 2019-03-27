package com.gerenciador_negocios_integrado.app.View.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.gerenciador_negocios_integrado.app.R;
import com.gerenciador_negocios_integrado.app.dataBase.DAO.TipoDespesasDAO;
import com.gerenciador_negocios_integrado.app.model.TipoDespesas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button novoTipo = findViewById(R.id.despesasCadasatro);

        final RadioButton despesaRadioButton = findViewById(R.id.despesaRadioButton);
        final RadioButton receitaRadioButton = findViewById(R.id.radioButton2);

        despesaRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    receitaRadioButton.setChecked(false);
                }
            }
        });

        receitaRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    despesaRadioButton.setChecked(false);
                }
            }
        });

        novoTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tipoText = findViewById(R.id.editText);
                save(tipoText.getText().toString(), receitaRadioButton, despesaRadioButton);
            }
        });




        TipoDespesasDAO tipoDespesasDAO = new TipoDespesasDAO(getBaseContext());

        ListView listView = findViewById(R.id.listView);
        List<TipoDespesas> tipoDespesas = tipoDespesasDAO.tipoDespesasList();
        List<String> nomeDespesas = new ArrayList<>();
        for(TipoDespesas tipo : tipoDespesas){
            nomeDespesas.add("nome: "+tipo.getNome()+" / "+ "tipo " + tipo.getTipo());
        }
        Adapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nomeDespesas);
        listView.setAdapter((ListAdapter) adapter);

    }

    public void save(String despesasText, RadioButton receitaRadioButton, RadioButton despesaRadioButton){

        TipoDespesasDAO tipoDespesasDAO = new TipoDespesasDAO(getBaseContext());

        TipoDespesas tipoDespesas = new TipoDespesas(despesasText);

        if(receitaRadioButton.isChecked()){
           tipoDespesas.setTipo("Receita");
        }else{

            if(despesaRadioButton.isChecked()){
                tipoDespesas.setTipo("Despesa");
            }

        }
        //elan
        long id = tipoDespesasDAO.insert(tipoDespesas);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}

