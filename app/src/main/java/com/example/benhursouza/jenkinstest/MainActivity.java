package com.example.benhursouza.jenkinstest;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import io.fabric.sdk.android.Fabric;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {

    //    private int a;
    public String result;
    private TextView txt;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        init();

        final EditText edt1 = (EditText) findViewById(R.id.edt1);
        final EditText edt2 = (EditText) findViewById(R.id.edt2);

        Subscription subscription = null;
        Observable<CharSequence> o1 = RxTextView.textChanges(edt1);
        Observable<CharSequence> o2 = RxTextView.textChanges(edt2);

        Observable.combineLatest(o1, o2,
                new Func2<CharSequence, CharSequence, Boolean>() {
                    @Override
                    public Boolean call(CharSequence newEmail, CharSequence newPassword) {
                        //here you can validate the edit text
                        boolean emailValid = !TextUtils.isEmpty(newEmail)
                                && android.util.Patterns.EMAIL_ADDRESS.matcher(newEmail).matches();
                        if (!emailValid) {
                            edt1.setError("Invalid Email");
                        }
                        boolean passValid = !TextUtils.isEmpty(newPassword)
                                && newPassword.length() > 6;
                        if (!passValid) {
                            edt2.setError("invalid password");
                        }


                        return emailValid && passValid;

                    }
                }).subscribe(new Observer<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (aBoolean) {
                    //here you can enable your button or what ever you want.
                    btn.setEnabled(true);
                    txt.setText("Pronto");

                } else {
                    btn.setEnabled(false);
                }

            }
        });

    }

    private void init() {
        txt = (TextView) findViewById(R.id.txt_nome);
        btn = ((Button) findViewById(R.id.btn));

        Log.i("teste", somar2numeros(2, 4));


        RxView.clicks(btn).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                // do some work here
                result = soma(2, 3);
                txt.setText(result);
            }
        });

    }

    //Test
    private String soma(int a, int b) {
        return String.valueOf(a + b);
    }

    public String somar2numeros(int a, int b) {
        return String.valueOf(a + b);
    }


}