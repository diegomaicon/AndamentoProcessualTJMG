package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.diego.andamentoprocessualtjmg.DAO.BancoController;
import com.example.diego.andamentoprocessualtjmg.R;

public class ClienteActivity extends AppCompatActivity {
    private ImageButton botao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        botao = (ImageButton) findViewById(R.id.btnInsert);

        botao.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText nome = (EditText) findViewById(R.id.editNome);
                EditText cpf = (EditText) findViewById(R.id.editCpf);
                EditText telefone = (EditText) findViewById(R.id.editTelefone);
                EditText email = (EditText) findViewById(R.id.editEmail);

                String nomeString = nome.getText().toString();
                String cpfString = cpf.getText().toString();
                String telefoneString = telefone.getText().toString();
                String emailString = email.getText().toString();
                String resultado;

                resultado = crud.insereCliente(nomeString, cpfString, telefoneString, emailString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
