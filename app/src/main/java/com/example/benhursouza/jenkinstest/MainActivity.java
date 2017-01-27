package com.example.benhursouza.jenkinstest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int a;
    public String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txt = (TextView)findViewById(R.id.txt_nome);


        Button btn = ((Button)findViewById(R.id.btn));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                txt.setText(result.toString());
                result = soma(2,3);
                txt.setText(result.toString());
            }
        });

        somar2numeros(2,4);
    }


    private String soma(int a, int b) {
        return String.valueOf(a - b);
    }

    public int somar2numeros(int a, int b){
        return a + b;
    }


}