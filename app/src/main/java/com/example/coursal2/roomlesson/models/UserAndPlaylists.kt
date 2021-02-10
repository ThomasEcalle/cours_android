package com.example.coursal2.roomlesson.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.coursal2.roomlesson.entities.Playlist
import com.example.coursal2.roomlesson.entities.User

data class UserWithPlaylists(
  @Embedded val user: User,
  @Relation(
    parentColumn = "uid",
    entityColumn = "userCreatorId"
  )
  val playlists: List<Playlist>
)