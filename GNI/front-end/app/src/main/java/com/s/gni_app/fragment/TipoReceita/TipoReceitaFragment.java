package com.s.gni_app.fragment.TipoReceita;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.s.gni_app.R;
import com.s.gni_app.model.dataBase.DAO.TipoReceitaDAO;
import com.s.gni_app.model.intancia.TipoDespesa;
import com.s.gni_app.model.intancia.TipoReceita;

public class TipoReceitaFragment extends Fragment {

    public TipoReceitaFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragment = inflater.inflate(R.layout.fragment_tipo_receita, container, false);
        Button cadReceitaBtn = fragment.findViewById(R.id.cadReceitadialogBtn);

        TipoReceitaDAO tipoReceitaDAO = new TipoReceitaDAO(getContext());
        ListView listViewTipoReceita = fragment.findViewById(R.id.listViewTipoReceita);

        ArrayAdapter<TipoDespesa> adapter = new ArrayAdapter(getContext(),android.R.layout.simple_expandable_list_item_1,tipoReceitaDAO.listTipoReceita());
        listViewTipoReceita.setAdapter(adapter);

        cadReceitaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final View cardCadTipoReceita = inflater.inflate(R.layout.card_cad_tipo_receita,container,false);
                final AlertDialog dialog = creatAlertDialog(cardCadTipoReceita);

                Button cadReceitaBtn = cardCadTipoReceita.findViewById(R.id.cadTipoReceitaBtn);

                cadReceitaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText nomeTipoReceitaTxt = cardCadTipoReceita.findViewById(R.id.nomeTipoReceitaTxt);
                        saveTipoReceita(nomeTipoReceitaTxt.getText().toString());
                        dialog.dismiss();
                        Toast.makeText(getContext(),"Salvo com sucesso", Toast.LENGTH_LONG).show();
                        setFragment();

                    }
                });
            }
        });

        return fragment;
    }

    private AlertDialog creatAlertDialog(View cardCadTipoReceita){

        AlertDialog.Builder buider = new AlertDialog.Builder(getContext());
        buider.setTitle("Cadastrar novo tipo de receita");
        buider.setView(cardCadTipoReceita);
        final AlertDialog dialog = buider.create();
        dialog.show();
        return  dialog;
    }

    private void setFragment(){

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transition = manager.beginTransaction();
        String tag = "fragmentReceita";
        TipoReceitaFragment listTipoFragment = new TipoReceitaFragment();
        transition.replace(R.id.frameBase, listTipoFragment,tag);
        transition.addToBackStack(tag);
        transition.commit();

    }


    public void saveTipoReceita(String nome){

        TipoReceita tipoReceita = new TipoReceita(nome);
        TipoReceitaDAO tipoReceitaDAO = new TipoReceitaDAO(getContext());
        tipoReceitaDAO.create(tipoReceita);

    }


}
