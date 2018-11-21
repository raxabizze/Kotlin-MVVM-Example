package com.example.raxabizze.kotlinmvvmexample.utils.rxjava.scheduler

import io.reactivex.schedulers.Schedulers
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers


class SchedulerProviderImp : SchedulerProvider {

    override fun ui(): Scheduler =
        AndroidSchedulers.mainThread()


    override fun computation(): Scheduler =
        Schedulers.computation()


    override fun io(): Scheduler =
        Schedulers.io()

}