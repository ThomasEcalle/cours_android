package com.example.coursal2.roomlesson.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.coursal2.roomlesson.entities.User

@Dao
interface UserDao
{
  @Insert
  fun insert(user: User): Long?

  @Query("DELETE FROM user")
  fun deleteAll()
}