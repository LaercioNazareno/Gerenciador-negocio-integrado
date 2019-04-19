package com.s.gni_app.fragment.Receita;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.s.gni_app.R;
import com.s.gni_app.model.dataBase.DAO.ReceitaDAO;
import com.s.gni_app.model.intancia.Receita;

import java.util.List;

public class ListReceitasFragment extends Fragment {

    public ListReceitasFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_list_receitas, container, false);

        ListView listViewReceitas = fragment.findViewById(R.id.ListViewReceitas);
        ReceitaDAO receitaDAO = new ReceitaDAO(getContext());
        List<Receita> receitaList  = receitaDAO.listDespesas();
        ArrayAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_expandable_list_item_1,receitaList);
        listViewReceitas.setAdapter(adapter);

        double soma = 0.00;
        for(Receita receita: receitaList){
            soma+=receita.getValor();
        }
        TextView textView = fragment.findViewById(R.id.textViewTotal);
        textView.setText("Total ="+ soma);
        return fragment;
    }

}
