package com.br.ceeppoc.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.br.ceeppoc.R;
import com.br.ceeppoc.dao.NotaDAO;
import com.br.ceeppoc.model.Nota;
import com.br.ceeppoc.ui.recyclerview.adapter.ListNotasAdapter;
import com.br.ceeppoc.ui.recyclerview.adapter.ListaNotasAdapter;

import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);

        NotaDAO dao = new NotaDAO();
        for (int i = 0; i <= 1000; i++) {
            dao.insere(new Nota("Titulo " + i, "descricao " + i));
        }

        List<Nota> todaNotas = dao.todos();

        listaNotas.setAdapter(new ListNotasAdapter(this, todaNotas));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listaNotas.setLayoutManager(layoutManager);
    }
}