package com.example.coursal1.room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal1.R
import com.example.coursal1.room.entities.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomActivity : AppCompatActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_room)

    /*insertUsers(
      listOf(
        User(firstName = "Michael", lastName = "Jordan"),
        User(firstName = "Steve", lastName = "Jobs"),
        User(firstName = "Elon", lastName = "Musk")
      )
    )*/

    retrieveUsers { users ->
      users.forEach {
        Log.d("toto", "user found : $it")
      }
    }
  }

  private fun retrieveUsers(callback: (List<User>) -> Unit)
  {
    GlobalScope.launch {
      val database = MyDatabase.instance(applicationContext)
      callback.invoke(database?.userDao()?.getAll() ?: emptyList())
    }
  }

  private fun insertUsers(users: List<User>)
  {
    GlobalScope.launch {
      val database = MyDatabase.instance(applicationContext)
      val ids = database?.userDao()?.insertAll(users)
      //callback.invoke(ids ?: emptyList())
    }
  }
}