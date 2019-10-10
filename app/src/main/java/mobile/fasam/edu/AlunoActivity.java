package mobile.fasam.edu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AlunoActivity extends DebugActivity {

    EditText txtNomeAluno;
    EditText txtDisciplina;
    EditText txtN1;
    EditText txtN2;
    EditText txtN3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
    }

    public void btnConfirma(View view) {


        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());

        txtNomeAluno = findViewById(R.id.txtNomeAluno);
        txtDisciplina = findViewById(R.id.txtDisciplina);
        txtN1 = findViewById(R.id.txtN1);
        txtN2 = findViewById(R.id.txtN2);
        txtN3 = findViewById(R.id.txtN3);


        String nomeAluno;
        String disciplina;
        double n1;
        double n2;
        double n3;
        double media;
        String msg;
        String resultadoFinal;

        AlertDialog alerta;

        nomeAluno = txtNomeAluno.getText().toString();
        disciplina = txtDisciplina.getText().toString();
        n1 = Double.parseDouble(txtN1.getText().toString());
        n2 = Double.parseDouble(txtN2.getText().toString());
        n3 = Double.parseDouble(txtN3.getText().toString());


        media = (n1 + n2 + n3) / 3;

        if (media >= 7){
            resultadoFinal = "Aprovado";
        }
        else if (media < 7 && media >=4){
            resultadoFinal = "Recuperação";
        }
        else{
            resultadoFinal = "Reprovado";
        }

        msg = String.format("Aluno: %s \nDisciplina: %s\nNota 1: %s" +
                "\nNota 2: %s \nNota3: %s\n Média Final: %s" +
                "\nResultado Final: %s", nomeAluno, disciplina, n1, n2, n3, media, resultadoFinal);

         boolean resultado = bancoDeDados.criarAluno(txtNomeAluno.getText().toString(), txtDisciplina.getText().toString(),
                txtN1.getText().toString(), txtN2.getText().toString(), txtN3.getText().toString(), media, resultadoFinal);




        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Resultado");
        builder.setMessage(msg);

        alerta = builder.create();
        alerta.show();

        //Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();


    }


    public void btnCancela(View view) {

        Intent intent;

        intent = new Intent(this,HomeActivity.class);
        startActivity(intent);

    }
}
