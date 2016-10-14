package com.ctrip.tzduan.rxandroid_lab.view;

import android.app.Fragment;
import android.util.Log;

import rx.Observable;

/**
 * Created by tzduan on 16/10/14.
 */

public class OnNextFragment extends Fragment {

    public void onNext(){
        Observable.just("duan").subscribe(
                string -> {
                    Log.i("rxjava", string);
                }
        );
    }

}
