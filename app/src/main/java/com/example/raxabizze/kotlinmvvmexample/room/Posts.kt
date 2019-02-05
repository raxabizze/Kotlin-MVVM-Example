package com.example.raxabizze.kotlinmvvmexample.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "posts_table")
data class Posts(@PrimaryKey(autoGenerate = true) var keyId: Int? = 0) : Serializable {

    @ColumnInfo(name = "userId") var userId: Int = -1

    @ColumnInfo(name = "id") var id: String = ""

    @ColumnInfo(name = "title") var title: String = ""

    @ColumnInfo(name = "body") var body: String = ""

    @Ignore
    constructor() : this(null)
}