package mobile.fasam.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaActivity extends DebugActivity {

    EditText txtNome;
    EditText txtEmail;
    ListView listView;

    List<HashMap<String,String>> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
    }

    public void OK(View view) {

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);


        //extrair conteudo do componente edittext

        String nome, email;

        nome = txtNome.getText().toString();
        email = txtEmail.getText().toString();


        //Saida para o usuario
        String dados = String.format("Dados digitados: %s %s",nome, email);

        HashMap<String,String> map = new HashMap<>();
        map.put("nome", nome);
        map.put("email", email);

        lista.add(map);

        //Mapeamento de dados do List<HashMap< K,V> para imprimir no layout
        String[] de = {"nome", "email"};
        //ids  do layout item.xml
        int[] para = {R.id.labelNome, R.id.labelEmail};


        //Criar o simpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(
                getApplicationContext(),
                lista,
                R.layout.item,
                de,
                para
        );

        //Buscar a ListView imprimir os dados
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        txtNome.setText("");
        txtEmail.setText("");

    }
}
