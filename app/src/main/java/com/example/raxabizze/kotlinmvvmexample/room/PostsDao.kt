package com.example.raxabizze.kotlinmvvmexample.room

import androidx.room.*
import io.reactivex.Flowable


@Dao
interface PostsDao {

    @get:Query("SELECT * FROM posts_table")
    val allPosts: Flowable<List<Posts>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(vararg postss: Posts)

    @Update
    fun updatePosts(vararg postss: Posts)

    @Delete
    fun deletePosts(vararg postss: Posts)
}