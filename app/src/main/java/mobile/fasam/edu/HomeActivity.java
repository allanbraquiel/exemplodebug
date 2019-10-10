package mobile.fasam.edu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void exibirTela(View view) {

        int opcao = view.getId();
        Intent intent;

        //Verifica qual foi o botao adicionado
        switch (opcao){
            //exibir tela MainAcitivity
            case R.id.btnMain:

                intent = new Intent(this,MainActivity.class);
                startActivity(intent);

                break;

           //exibir tela ListaActivity
            case R.id.btnLista:

                intent = new Intent(this,ListaActivity.class);
                startActivity(intent);

                break;

            case R.id.btnGrid:
                intent = new Intent( this,GridActivity.class);
                startActivity(intent);

                break;

            case R.id.btnAluno:
                intent = new Intent( this, AlunoActivity.class);
                startActivity(intent);

                break;

            default:
                Toast.makeText(getApplicationContext(),"Opção invalida",
                    Toast.LENGTH_LONG).show();
                break;
        }
    }
}
