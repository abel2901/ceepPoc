package com.br.ceeppoc.ui.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.ceeppoc.R;
import com.br.ceeppoc.model.Nota;

import org.w3c.dom.Text;

import java.util.List;

public class ListNotasAdapter extends RecyclerView.Adapter<ListNotasAdapter.NotaViewHolder> {

    private final List<Nota> notas;
    private Context context;

    public ListNotasAdapter(Context context, List<Nota> notas) {
        this.context = context;
        this.notas = notas;
    }

    @NonNull
    @Override
    public ListNotasAdapter.NotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_nota, parent, false);
        return new NotaViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(ListNotasAdapter.NotaViewHolder holder, int position) {
        Nota nota = notas.get(position);
        holder.vincula(nota);
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    class NotaViewHolder extends RecyclerView.ViewHolder {

        private final TextView titulo;
        private final TextView descricao;

        public NotaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.item_nota_titulo);
            descricao = itemView.findViewById(R.id.item_nota_descricao);
        }

        public void vincula(Nota nota) {
            titulo.setText(nota.getTitulo());
            descricao.setText(nota.getDescricao());
        }
    }
}
