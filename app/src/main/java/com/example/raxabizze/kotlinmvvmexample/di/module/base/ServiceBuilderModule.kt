package com.example.raxabizze.kotlinmvvmexample.di.module.base

import com.example.raxabizze.kotlinmvvmexample.service.MainIntentService
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ServiceBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainIntentService(): MainIntentService

}