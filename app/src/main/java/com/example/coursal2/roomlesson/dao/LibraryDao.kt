package com.example.coursal2.roomlesson.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.coursal2.roomlesson.entities.Library

@Dao
interface LibraryDao
{
  @Insert
  fun insert(library: Library): Long

  @Insert
  fun insertAll(libraries: List<Library>): List<Long>
}