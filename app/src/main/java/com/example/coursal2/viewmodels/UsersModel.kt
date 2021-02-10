package com.example.coursal2.viewmodels

import com.example.coursal2.webservices.User

enum class Status
{
  SUCCESS, ERROR, LOADING
}

data class UsersModel(
  val status: Status,
  val users: List<User>? = null,
  val errorMessage: String? = null
)