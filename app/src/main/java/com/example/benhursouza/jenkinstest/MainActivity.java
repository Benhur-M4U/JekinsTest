package com.example.benhursouza.jenkinstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soma(2,3);
        diminuir(2,4);
    }


    private int soma(int a, int b) {
        return a + b;
    }

    private int diminuir(int a, int b){
        return a + b;
    }


}