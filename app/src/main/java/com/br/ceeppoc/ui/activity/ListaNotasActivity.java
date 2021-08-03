package com.br.ceeppoc.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.br.ceeppoc.R;
import com.br.ceeppoc.dao.NotaDAO;
import com.br.ceeppoc.model.Nota;
import com.br.ceeppoc.ui.recyclerview.adapter.ListaNotasAdapter;

import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        ListView listaNotas = findViewById(R.id.listView);

        NotaDAO dao = new NotaDAO();
        dao.insere(new Nota("primeira nota", "segunda nota"));

        List<Nota> todaNotas = dao.todos();

        listaNotas.setAdapter(new ListaNotasAdapter(this, todaNotas));
    }
}