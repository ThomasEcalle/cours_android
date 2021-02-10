package com.example.coursal1.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coursal1.room.dao.UserDao
import com.example.coursal1.room.entities.Library
import com.example.coursal1.room.entities.User

@Database(entities = [User::class, Library::class], version = 3)
abstract class MyDatabase : RoomDatabase()
{
  abstract fun userDao(): UserDao

  companion object
  {

    private var database: MyDatabase? = null

    fun instance(context: Context): MyDatabase?
    {
      if (database != null)
      {
        return database
      }

      database = Room.databaseBuilder(
        context,
        MyDatabase::class.java, "database-name"
      )
        .fallbackToDestructiveMigration()
        .build()

      return database
    }
  }
}