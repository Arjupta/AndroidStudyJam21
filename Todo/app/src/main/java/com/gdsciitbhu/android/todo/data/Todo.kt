package com.gdsciitbhu.android.todo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val data: String
)
