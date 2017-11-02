package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.diego.andamentoprocessualtjmg.DAO.dbCliente;
import com.example.diego.andamentoprocessualtjmg.LIB.Mask;
import com.example.diego.andamentoprocessualtjmg.MODELO.Cliente;
import com.example.diego.andamentoprocessualtjmg.R;

public class ClienteActivity extends AppCompatActivity {
    private ImageButton botao;
    private TextWatcher proMask;
    private EditText nome;
    private EditText editCpf;
   private EditText editTelefone;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        this.setTitle("Cadastro de Cliente");



        botao = (ImageButton) findViewById(R.id.btnInsert);

        botao.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                nome = (EditText) findViewById(R.id.editNome);

                editCpf= (EditText) findViewById(R.id.editCpf);
                proMask = Mask.insert("###.###.###-##", editCpf);
                editCpf.addTextChangedListener(proMask);

                editTelefone = (EditText) findViewById(R.id.editTelefone);
                proMask = Mask.insert("(##)#####-####", editTelefone);
                editTelefone.addTextChangedListener(proMask);

                email = (EditText) findViewById(R.id.editEmail);

                String nomeString = nome.getText().toString();
                String cpfString = editTelefone.getText().toString();
                String telefoneString = editTelefone.getText().toString();
                String emailString = email.getText().toString();

                dbCliente dbc = new dbCliente(getApplicationContext());
                Cliente c = new Cliente(nomeString,cpfString,telefoneString,emailString);
                dbc.insertCliente(c);

                Toast.makeText(getApplicationContext(), "Cadastro Realizado", Toast.LENGTH_LONG).show();

                Intent it;
                it = new Intent(ClienteActivity.this, ListaClienteActivity.class);
                startActivity(it);

            }
        });
    }
}
