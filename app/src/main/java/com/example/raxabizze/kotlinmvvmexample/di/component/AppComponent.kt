package com.example.raxabizze.kotlinmvvmexample.di.component

import com.example.raxabizze.kotlinmvvmexample.App
import com.example.raxabizze.kotlinmvvmexample.di.module.base.FragmentBuilder
import com.example.raxabizze.kotlinmvvmexample.di.module.base.ActivityBuilder
import com.example.raxabizze.kotlinmvvmexample.di.module.base.ApiModule
import com.example.raxabizze.kotlinmvvmexample.di.module.base.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        ApiModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,  //remove this line when add a fragment
        ActivityBuilder::class,
        FragmentBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
    fun inject(app: App)
}