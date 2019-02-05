package com.example.raxabizze.kotlinmvvmexample.di.module.base

import android.content.Context
import androidx.room.Room
import com.example.raxabizze.kotlinmvvmexample.App
import com.example.raxabizze.kotlinmvvmexample.room.AppDatabase
import com.example.raxabizze.kotlinmvvmexample.room.AppDatabase.Companion.MIGRATION_1_2
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


    @Singleton
    @Provides fun providesAppDatabase(app : App): AppDatabase =
            Room.databaseBuilder(app, AppDatabase::class.java, "posts-db").addMigrations(MIGRATION_1_2).build()

    @Singleton
    @Provides fun providesToDoDao(database: AppDatabase) = database.postsDao()
}