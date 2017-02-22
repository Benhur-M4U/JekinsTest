package com.example.mobilemicroservice.cadastro.client.api;

import android.support.annotation.NonNull;

import com.example.mobilemicroservice.cadastro.CadastroDataSource;
import com.example.mobilemicroservice.cadastro.client.UserObj;

import rx.Observable;

/**
 * Created by benhur.souza on 15/02/2017.
 */

public class CadastroRemoteRepository implements CadastroDataSource {

    private static CadastroRemoteRepository instance;

    public static CadastroRemoteRepository getInstance(){
        if(instance == null){
            instance = new CadastroRemoteRepository();
        }

        return instance;
    }

    @Override
    public String getNome() {
        return null;
    }

    @Override
    public String getEndereco() {
        return null;
    }

    @Override
    public Observable<UserObj> saveUser(@NonNull UserObj user) {
        return CadastroServices.getInstance().saveUser(user);
    }

    @Override
    public Observable<UserObj> getUser() {
        return null;
    }
}
