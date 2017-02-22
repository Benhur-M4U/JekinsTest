package com.example.mobilemicroservice.cadastro.managers;

import android.support.annotation.NonNull;

import com.example.mobilemicroservice.cadastro.CadastroDataSource;
import com.example.mobilemicroservice.cadastro.client.UserObj;

import rx.Observable;

/**
 * Created by benhur.souza on 15/02/2017.
 */

public class CadastroRepository implements CadastroDataSource {

    private CadastroDataSource remoteRepository;
    private CadastroDataSource localRepository;

    public CadastroRepository(
            @NonNull CadastroDataSource remoteRepository,
            @NonNull CadastroDataSource localRepository){

        this.remoteRepository = remoteRepository;
        this.localRepository = localRepository;
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
        return null;
    }

    @Override
    public Observable<UserObj> getUser() {
        return Observable.merge(localRepository.getUser(), remoteRepository.getUser());
    }
}
