package com.example.aluno.avaliacao.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.aluno.avaliacao.R;
import com.example.aluno.avaliacao.adapters.UsuarioAdapter;
import com.example.aluno.avaliacao.bootstrap.APIClient;
import com.example.aluno.avaliacao.model.User;
import com.example.aluno.avaliacao.resources.UserResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends DefaultActivity {

    UserResource apiUserResourse;
    List<HashMap<String,String>> colecao = new ArrayList<HashMap<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        apiUserResourse = APIClient.getClient().create(UserResource.class);

        Call<List<User>> get = apiUserResourse.get();

        get.enqueue(new Callback<List<User>>() {

            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                minhaLista = findViewById(R.id.minhaLista);

                UsuarioAdapter usuarioAdapter = new UsuarioAdapter(getApplicationContext(), listUser);
                minhaLista.setAdapter(usuarioAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }


    public void adicionar(View view) {

        txtId = findViewById(R.id.txtId);
        txtNome = findViewById(R.id.txtEmail);
        txtUserName = findViewById(R.id.txtUserName);
        txtEmail = findViewById(R.id.txtEmail);

        txtPhone = findViewById(R.id.txtPhone);
        txtWebSite = findViewById(R.id.txtWebSite);


        Integer id;
        String name, userName, email, phone, website;

        id = Integer.parseInt(txtId.getText().toString());
        name = txtNome.getText().toString();
        userName = txtUserName.getText().toString();
        email = txtEmail.getText().toString();
        phone = txtEmail.getText().toString();
        website = txtWebSite.getText().toString();


        User user = new User(id, name, userName, email,phone,website);

        listUser.add(user);
        Call<User> post = apiUserResourse.post(user);
        post.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User u = response.body();
                Toast.makeText(getApplicationContext(),
                        u.toString(),
                        Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });



    }
}







