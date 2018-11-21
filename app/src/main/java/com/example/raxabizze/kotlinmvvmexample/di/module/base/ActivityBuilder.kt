package com.example.raxabizze.kotlinmvvmexample.di.module.base

import com.example.raxabizze.kotlinmvvmexample.di.annotation.LoginScoped
import com.example.raxabizze.kotlinmvvmexample.di.module.LoginModule
import com.example.raxabizze.kotlinmvvmexample.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @LoginScoped
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun bindLoginActivity (): LoginActivity
}