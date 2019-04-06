package com.example.aluno.avaliacao.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aluno.avaliacao.R;
import com.example.aluno.avaliacao.model.User;

import java.util.List;


public class UsuarioAdapter extends BaseAdapter {


    Context context;
    List<User> colecao;


    public UsuarioAdapter(final Context applicationContext,
                          final List<User> colecao) {
        this.context = applicationContext;
        this.colecao = colecao;

    }


    @Override
    public int getCount() {
        return this.colecao != null ? this.colecao.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return this.colecao.get(i);
    }

    private User parsetItem(int i){
        return this.colecao.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.item_user,
                            viewGroup, false);
        }


        User usuario = parsetItem(i);


        TextView txtId, txtNome, txtUserName,txtEmail,txtPhone,txtWebSite;



        txtId = view.findViewById(R.id.txtId);
        txtNome = view.findViewById(R.id.txtEmail);
        txtUserName = view.findViewById(R.id.txtUserName);
        txtEmail = view.findViewById(R.id.txtEmail);

        txtPhone = view.findViewById(R.id.txtPhone);
        txtWebSite = view.findViewById(R.id.txtWebSite);

        txtId.setText(usuario.getId());
        txtNome.setText(usuario.getName());
        txtUserName.setText(usuario.getUserName());
        txtEmail.setText(usuario.getEmail());
        txtPhone.setText(usuario.getPhone());
        txtWebSite.setText(usuario.getWebsite());


        return view;
    }
}
