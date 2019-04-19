package com.s.gni_app.fragment.Receita;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.s.gni_app.R;
import com.s.gni_app.model.dataBase.DAO.ReceitaDAO;
import com.s.gni_app.model.dataBase.DAO.TipoReceitaDAO;
import com.s.gni_app.model.intancia.Receita;
import com.s.gni_app.model.intancia.TipoReceita;

import java.util.List;

public class CadastroReceitaFragment extends Fragment {


    public CadastroReceitaFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_receita, container, false);

        final EditText valorText = fragment.findViewById(R.id.valorText);
        final AutoCompleteTextView tipoReceitaText = fragment.findViewById(R.id.tipoReceitaText);
        tipoReceitaText.setAdapter(getAdapter());
        final EditText dataText = fragment.findViewById(R.id.dataText);
        Button addReceitaBtn = fragment.findViewById(R.id.addReceitaBtn);
        Button listReceitaBtn = fragment.findViewById(R.id.listReceitaBtn);

        listReceitaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transition = manager.beginTransaction();
                String tag = "fragmentCadastroDespesa";
                ListReceitasFragment listDespesaFragment = new ListReceitasFragment();
                transition.replace(R.id.frameBase, listDespesaFragment,tag);
                transition.addToBackStack(tag);
                transition.commit();
            }
        });

        addReceitaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Receita receita = new Receita(Integer.parseInt(tipoReceitaText.getText().toString()),Double.parseDouble(valorText.getText().toString()), dataText.getText().toString());
                saveReceita(receita);
            }
        });

        return fragment;
    }

    private ArrayAdapter<TipoReceita> getAdapter(){

        TipoReceitaDAO tipoDespesaDAO = new TipoReceitaDAO(getContext());
        List<TipoReceita> tipoReceitaList = tipoDespesaDAO.listTipoReceita();

        ArrayAdapter<TipoReceita> adapter = new ArrayAdapter(getContext(),android.R.layout.simple_expandable_list_item_1,tipoReceitaList);

        return adapter;
    }


    private void saveReceita(Receita receita){

        ReceitaDAO receitaDAO = new ReceitaDAO(getContext());
        receitaDAO.create(receita);

    }

}
