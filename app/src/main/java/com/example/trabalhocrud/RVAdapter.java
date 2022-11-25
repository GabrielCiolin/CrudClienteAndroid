package com.example.trabalhocrud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalhocrud.Model.Pessoa;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.nome.setText(pessoas.get(i).nome);
        personViewHolder.email.setText(pessoas.get(i).email);
        personViewHolder.celular.setText(pessoas.get(i).telefone);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nome;
        TextView email;
        TextView celular;


        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            nome = (TextView)itemView.findViewById(R.id.nome);
            email = (TextView)itemView.findViewById(R.id.email);
            celular = (TextView)itemView.findViewById(R.id.celular);

        }
        List<Pessoa> pessoas;



        public int getItemCount() {
            return this.pessoas.size();
        }

    }

    RVAdapter(List<Pessoa> pessoas){
        pessoas = pessoas;
    }


 
}