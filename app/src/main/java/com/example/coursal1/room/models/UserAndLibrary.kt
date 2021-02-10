package com.example.coursal1.room.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.coursal1.room.entities.Library
import com.example.coursal1.room.entities.User

data class UserAndLibrary(
  @Embedded val user: User,
  @Relation(
    parentColumn = "uid",
    entityColumn = "userOwnerId"
  )
  val library: Library
)