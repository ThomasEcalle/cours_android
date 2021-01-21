package com.example.coursal2.webservices

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyApi
{
  private var apiWebServices: ApiWebServices? = null

  init
  {
    val retrofit = Retrofit.Builder()
      .baseUrl("https://next.json-generator.com/api/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()

    apiWebServices = retrofit.create(ApiWebServices::class.java)
  }

  fun retrieveUser(callback: Callback<User>)
  {
    val call = apiWebServices?.retrieveUser()
    call?.enqueue(callback)
  }

  fun retrieveAllUsers(callback: Callback<List<User>>)
  {
    val call = apiWebServices?.retrieveAllUsers()
    call?.enqueue(callback)
  }
}