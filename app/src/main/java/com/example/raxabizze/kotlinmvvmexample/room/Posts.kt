package com.example.raxabizze.kotlinmvvmexample.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "posts_table")
data class Posts(@ColumnInfo(name = "userId") var userId: Int = -1,
                 @ColumnInfo(name = "id") var id: String = "",
                 @ColumnInfo(name = "title") var title: String = "") {

    @ColumnInfo(name = "keyid")
    @PrimaryKey(autoGenerate = true) var keyid: Int = 0
}