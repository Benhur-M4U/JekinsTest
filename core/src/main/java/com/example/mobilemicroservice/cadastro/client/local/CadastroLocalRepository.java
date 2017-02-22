package com.example.mobilemicroservice.cadastro.client.local;

import android.support.annotation.NonNull;

import com.example.mobilemicroservice.cadastro.CadastroDataSource;
import com.example.mobilemicroservice.cadastro.client.UserObj;
import com.example.mobilemicroservice.cadastro.client.api.CadastroRemoteRepository;

import rx.Observable;

/**
 * Created by benhur.souza on 15/02/2017.
 */

public class CadastroLocalRepository implements CadastroDataSource {

    private static CadastroLocalRepository instance;

    public static CadastroLocalRepository getInstance(){
        if(instance == null){
            instance = new CadastroLocalRepository();
        }

        return instance;
    }

    @Override
    public String getNome() {
        return "Benhur";
    }

    @Override
    public String getEndereco() {
        return null;
    }

    @Override
    public Observable<UserObj> saveUser(@NonNull UserObj user) {
        return null;
    }

    @Override
    public Observable<UserObj> getUser() {
        UserObj obj = new UserObj();
        obj.nome = "Nome";
        return null;
    }
}
