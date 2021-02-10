package com.example.coursal2.roomlesson.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Library(
  @PrimaryKey val libraryId: Long,
  val userOwnerId: Long
)