package com.sarahehabm.orangerx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import rx.Observable;
import rx.Subscriber;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Observable<String> myObservable;
    private Subscriber<String> mySubscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        Log.v(TAG, "call");

                        sub.onNext("Hello, world!");
                        sub.onCompleted();
                    }
                }
        );

        mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                Log.v(TAG, "onNext");
                System.out.println(s);
            }

            @Override
            public void onCompleted() {
                Log.v(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.v(TAG, "onError");
            }
        };

    }

    public void onButtonClick(View view) {

        myObservable.subscribe(mySubscriber);
    }
}
