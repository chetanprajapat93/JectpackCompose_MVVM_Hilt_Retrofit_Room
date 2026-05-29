package com.asite.demopreparation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver


class CompositeDisposableActivity : AppCompatActivity() {
    var mCompositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mObservable = getAnimalsObservable()
        var mObserverNormal = getAnimalsObserver()
        var mObserverAllCaps = getAnimalsAllCapsObserver()
        var mObserverNotes = getAnimalsNotesObserver()

        mCompositeDisposable.add(
            mObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(mObserverNormal)
        )

        mCompositeDisposable.add(
            mObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(Predicate<String>{
                    s -> s.lowercase().startsWith("a")
                })
                .map {
                    it.uppercase()
                }
                .subscribeWith(mObserverAllCaps)
        )

        mCompositeDisposable.add(
            getNotesObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(object : Function<Note, Note> {
                    override fun apply(t: Note): Note {
                        t.mNote = t.mNote.uppercase()
                        return t
                    }
                }).subscribeWith(mObserverNotes)
        )

    }

    fun getAnimalsObserver(): DisposableObserver<String>{
        return object : DisposableObserver<String>() {

            override fun onNext(t: String) {
                Log.e("Logs Normal ", " onNext $t")
            }

            override fun onError(e: Throwable) {
                Log.e("Logs Normal ", " onError")
            }

            override fun onComplete() {
                Log.e("Logs Normal ", " onComplete")
            }

        }
    }

    fun getAnimalsAllCapsObserver(): DisposableObserver<String>{
        return object : DisposableObserver<String>(){
            override fun onNext(t: String) {
                Log.e("Logs All Caps ", " onNext $t")
            }

            override fun onError(e: Throwable) {
                Log.e("Logs All Caps ", " onError")
            }

            override fun onComplete() {
                Log.e("Logs All Caps ", " onComplete")
            }

        }
    }

    fun getAnimalsObservable(): Observable<String>{
        return Observable.fromArray(
            "Ant", "Ape",
            "Bat", "Bee", "Bear", "Butterfly",
            "Cat", "Crab", "Cod",
            "Dog", "Dove",
            "Fox", "Frog",
            "Tiger", "Lion", "Monkey", "Rat",
            "Horse", "Takir", "Cow", "Buffalo", "Tang")
    }

    fun getNotesObservable(): Observable<Note>{
        val mNotesList = prepareNotes()
        return Observable.create(object : ObservableOnSubscribe<Note> {
            override fun subscribe(emitter: ObservableEmitter<Note>) {
                for (note in mNotesList) {
                    if (!emitter.isDisposed) {
                        emitter.onNext(note!!)
                    }
                }
                if(!emitter.isDisposed){
                    emitter.onComplete()
                }
            }
        })
    }

    fun prepareNotes(): ArrayList<Note>{
        var noteList = java.util.ArrayList<Note>()
        noteList.add(Note(1, "First"))
        noteList.add(Note(2, "Two"))
        noteList.add(Note(3, "Three"))
        noteList.add(Note(4, "FOur"))
        noteList.add(Note(5, "Five"))
        return noteList
    }

    fun getAnimalsNotesObserver(): DisposableObserver<Note>{
        return object : DisposableObserver<Note>(){
            override fun onNext(t: Note) {
                Log.e("Logs Notes ", " onNext $t")
            }

            override fun onError(e: Throwable) {
                Log.e("Logs Notes ", " onError ")
            }

            override fun onComplete() {
                Log.e("Logs Notes ", " onComplete ")
            }
        }
    }

    override fun onDestroy() {
        mCompositeDisposable.clear()
        super.onDestroy()
    }
}