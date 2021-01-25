package com.example.coursal1.webservicies

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyApi
{
  private var myWebservices: MyWebservices? = null

  init
  {
    val retrofit = Retrofit.Builder()
      .baseUrl("https://next.json-generator.com/api/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()

    myWebservices = retrofit.create(MyWebservices::class.java)
  }

  fun retrieveUser(callback: Callback<User>)
  {
    val call = myWebservices?.retrieveUser()
    call?.enqueue(callback)
  }

  fun retrieveAllUsers(callback: Callback<List<User>>)
  {
    val call = myWebservices?.retrieveAllUsers()
    call?.enqueue(callback)
  }
}