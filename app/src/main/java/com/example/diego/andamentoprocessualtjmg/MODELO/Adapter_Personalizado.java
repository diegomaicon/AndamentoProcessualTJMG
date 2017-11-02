package com.example.diego.andamentoprocessualtjmg.MODELO;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.example.diego.andamentoprocessualtjmg.R;

/**
 * Created by lukew on 02/11/2017.
 */

public class Adapter_Personalizado extends BaseAdapter{

    private final List<Cliente> clientes;
    private final Activity act;

    public Adapter_Personalizado(List<Cliente> cursos, Activity act) {
        this.clientes = cursos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int position) {
        return clientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = act.getLayoutInflater()
                .inflate(R.layout.lista_personalizada, parent, false);


        Cliente cliente = clientes.get(position);

        TextView nome = (TextView)
                view.findViewById(R.id.tvNome);
        TextView cpf = (TextView)
                view.findViewById(R.id.tvCPF);
        TextView email = (TextView)
                view.findViewById(R.id.tvEmail);
        TextView fone = (TextView)
                view.findViewById(R.id.tvFone);
        ImageView imagem = (ImageView)
                view.findViewById(R.id.lista_curso_personalizada_imagem);

        nome.setText(cliente.getNome());
        cpf.setText("CPF:"+cliente.getCpf()+"\t");
        email.setText("Email:"+cliente.getEmail());
        fone.setText("Fone:"+cliente.getTelefone());
        imagem.setImageResource(R.drawable.user);

        return view;
    }
}
