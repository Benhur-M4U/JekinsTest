package com.example.mobilemicroservice;

import android.util.Log;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by benhur.souza on 14/02/2017.
 */
public class TestServices {

    protected Retrofit retrofit;

    public TestServices(){
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .build();

        Log.e("Estou","Aqui");
    }


}
