package com.example.diego.andamentoprocessualtjmg.ACTIVITYS;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.diego.andamentoprocessualtjmg.MODELO.Comarcas;
import com.example.diego.andamentoprocessualtjmg.R;

/**
 * Created by diego on 19/11/17.
 */

public class ParteProcessoActivity extends AppCompatActivity {

    private ImageButton btnPesquisa;
    private EditText edtNome;
    Spinner sp;
    int numeroComarca = 0;

    String comacas[] = {"Selecionar a Comarca","","Abaeté","Abre-Campo","Açucena", "Águas Formosas",
            "Aimorés", "Aiuruoca", "Além Paraíba","Alfenas","Almenara","Alpinópolis","Alto Rio Doce",
            "Alvinópolis","Andradas","Andrelândia","Araçuaí","Araguari","Araxá","Arcos","Areado","Arinos",
            "Baependi","Bambuí","Barão de Cocais","Barbacena","Barroso","Belo Horizonte","Belo Vale","Betim",
            "Bicas","Boa Esperança","Bocaiúva","Bom Despacho","Bom Sucesso","Bonfim","Bonfinópolis de Minas",
            "Borda da Mata","Botelhos","Brasília de Minas","Brasópolis","Brumadinho","Bueno Brandão","Buenópolis",
            "Buritis","Cabo Verde","Cachoeira de Minas","Caeté","Caldas","Camanducaia","Cambuí","Cambuquira",
            "Campanha","Campestre","Campina Verde","Campo Belo","Campos Altos","Campos Gerais","Canápolis",
            "Candeias","Capelinha","Capinópolis","Carandaí","Carangola","Caratinga","Carlos Chagas","Carmo da Mata",
            "Carmo de Minas","Carmo do Cajuru","Carmo do Paranaíba","Carmo do Rio Claro","Carmópolis de Minas",
            "Cássia","Cataguases","Caxambu","Cláudio","Conceição das Alagoas","Conceição do Mato Dentro",
            "Conceição do Rio Verde","Congonhas","Conquista","Conselheiro Lafaiete","Conselheiro Pena","Contagem",
            "Coração de Jesus","Corinto","Coromandel","Coronel Fabriciano","Cristina","Cruzília","Curvelo","Diamantina",
            "Divino","Divinópolis","Dores do Indaiá","Elói Mendes","Entre-Rios de Minas","Ervália","Esmeraldas","Espera Feliz",
            "Espinosa","Estrela do Sul","Eugenópolis","Extrema","Ferros","Formiga","Francisco Sá","Frutal","Galiléia","Governador Valadares",
            "Grão Mogol","Guanhães","Guapé","Guaranésia","Guarani","Guaxupé","Ibiá","Ibiraci","Ibirité","Igarapé",
            "Iguatama","Inhapim","Ipanema","Ipatinga","Itabira","Itabirito","Itaguara","Itajubá","Itamarandiba","Itambacuri",
            "Itamogi","Itamonte","Itanhandu","Itanhomi","Itapagipe","Itapecerica","Itaúna","Ituiutaba","Itumirim","Iturama",
            "Jaboticatubas","Jacinto","Jacuí","Jacutinga","Janaúba","Januária","Jequeri","Jequitinhonha","João Monlevade",
            "João Pinheiro","Juiz de Fora","Lagoa da Prata","Lagoa Santa","Lajinha","Lambari","Lavras","Leopoldina","Lima Duarte",
            "Luz","Machado","Malacacheta","Manga","Manhuaçu","Manhumirim","Mantena","Mar de Espanha","Mariana","Martinho Campos",
            "Mateus Leme","Matias Barbosa","Matozinhos","Medina","Mercês","Mesquita","Minas Novas","Miradouro","Miraí",
            "Montalvânia","Monte Alegre de Minas","Monte Azul","Monte Belo","Monte Carmelo","Monte Santo de Minas","Monte Sião",
            "Montes Claros","Morada Nova de Minas","Muriaé","Mutum","Muzambinho","Nanuque","Natércia","Nepomuceno",
            "Nova Era","Nova Lima","Nova Ponte","Nova Resende","Nova Serrana","Novo Cruzeiro","Oliveira","Ouro Branco",
            "Ouro Fino","Ouro Preto","Palma","Pará de Minas","Paracatu","Paraguaçu","Paraisópolis","Paraopeba","Passa-Quatro",
            "Passa-Tempo","Passos","Patos de Minas","Patrocínio","Peçanha","Pedra Azul","Pedralva","Pedro Leopoldo",
            "Perdizes","Perdões","Piranga","Pirapetinga","Pirapora","Pitangui","Piumhi","Poço Fundo","Poços de Caldas",
            "Pompeu","Ponte Nova","Porteirinha","Pouso Alegre","Prados","Prata","Pratápolis","Presidente Olegário",
            "Raul Soares","Resende Costa","Resplendor","Ribeirão das Neves","Rio Casca","Rio Novo","Rio Paranaíba","Rio Pardo de Minas",
            "Rio Piracicaba","Rio Pomba","Rio Preto","Rio Vermelho","Sabará","Sabinópolis","Sacramento","Salinas",
            "Santa Bárbara","Santa Luzia","Santa Maria do Suaçuí","Santa Rita de Caldas","Santa Rita do Sapucaí",
            "Santa Vitória","Santo Antônio do Monte","Santos Dumont","São Domingos do Prata","São Francisco","São Gonçalo do Sapucaí",
            "São Gotardo","São João da Ponte","São João del-Rei","São João do Paraíso","São João Evangelista",
            "São João Nepomuceno","São Lourenço","São Romão","São Roque de Minas","São Sebastião do Paraíso",
            "Senador Firmino","Serro","Sete Lagoas","Silvianópolis","Taiobeiras","Tarumirim","Teixeiras","Teófilo Otôni",
            "Timóteo","Tiros","Tombos","Três Corações","Três Marias","Três Pontas","Tupaciguara","Turmalina","Ubá","Uberaba",
            "Uberlândia","Unaí","Varginha","Várzea da Palma","Vazante","Vespasiano","Viçosa","Virginópolis",
            "Visconde do Rio Branco"};

    ArrayAdapter<String> adapter;

    private void buscandoProcesso(int numero,String nome) {
        Intent it = new Intent(this, BuscandoActivity.class);
        it.putExtra("numero", numero);
        it.putExtra("nome", nome.toUpperCase());
        it.putExtra("st", "");
        startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_parte);
        this.setTitle("Pesquisa por Partes ");
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnPesquisa = (ImageButton) findViewById(R.id.botao_perquisa_parte);
        edtNome = (EditText) findViewById(R.id.edtNome);


        sp = (Spinner)findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,comacas);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                numeroComarca = Comarcas.retornaComarca(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btnPesquisa.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                String nome = edtNome.getText().toString();

                if(!nome.equals("")){
                    try {

                        Toast.makeText(ParteProcessoActivity.this, "Buscanco processo de "+ nome, Toast.LENGTH_SHORT).show();
                        nome = nome.replaceAll(" ","+");
                        buscandoProcesso(numeroComarca,nome);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else Toast.makeText(ParteProcessoActivity.this, "Informa nome" , Toast.LENGTH_SHORT).show();
            }
        });



    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,IndexActivity.class);
        startActivity(intent);

    }

}
