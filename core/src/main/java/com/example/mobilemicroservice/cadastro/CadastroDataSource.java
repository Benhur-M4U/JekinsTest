package com.example.mobilemicroservice.cadastro;

import android.support.annotation.NonNull;

import com.example.mobilemicroservice.cadastro.client.UserObj;

import rx.Observable;

/**
 * Created by benhur.souza on 15/02/2017.
 */

public interface CadastroDataSource {

    String getNome();
    String getEndereco();
    Observable<UserObj> saveUser(@NonNull UserObj user);
    Observable<UserObj> getUser();
}
