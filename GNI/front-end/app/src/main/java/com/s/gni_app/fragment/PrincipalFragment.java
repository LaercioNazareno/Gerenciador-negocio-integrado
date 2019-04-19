package com.s.gni_app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.s.gni_app.R;
import com.s.gni_app.fragment.Despesa.ListDespesaFragment;
import com.s.gni_app.fragment.Receita.CadastroReceitaFragment;

public class PrincipalFragment extends Fragment {

    public PrincipalFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_principal, container, false);

        Button despesaBtn = view.findViewById(R.id.despesaBtn);

        despesaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDespesasFragment();
            }
        });

        Button receitaBtn = view.findViewById(R.id.receitaBtn);

        receitaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReceitaFragment();
            }
        });

        return view ;
    }

    private void setReceitaFragment(){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transition = manager.beginTransaction();
        String tag = "fragmentDespesa";
        CadastroReceitaFragment cadastroDespesaFragment = new CadastroReceitaFragment();
        transition.replace(R.id.frameBase, cadastroDespesaFragment,tag);
        transition.addToBackStack(tag);
        transition.commit();
    }


    private void setDespesasFragment(){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transition = manager.beginTransaction();
        String tag = "fragmentDespesa";
        ListDespesaFragment cadastroDespesaFragment = new ListDespesaFragment();
        transition.replace(R.id.frameBase, cadastroDespesaFragment,tag);
        transition.addToBackStack(tag);
        transition.commit();
    }

}
