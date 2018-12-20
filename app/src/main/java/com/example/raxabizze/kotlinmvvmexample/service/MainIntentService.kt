package com.example.raxabizze.kotlinmvvmexample.service

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log
import com.example.raxabizze.kotlinmvvmexample.utils.rxjava.scheduler.SchedulerProvider
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import plusAssign
import javax.inject.Inject


class MainIntentService : IntentService("MainIntentService") {

    @Inject
    lateinit var schedulerProvider : SchedulerProvider

    @Inject
    lateinit var mCompositeDisposable: CompositeDisposable


    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            ACTION_FOO -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                handleActionFoo(param1, param2)
            }
            ACTION_BAZ -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                //handleActionBaz(param1, param2)
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(param1: String, param2: String) {
        Log.e("Service Start", "ACTION_FOO")

//        mCompositeDisposable += Observable.fromCallable { somthing.execute() }
//                .observeOn(schedulerProvider.ui())
//                .subscribeOn(schedulerProvider.io())
//                .subscribe { onUpdate(it) }
    }


    companion object {
        // TODO: Rename actions, choose action names that describe tasks that this
        // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
        const val ACTION_FOO = "com.example.raxabizze.kotlinmvvmexample.service.action.FOO"
        const val ACTION_BAZ = "com.example.raxabizze.kotlinmvvmexample.service.action.BAZ"

        // TODO: Rename parameters
        const val EXTRA_PARAM1 = "com.example.raxabizze.kotlinmvvmexample.service.extra.PARAM1"
        const val EXTRA_PARAM2 = "com.example.raxabizze.kotlinmvvmexample.service.extra.PARAM2"

    }
}
