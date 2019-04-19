package com.s.gni_app.fragment.tipoDespesa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.s.gni_app.R;
import com.s.gni_app.model.dataBase.DAO.TipoDespesaDAO;
import com.s.gni_app.model.intancia.TipoDespesa;

public class CadastroTipoDespesaFragment extends Fragment {

    private static final int mensal = 4;
    private static final int semanal = 3;
    private static final int diario = 2;
    private static final int indeterminado = 1;

    public CadastroTipoDespesaFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragment = inflater.inflate(R.layout.fragment_cadastro_tipo_despesa, container, false);

        final EditText despesaEditTxt = fragment.findViewById(R.id.nomeTipoDespesaTxt);

        Button cadastrarDespesaBtn = fragment.findViewById(R.id.cadastroDespesaBtn);

        cadastrarDespesaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            int periodicidade = getPeriodicidade(fragment);
            salvarDespesa(despesaEditTxt.getText().toString(), periodicidade);
            Toast.makeText(getContext(),"Salvo com sucesso",Toast.LENGTH_LONG).show();
            setFragment();

            }
        });

        return fragment;
    }

    public void setFragment(){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transition = manager.beginTransaction();
        String tag = "fragmentDespesa";
        ListTipoFragment listTipoFragment = new ListTipoFragment();
        transition.replace(R.id.frameBase, listTipoFragment,tag);
        transition.addToBackStack(tag);
        transition.commit();
    }

    private int getPeriodicidade(View fragment){

        Switch switchDespesaMensal = fragment.findViewById(R.id.switchDespesasMensal);
        Switch switchDespesaSemanal = fragment.findViewById(R.id.switchDespesaSemanal);
        Switch switchDespesaDiaria = fragment.findViewById(R.id.switchDespesaDiaria);

        int periodicidade;

        if(switchDespesaMensal.isActivated()){
            periodicidade = mensal;
        }else{
            if(switchDespesaSemanal.isActivated()){
                periodicidade = semanal;
            }else{
                if(switchDespesaDiaria.isActivated()){
                    periodicidade = diario;
                }else{
                    periodicidade = indeterminado;
                }
            }
        }
        return  periodicidade;
    }

    private void salvarDespesa(String despesaNome, int periodicidade ){

        TipoDespesa despesa = new TipoDespesa(despesaNome, periodicidade);

        TipoDespesaDAO despesaDAO = new TipoDespesaDAO(getContext());

        despesaDAO.create(despesa);

    }

}
