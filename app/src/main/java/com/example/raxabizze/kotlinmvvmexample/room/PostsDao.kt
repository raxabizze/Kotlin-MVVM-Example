package com.example.raxabizze.kotlinmvvmexample.room

import android.arch.persistence.room.*


@Dao
interface PostsDao {

    @get:Query("SELECT * FROM posts_table")
    val allPosts: List<Posts>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(vararg postss: Posts)

    @Update
    fun updatePosts(vararg postss: Posts)

    @Delete
    fun deletePosts(vararg postss: Posts)
}