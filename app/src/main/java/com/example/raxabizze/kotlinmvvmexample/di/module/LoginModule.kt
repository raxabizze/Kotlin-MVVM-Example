package com.example.raxabizze.kotlinmvvmexample.di.module

import com.example.raxabizze.kotlinmvvmexample.di.annotation.LoginScoped
import com.example.raxabizze.kotlinmvvmexample.model.Repository
import com.example.raxabizze.kotlinmvvmexample.ui.login.LoginContract
import com.example.raxabizze.kotlinmvvmexample.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
@LoginScoped
class LoginModule {

    @Provides
    internal fun providePresenter(presenter: LoginPresenter<LoginContract.View>)
            : LoginContract.Presenter<LoginContract.View> =  presenter

    @Provides
    internal fun provideRepository() : Repository = Repository("")
}