package com.s.gni_app.Activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.s.gni_app.R;
import com.s.gni_app.fragment.TipoReceita.TipoReceitaFragment;
import com.s.gni_app.fragment.tipoDespesa.ListTipoFragment;
import com.s.gni_app.fragment.Funcionario.FuncionarioFragment;
import com.s.gni_app.fragment.PrincipalFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Gerenciador de Negocios");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setPrincipal();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragManager = this.getSupportFragmentManager();
        List<Fragment> fragmentList = fragManager.getFragments();
        if( fragmentList.get((fragmentList.size()-1)).getTag().equals("fragmentBase")){
            finish();
        }else{
            setPrincipal();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_cad_despesas) {
            setCadDespesas();
        } else if (id == R.id.nav_cad_receitas) {
            setCadReceita();
        }  else if (id == R.id.nav_exportar_xls) {

        }  else if (id == R.id.nav_inicio) {
            setPrincipal();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setCadReceita(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transition = manager.beginTransaction();
        String tag = "fragmentReceita";
        TipoReceitaFragment listTipoFragment = new TipoReceitaFragment();
        transition.replace(R.id.frameBase, listTipoFragment,tag);
        transition.addToBackStack(tag);
        transition.commit();
    }

    private void setCadDespesas(){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transition = manager.beginTransaction();
        String tag = "fragmentDespesa";
        ListTipoFragment listTipoFragment = new ListTipoFragment();
        transition.replace(R.id.frameBase, listTipoFragment,tag);
        transition.addToBackStack(tag);
        transition.commit();
    }

    private void setPrincipal(){
        PrincipalFragment fragment = new PrincipalFragment();
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.addToBackStack("fragmentBase");
        transition.replace(R.id.frameBase,fragment,"fragmentBase");
        transition.commit();
    }

}
