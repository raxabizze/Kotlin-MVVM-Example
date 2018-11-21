package com.example.raxabizze.kotlinmvvmexample.di.module.base

import android.content.Context
import com.example.raxabizze.kotlinmvvmexample.utils.api.PostApi
import com.example.raxabizze.kotlinmvvmexample.utils.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule
{
    @Provides
    fun providePostApi(@Named("PostApi") retrofit: Retrofit) = retrofit.create(PostApi::class.java)

    @Provides
    @Singleton
    @Named("PostApi")
    internal fun providePostApiRetrofit(@Named("PostApiURL") url: String,
                                        @Named("PostApiClient") okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


    @Singleton
    @Provides
    @Named("PostApiURL")
    internal fun providePostApiURL(context: Context) = BASE_URL //or context.resources.getString(R.string.api)

    @Provides
    @Singleton
    @Named("PostApiClient")
    internal fun providePostApiOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor,
                                              @Named("PostApiHeader") interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(interceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()


    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    @Provides
    @Singleton
    @Named("PostApiHeader")
    internal fun providePostApiHeader(): Interceptor =
        Interceptor { chain ->
            chain.proceed(chain.request().newBuilder()
                    .header("Content-Type", "application/json")
                    .build())

        }
}