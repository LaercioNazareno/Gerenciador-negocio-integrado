package com.s.gni_app.fragment.Despesa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.s.gni_app.R;
import com.s.gni_app.model.dataBase.DAO.DespesaDAO;
import com.s.gni_app.model.intancia.Despesa;

import java.util.List;

public class ListDespesaFragment extends Fragment {

    public ListDespesaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_despesa, container, false);

        Button cadDespesaBtn = fragment.findViewById(R.id.cadDespesaBtn);

        DespesaDAO despesaDAO = new DespesaDAO(getContext());
        List<Despesa> despesaList = despesaDAO.listDespesas();

        ListView listViewDespesas = fragment.findViewById(R.id.listViewDespesa);
        ArrayAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_expandable_list_item_1,despesaList);
        listViewDespesas.setAdapter(adapter);

        cadDespesaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment();
            }
        });

        return fragment;
    }

    private void setFragment(){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transition = manager.beginTransaction();
        String tag = "fragmentCadastroDespesa";
        CadastroDespesaFragment cadastroDespesaFragment = new CadastroDespesaFragment();
        transition.replace(R.id.frameBase, cadastroDespesaFragment,tag);
        transition.addToBackStack(tag);
        transition.commit();
    }
}
