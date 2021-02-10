package com.example.coursal2.roomlesson.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
  @PrimaryKey(autoGenerate = true) val uid: Long? = null,
  @ColumnInfo(name = "first_name") val firstName: String?,
  @ColumnInfo(name = "last_name") val lastName: String?,
  @Embedded val address: Address?
)

data class Address(
  val street: String?,
  val state: String?,
  val city: String?,
  @ColumnInfo(name = "post_code") val postCode: Int
)