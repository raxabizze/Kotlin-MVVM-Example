package com.example.raxabizze.kotlinmvvmexample.room

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration
import android.support.annotation.NonNull


@Database(entities = arrayOf(Posts::class), version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    // Update Room 1 => 2
    companion object {
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(@NonNull database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE posts_table " + "ADD COLUMN body TEXT NOT NULL DEFAULT ''")
            }
        }
    }


    //    abstract val postsDao: PostsDao
    abstract fun postsDao(): PostsDao
}