package com.ctrip.tzduan.rxandroid_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onNext();
        AndroidSchedulers.mainThread();

        just("duan");
        creat();
    }

    public void onNext(){
        Observable.just("duan").subscribe(
                string -> {
                    Log.i("rxjava", string);
                },
                e -> {

                },
                () -> {
                    Log.i("rxjava", "tianzhang");
                }
        );
    }

    public void just(String a){
        Observable.just(a).subscribe(
                s -> Log.i("rxjava", s),
                e -> {

                },
                () -> Log.i("rxjava", "tianzhang")
        );
    }

    public void creat(){
        Scheduler scheduler = Schedulers.newThread();
        Scheduler androidThread = AndroidSchedulers.mainThread();
        Observable observable = Observable.create(
                subscriber -> Log.i("rxjava", "observable"))
                .subscribeOn(scheduler);

        Observable observable1 = Observable.create(
                subscriber -> Log.i("rxjava", "observable1"))
                .subscribeOn(androidThread);

        Observable observable2 = Observable.create(
                subscriber -> Log.i("rxjava", "observable2"))
                .subscribeOn(scheduler);

        Observable observable3 = Observable.create(
                subscriber -> Log.i("rxjava", "observable3"))
                .subscribeOn(androidThread);

        Observable observable4 = Observable.create(
                subscriber -> Log.i("rxjava", "observable4"))
                .subscribeOn(scheduler);

        Observable observable5 = Observable.create(
                subscriber -> {
                    Log.i("rxjava", "observable5");
                })
                .subscribeOn(androidThread);

        observable.subscribe(
                o -> o.notify()
        );

        Observable<String> observable6 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onStart();
            }
        });

        observable6.subscribe(
                s -> s.notify()
        );
    }

}
