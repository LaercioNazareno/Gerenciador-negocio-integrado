package com.s.gni_app.fragment.tipoDespesa;

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
import com.s.gni_app.model.dataBase.DAO.TipoDespesaDAO;
import com.s.gni_app.model.intancia.TipoDespesa;

import java.util.List;

public class ListTipoFragment extends Fragment {

    public ListTipoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.fragment_list_tipo, container, false);

        Button cadastrarTipoBtn = fragment.findViewById(R.id.cadastrarTipoBtn);

        cadastrarTipoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transition = manager.beginTransaction();
                String tag = "fragmentDespesa";
                CadastroTipoDespesaFragment cadastroTipoDespesaFragment = new CadastroTipoDespesaFragment();
                transition.replace(R.id.frameBase, cadastroTipoDespesaFragment,tag);
                transition.addToBackStack(tag);
                transition.commit();
            }
        });

        ListView listViewTipoDespesa = fragment.findViewById(R.id.listViewTipoDespesa);

        TipoDespesaDAO despesaDAO = new TipoDespesaDAO(getContext());
        List<TipoDespesa> despesaList = despesaDAO.listTipoDespesas();

        ArrayAdapter<TipoDespesa> adapter = new ArrayAdapter(getContext(),android.R.layout.simple_expandable_list_item_1,despesaList);

        listViewTipoDespesa.setAdapter(adapter);


        return fragment;
    }

}
