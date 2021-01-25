package com.example.coursal1.room.dao

import androidx.room.*
import com.example.coursal1.room.entities.User

@Dao
interface UserDao
{
  @Query("SELECT * FROM user")
  fun getAll(): List<User>

  @Query("SELECT * FROM user WHERE uid IN (:userIds)")
  fun loadAllByIds(userIds: IntArray): List<User>

  @Query(
    "SELECT * FROM user " +
        "WHERE first_name LIKE :first" +
        " AND last_name LIKE :last"
  )
  fun findByName(first: String, last: String): List<User>

  @Insert
  fun insertAll(users: List<User>): List<Long>

  @Insert
  fun insert(user: User): Long

  @Update
  fun updateUser(user: User)

  @Delete
  fun delete(user: User)

  @Query("DELETE FROM user")
  fun deleteAll()
}