package com.example.raxabizze.kotlinmvvmexample.di.module.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.raxabizze.kotlinmvvmexample.di.annotation.base.ViewModelKey
import com.example.raxabizze.kotlinmvvmexample.ui.main.MainViewModel
import com.example.raxabizze.kotlinmvvmexample.utils.factory.AppViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainActivityViewModel(mainActivityViewModel: MainViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}
