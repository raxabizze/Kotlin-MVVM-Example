package com.example.raxabizze.kotlinmvvmexample

import android.app.Activity
import android.app.Application
import android.app.Service
import com.example.raxabizze.kotlinmvvmexample.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector, HasServiceInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingServiceInjector: DispatchingAndroidInjector<Service>

//    @Inject
//    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>


    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
    override fun serviceInjector(): AndroidInjector<Service> = dispatchingServiceInjector

//    fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}