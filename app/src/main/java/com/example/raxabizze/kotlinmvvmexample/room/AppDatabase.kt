package com.example.raxabizze.kotlinmvvmexample.room

import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


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