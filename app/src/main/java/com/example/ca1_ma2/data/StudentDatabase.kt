package com.example.ca1_ma2.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Student::class],
    version = 1,
    exportSchema = false
)
abstract class StudentDatabase : RoomDatabase(){
    abstract fun StudentDao(): StudentDao
}

