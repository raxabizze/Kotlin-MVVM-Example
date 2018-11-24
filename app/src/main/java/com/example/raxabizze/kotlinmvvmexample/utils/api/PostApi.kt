package com.example.raxabizze.kotlinmvvmexample.utils.api

import com.example.raxabizze.kotlinmvvmexample.room.Posts
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface PostApi {

    @GET
    fun getPosts(@Url url: String): Observable<ArrayList<Posts>>
}