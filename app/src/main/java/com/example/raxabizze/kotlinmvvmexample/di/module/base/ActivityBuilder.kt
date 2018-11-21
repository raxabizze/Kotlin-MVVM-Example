package com.example.raxabizze.kotlinmvvmexample.di.module.base

import com.example.raxabizze.kotlinmvvmexample.di.annotation.MainScoped
import com.example.raxabizze.kotlinmvvmexample.di.module.MainModule
import com.example.raxabizze.kotlinmvvmexample.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @MainScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity (): MainActivity
}