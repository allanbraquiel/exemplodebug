package mobile.fasam.edu;

import android.content.ContentValues;
import android.content.Context;
import android .database.sqlite.SQLiteDatabase;

public class BancoDeDados {

    public SQLiteDatabase banco;
    public GerenciarBanco gerenciarBanco;

    public BancoDeDados(Context context){
        gerenciarBanco = new GerenciarBanco(context);
    }

    public boolean criarAluno(String nome, String disciplina, String n1, String n2, String n3, double media, String status){
        banco = gerenciarBanco.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", nome);
        valores.put("disciplina", disciplina);
        valores.put("n1", n1);
        valores.put("n2", n2);
        valores.put("n3", n3);
        valores.put("media", media);
        valores.put("status", status);

        long resultado = banco.insert("aluno", null, valores);
        banco.close();

        return resultado > 0;
    }
}
