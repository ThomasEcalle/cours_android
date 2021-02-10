package com.example.coursal2.roomlesson

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coursal2.roomlesson.dao.LibraryDao
import com.example.coursal2.roomlesson.dao.UserDao
import com.example.coursal2.roomlesson.entities.Library
import com.example.coursal2.roomlesson.entities.Playlist
import com.example.coursal2.roomlesson.entities.User

@Database(entities = [User::class, Library::class, Playlist::class], version = 4)
abstract class MyDatabase : RoomDatabase()
{
  abstract fun userDao(): UserDao

  abstract fun libraryDao(): LibraryDao

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