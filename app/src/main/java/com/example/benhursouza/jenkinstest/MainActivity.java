package com.example.benhursouza.jenkinstest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.example.mobilemicroservice.cadastro.client.UserObj;
import com.example.mobilemicroservice.cadastro.client.api.CadastroRemoteRepository;
import com.example.mobilemicroservice.cadastro.client.api.CadastroServices;
import com.example.mobilemicroservice.cadastro.client.local.CadastroLocalRepository;
import com.example.mobilemicroservice.cadastro.managers.CadastroRepository;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import javax.inject.Inject;

import io.fabric.sdk.android.Fabric;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {

    //    private int a;
    public String result;
    private TextView txt;
    private Button btn, btn2;
    private Tracker mTracker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);



        init();

//        initAnalytics();

        reactiveEditText();

//        pushOpenScreenEvent(this, "Entrei na Home");
    }

//    public static void pushOpenScreenEvent(Context context, String screenName) {
//        Log.d("GTMUtils", "GTM pushOpenScreenEvent sent with name: " + screenName);
//        DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();
//        dataLayer.pushEvent("openScreen", DataLayer.mapOf("screenName", screenName));
//    }

    private void reactiveEditText() {
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

    private void initAnalytics() {
        MyApplication application = (MyApplication) getApplication();
        mTracker = application.getDefaultTracker();

        sendAnalytics("Home - JenkinsTest");
    }

    private void sendAnalytics(String text) {
        mTracker.setScreenName(text);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    private void init() {

        txt = (TextView) findViewById(R.id.txt_nome);
        btn = ((Button) findViewById(R.id.btn));

//        Observable<Void> observableBtn1 = RxView.clicks(btn).filter(new Func1<Void, Boolean>() {
//            @Override
//            public Boolean call(Void aVoid) {
//                return null;
//            }
//        });

//        Observable<Void> observableBtn2 = RxView.clicks(btn);
//        Observable.merge(observableBtn1, observableBtn2).subscribe(new Observer<Void>() {
//            @Override
//            public void onCompleted() {
//                Log.e("cliquei","onComplete");
//                txt.setText(soma(2,3));
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e("cliquei","onError - " + e.getMessage());
//
//            }
//
//            @Override
//            public void onNext(Void aVoid) {
//                Log.e("cliquei","onNext");
//            }
//        });

//        Log.i("teste", somar2numeros(2, 4));

        RxView.clicks(btn).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                // do some work here
                result = soma(2, 3);
                txt.setText(result);

//                pushOpenScreenEvent(MainActivity.this, "Cliquei no botao");
//                testRetrofit();

//                mTracker.send(new HitBuilders.EventBuilder()
//                        .setCategory("Action")
//                        .setAction("Somar")
//                        .build());
            }
        });

    }

//    private void testRetrofit(){
//        CadastroRepository repo = new CadastroRepository(
//                CadastroRemoteRepository.getInstance(),
//                CadastroLocalRepository.getInstance()
//        );
//
//        repo.saveUser(new UserObj()).subscribe(new Subscriber<UserObj>() {
//            @Override
//            public void onCompleted() {
//                Log.i("Chaguei","Acabou");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e("Error",e.getMessage());
//            }
//
//            @Override
//            public void onNext(UserObj userObj) {
//                Log.i("Cheguei",userObj.nome);
//            }
//        });

//        service.getTest("test").subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<UserObj>() {
//                               @Override
//                               public void onCompleted() {
//                                   Log.i("Chaguei","Acabou");
//                               }
//
//                               @Override
//                               public void onError(Throwable e) {
//                                   Log.e("Error",e.getMessage());
//
//                               }
//
//                               @Override
//                               public void onNext(UserObj testObj) {
//                                   Log.i("Chaguei",testObj.nome);
//                               }
//                           }
//                );

//    }

    //Test
    private String soma(int a, int b) {
        return String.valueOf(a + b);
    }

    public String somar2numeros(int a, int b) {
        return String.valueOf(a + b);
    }


}