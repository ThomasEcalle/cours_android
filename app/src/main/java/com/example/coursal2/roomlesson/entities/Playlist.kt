package com.example.coursal2.roomlesson.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Playlist(
  @PrimaryKey val playlistId: Long,
  val userCreatorId: Long,
  val playlistName: String
)