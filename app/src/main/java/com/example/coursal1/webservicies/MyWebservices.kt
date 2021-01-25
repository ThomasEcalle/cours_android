package com.example.coursal1.webservicies

import retrofit2.Call
import retrofit2.http.GET

interface MyWebservices
{
  @GET("json/get/VkFy1Vfyq?delay=2000")
  fun retrieveUser(): Call<User>

  @GET("json/get/NyC4XoSvu?delay=2000")
  fun retrieveAllUsers(): Call<List<User>>
}