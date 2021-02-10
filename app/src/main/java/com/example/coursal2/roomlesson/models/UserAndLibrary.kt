package com.example.coursal2.roomlesson.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.coursal2.roomlesson.entities.Library
import com.example.coursal2.roomlesson.entities.User

data class UserAndLibrary(
  @Embedded val user: User,
  @Relation(
    parentColumn = "uid",
    entityColumn = "userOwnerId"
  )
  val library: Library
)