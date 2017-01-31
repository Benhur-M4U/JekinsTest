package com.example.benhursouza.jenkinstest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends Activity {

//    private int a;
    public String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        final TextView txt = (TextView)findViewById(R.id.txt_nome);


        Button btn = ((Button)findViewById(R.id.btn));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                txt.setText(result.toString());
                result = soma(2,3);
                txt.setText(result);
            }
        });

        somar2numeros(2,4);
    }


    //Test
    private String soma(int a, int b) {
        return String.valueOf(a + b);
    }

    public int somar2numeros(int a, int b){
        return a + b;
    }


}