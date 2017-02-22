package com.example.mobilemicroservice.cadastro.client.api;

import com.example.mobilemicroservice.cadastro.client.UserObj;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by benhur.souza on 15/02/2017.
 */

public interface CadastroAPI {

    @GET("test?")
    Observable<UserObj> getTest(@Query("q") String city);
}
