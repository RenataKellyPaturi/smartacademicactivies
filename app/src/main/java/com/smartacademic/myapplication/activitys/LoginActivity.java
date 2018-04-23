package com.smartacademic.myapplication.activitys;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.smartacademic.myapplication.R;
import com.smartacademic.myapplication.util.AlertUtil;
import com.smartacademic.myapplication.util.Conexao;
import com.smartacademic.myapplication.util.EncryptUtil;

public class LoginActivity extends AppCompatActivity  {



    private FirebaseAuth firebaseAuth;
    private EditText ediEmail, ediSenha;
    private Button btnEntrar;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        ediEmail = (EditText)findViewById(R.id.email);
        ediSenha = (EditText) findViewById(R.id.password);
        btnEntrar = (Button) findViewById(R.id.buttonEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrir = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(abrir);
            }
        });
        //        progressDialog = AlertUtil.getProgressDialog(this, "Verificando credenciais",
//                "Aguarde um momento");
    }

//    @Override
//    public void onStart(){
//        super.onStart();
//        firebaseAuth.addAuthStateListener(this);
//    }
//
//    @Override
//    public void onDestroy(){
//        super.onDestroy();
//        firebaseAuth.removeAuthStateListener(this);
//    }
//
//    public void login(View view) {
//        if(ediEmail.getText().toString().trim().equals("")){
//            AlertUtil.toast(getBaseContext(), "Informe o e-mail de usuário");
//        }else if(ediSenha.getText().toString().trim().equals("")){
//            AlertUtil.toast(getBaseContext(), "Informe a senha de usuário");
//        }
//        else {
//            progressDialog.show();
//
//            String email = ediEmail.getText().toString();
//            String password = ediSenha.getText().toString();
//            password = EncryptUtil.encryptPassword(password);
//
//            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    progressDialog.dismiss();
//                    if (!task.isSuccessful()) {
//                        if (task.getException() instanceof FirebaseAuthInvalidUserException) {
//                            AlertUtil.toast(getBaseContext(), "Não há usuário registrado com o e-mail informado");
//                        } else if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
//                            AlertUtil.toast(getBaseContext(), "E-mail ou senha inválidos");
//
//                        } else {
//                            AlertUtil.toast(getBaseContext(), "Ocorreu um erro. Tente Novamente.");
//                        }
//                    }
//                }
//            });
//        }
//    }
//
//    @Override
//    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//        FirebaseUser user = firebaseAuth.getCurrentUser();
//        if(user!=null){
//            String emailUser = user.getEmail();
//            String uid = user.getUid();
//            String userLog = uid + " - " + emailUser;
//            Toast.makeText(this, "Usuário logado: " + userLog, Toast.LENGTH_SHORT).show();
//
//            Intent abrir = new Intent(LoginActivity.this, MenuActivity.class);
//            startActivity(abrir);
//
//        }else{
//            Toast.makeText(this, "Usuário não logado", Toast.LENGTH_SHORT).show();
//        }
//    }



//
//    String url = "";
//    String parametros = "";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        ediEmail = (EditText) findViewById(R.id.email);
//        ediSenha = (EditText) findViewById(R.id.password);
//        btnEntrar = (Button) findViewById(R.id.button);
//
//        btnEntrar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//
//                if (networkInfo != null && networkInfo.isConnected()) {
//
//                    String email = ediEmail.getText().toString();
//                    String senha = ediSenha.getText().toString();
//
//                    if(email.isEmpty() || senha.isEmpty()){
//                        Toast.makeText(getApplicationContext(), "Nenhuma campo pode está vazio", Toast.LENGTH_SHORT).show();
//                    }else{
//                        url = "http://192.168.25.7:8080/protocolo-urb/api/login/";//ipda maquina
//                        parametros = "email=" + email + "senha"+ senha;
//                        new SolicitaDados().execute(url);
//                    }
//
//                } else {
//                    Toast.makeText(getApplicationContext(), "Nenhuma conecão foi detectada", Toast.LENGTH_SHORT).show();
//                }
//            }//fim metodoOnclick
//        });//fim metodoOnclickListener
//
//    }//sim do OnCreate
//
//
//    private class SolicitaDados extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... urls){
//            return Conexao.postDados(urls[0], parametros );
//        }
//        @Override
//        protected void onPostExecute(String resultado){
//            //
//            Intent abrir = new Intent(LoginActivity.this, MenuActivity.class);
//            startActivity(abrir);
//
//        }
//    }
//
//    @Override
//    protected void onPause(){
//        super.onPause();
//        finish();
//    }
}
