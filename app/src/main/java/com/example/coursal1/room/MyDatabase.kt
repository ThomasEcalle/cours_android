package com.example.coursal1.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coursal1.room.dao.UserDao
import com.example.coursal1.room.entities.User

@Database(entities = [User::class], version = 1)
abstract class MyDatabase : RoomDatabase()
{
  abstract fun userDao(): UserDao

}