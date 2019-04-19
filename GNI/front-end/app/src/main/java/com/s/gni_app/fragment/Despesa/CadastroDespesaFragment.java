package com.s.gni_app.fragment.Despesa;

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
import com.s.gni_app.model.dataBase.DAO.DespesaDAO;
import com.s.gni_app.model.dataBase.DAO.TipoDespesaDAO;
import com.s.gni_app.model.intancia.Despesa;
import com.s.gni_app.model.intancia.TipoDespesa;

import java.util.Date;
import java.util.List;

public class CadastroDespesaFragment extends Fragment {


    public CadastroDespesaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_cadastro_despesa, container, false);

        Button cadastrarDespesaBtn = fragment.findViewById(R.id.cadastrarDespesaBtn);

        final AutoCompleteTextView tipoDespesaText = fragment.findViewById(R.id.tipoDespesaTxt);
        tipoDespesaText.setAdapter(getTipoDespesasAdapter());

        final EditText titleDespesaText = fragment.findViewById(R.id.nomeDespesaTex);
        final EditText valorText = fragment.findViewById(R.id.valorDespesa);
        final EditText dataText = fragment.findViewById(R.id.dataDespesa);


        cadastrarDespesaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveDespresa(titleDespesaText.getText().toString(),tipoDespesaText.getText().toString(), valorText.getText().toString(), dataText.getText().toString() );
                setFragment();

            }
        });

        return fragment;
    }

    private void saveDespresa(String title, String tipo, String valor, String dataString){

        int tipoDespesaId = -1;
        TipoDespesaDAO tipoDespesaDAO = new TipoDespesaDAO(getContext());
        List<TipoDespesa> tipoDespesaList = tipoDespesaDAO.listTipoDespesas();

        for(TipoDespesa tipoDespesa : tipoDespesaList){
            if(tipoDespesa.getNome().equals(tipo)){
                tipoDespesaId = tipoDespesa.getId();
            }
        }

        Despesa despesa = new Despesa(title, tipoDespesaId, Double.parseDouble(valor),dataString);

        DespesaDAO despesaDAO = new DespesaDAO(getContext());
        despesaDAO.create(despesa);

    }

    private ArrayAdapter<TipoDespesa> getTipoDespesasAdapter(){

        TipoDespesaDAO tipoDespesaDAO = new TipoDespesaDAO(getContext());
        List<TipoDespesa> tipoDespesaList = tipoDespesaDAO.listTipoDespesas();

        ArrayAdapter<TipoDespesa> adapter = new ArrayAdapter(getContext(),android.R.layout.simple_expandable_list_item_1,tipoDespesaList);

        return adapter;
    }

    private void setFragment(){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transition = manager.beginTransaction();
        String tag = "fragmentCadastroDespesa";
        ListDespesaFragment listDespesaFragment = new ListDespesaFragment();
        transition.replace(R.id.frameBase, listDespesaFragment,tag);
        transition.addToBackStack(tag);
        transition.commit();
    }
}
