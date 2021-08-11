package com.br.ceeppoc.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.br.ceeppoc.R;
import com.br.ceeppoc.dao.NotaDAO;
import com.br.ceeppoc.model.Nota;
import com.br.ceeppoc.ui.recyclerview.adapter.ListNotasAdapter;

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

        TextView insereNotaBotao = findViewById(R.id.lista_notas_insere_nota);
        insereNotaBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iniciaFormularioNota =
                        new Intent(ListaNotasActivity.this,
                                FormularioNotaActivity.class);
                startActivity(iniciaFormularioNota);
            }
        });

        listaNotas.setAdapter(new ListNotasAdapter(this, todaNotas));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listaNotas.setLayoutManager(layoutManager);
    }
}