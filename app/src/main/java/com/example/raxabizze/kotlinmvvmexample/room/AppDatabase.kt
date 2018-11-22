package com.example.raxabizze.kotlinmvvmexample.room

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database


@Database(entities = arrayOf(Posts::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
//    abstract val postsDao: PostsDao
    abstract fun postsDao(): PostsDao
}