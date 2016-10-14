package com.ctrip.tzduan.rxandroid_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.Observable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onNext();
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
}
