package com.example.mobilemicroservice.cadastro.client.api;

import com.example.mobilemicroservice.TestServices;
import com.example.mobilemicroservice.cadastro.client.UserObj;

import javax.inject.Inject;

import dagger.Module;
import rx.Observable;

/**
 * Created by benhur.souza on 15/02/2017.
 */
@Module
public class CadastroServices extends TestServices {

    private static CadastroServices instance;

    public static CadastroServices getInstance(){
        if(instance == null){
            instance = new CadastroServices();
        }

        return instance;
    }

    public Observable<UserObj> saveUser(UserObj user){
        return retrofit.create(CadastroAPI.class).getTest(user.nome);
    }
}
