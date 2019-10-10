package mobile.fasam.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends DebugActivity {

    EditText txtNome;
    EditText txtSobrenome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exibir(View view) {

        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);

        String nome, sobrenome;
        nome = txtNome.getText().toString();
        sobrenome = txtSobrenome.getText().toString();

        String dados = String.format("O texto digitado foi: %s %s", nome, sobrenome);

        Toast.makeText(getApplicationContext(), dados, Toast.LENGTH_SHORT).show();

        txtNome.setText("");
        txtSobrenome.setText("");


    }



}
