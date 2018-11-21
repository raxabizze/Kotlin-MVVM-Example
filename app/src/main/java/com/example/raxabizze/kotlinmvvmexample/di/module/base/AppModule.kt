package com.example.raxabizze.kotlinmvvmexample.di.module.base

import android.content.Context
import com.example.raxabizze.kotlinmvvmexample.App
import com.example.raxabizze.kotlinmvvmexample.utils.rxjava.scheduler.SchedulerProvider
import com.example.raxabizze.kotlinmvvmexample.utils.rxjava.scheduler.SchedulerProviderImp
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule
{
    @Provides
    @Singleton
    fun provideApplication(app : App) : Context = app

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = SchedulerProviderImp()


}