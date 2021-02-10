package com.example.coursal1.viewmodel

import com.example.coursal1.webservicies.User


enum class Status
{
  SUCCESS, ERROR, LOADING
}

data class UsersModel(
  val users: List<User> = emptyList(),
  val errorMessage: String = "",
  val status: Status
)