package com.example.coursal2.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coursal2.webservices.MyApi
import com.example.coursal2.webservices.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel : ViewModel(), Callback<List<User>>
{
  val usersModel = MutableLiveData<UsersModel>()

  fun loadUsers()
  {
    usersModel.value = UsersModel(status = Status.LOADING)
    MyApi.retrieveAllUsers(this)
  }

  override fun onFailure(call: Call<List<User>>, t: Throwable)
  {
    usersModel.value = UsersModel(status = Status.ERROR, errorMessage = "Erreur : $t")
  }

  override fun onResponse(call: Call<List<User>>, response: Response<List<User>>)
  {
    usersModel.value = UsersModel(status = Status.SUCCESS, users = response.body())
  }

}