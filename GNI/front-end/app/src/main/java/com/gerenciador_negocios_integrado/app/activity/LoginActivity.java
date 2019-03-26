package com.gerenciador_negocios_integrado.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gerenciador_negocios_integrado.app.R;
import com.gerenciador_negocios_integrado.app.dataBase.DAO.UserDao;
import com.gerenciador_negocios_integrado.app.objects.User;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cadastrar();
        singIn();

    }

    private void singIn(){

        Button loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView emailTextView = findViewById(R.id.emailTextViewCadastro);
                TextView passwordTextView = findViewById(R.id.passwordTextViewCadastro);

               if(!allowed(emailTextView.getText().toString(),passwordTextView.getText().toString())){
                   Toast.makeText(getBaseContext(),"usuario ou senha errados", Toast.LENGTH_LONG).show();
               }
            }
        });
    }

    private boolean allowed(String emailText, String passwordText){

        if(emailText!=null&& passwordText!=null){

            final UserDao userDao = new UserDao(getBaseContext());

            List<User> userList =  userDao.userList();

            for(User user : userList){
                if(user.getEmail().equals(emailText) && user.getPassword().equals(passwordText)){
                    this.user = user;
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    return true;
                }
            }
        }

        return false;
    }

    private void cadastrar(){

        Button registerFormBtn = findViewById(R.id.registerFormBtn);

        registerFormBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.card_cadastro);

                save();
                back();

            }
        });
    }

    private void back(){
        Button backoginBtn = findViewById(R.id.backLoginBtn);

        backoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setContentView(R.layout.activity_login);

                cadastrar();

            }
        });
    }

    private void save(){

        final UserDao userDao = new UserDao(getBaseContext());

        Button registerUserBtn = findViewById(R.id.registerUserForm);

        registerUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView userNameText = findViewById(R.id.nameTextCadastro),
                        lastNameText  = findViewById(R.id.lastNameTextCadastro),
                        emailText     = findViewById(R.id.emailTextViewCadastro),
                        passWordText  = findViewById(R.id.passwordTextViewCadastro);

                User user = new User(emailText.getText().toString(),userNameText.getText().toString(),
                                     lastNameText.getText().toString(),passWordText.getText().toString());

                long id = userDao.insert(user);

            }
        });

    }

}
