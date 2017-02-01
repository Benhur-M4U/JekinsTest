package com.example.benhursouza.jenkinstest

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

import com.crashlytics.android.Crashlytics

import io.fabric.sdk.android.Fabric

class MainActivity : Activity() {

    //    private int a;
    private var result: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_main)

        val txt = findViewById(R.id.txt_nome) as TextView

        val btn = findViewById(R.id.btn) as Button
        btn.setOnClickListener {
            //                txt.setText(result.toString());
            result = soma(2, 3)
            txt.text = result
        }

        Log.i("teste", somar2numeros(2, 4))
    }


    //Test
    private fun soma(a: Int, b: Int): String {
        return (a + b).toString()
    }

    fun somar2numeros(a: Int, b: Int): String {
        return (a + b).toString()
    }


}