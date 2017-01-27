package com.example.benhursouza.jenkinstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soma(a,3);
        somar2numeros(2,4);
    }


    private int soma(int a, int b) {
        return a + b;
    }

    private int somar2numeros(int a, int b){
        return a + b;
    }


}