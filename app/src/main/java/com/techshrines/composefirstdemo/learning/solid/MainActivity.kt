package com.asite.demopreparation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.functions.Predicate;


class MainActivity : AppCompatActivity() {
    var mDisposable: Disposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mObservable = getAnimalsObservable()
        var mObserver = getAnimalsObserver()

        mObservable.observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .filter(object : Predicate<String>{
                override fun test(name: String): Boolean {
                    return name.lowercase().startsWith("t")
                }
            })
            .subscribe(mObserver)
    }

    fun getAnimalsObserver(): Observer<String>{
        return object : Observer<String>{
            override fun onSubscribe(d: Disposable) {
                mDisposable = d
                Log.e("Logs ", " onSubscribe")
            }

            override fun onNext(t: String) {
                Log.e("Logs ", " onNext $t")
            }

            override fun onError(e: Throwable) {
                Log.e("Logs ", " onError")
            }

            override fun onComplete() {
                Log.e("Logs ", " onComplete")
            }

        }
    }

    fun getAnimalsObservable(): Observable<String>{
        return Observable.just("Tiger", "Lion", "Monkey", "Rat", "Horse", "Takir", "Cow", "Buffalo", "Tang")
    }

    override fun onDestroy() {
        mDisposable?.dispose()
        super.onDestroy()
    }
}