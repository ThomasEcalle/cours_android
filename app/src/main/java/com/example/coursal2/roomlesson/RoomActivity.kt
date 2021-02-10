package com.example.coursal2.roomlesson

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal2.R
import com.example.coursal2.roomlesson.entities.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomActivity : AppCompatActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_room2)

    /*insertUsers(
      listOf(
        User(firstName = "Michael", lastName = "Jordan"),
        User(firstName = "Steve", lastName = "Jobs"),
        User(firstName = "Elon", lastName = "Musk")
      )
    ) { ids ->

      Log.d("toto", "IDS = $ids")

    }*/

    retrieveUsers { users ->
      Log.d("toto", users.toString())
    }
  }

  private fun retrieveUsers(callback: (List<User>) -> Unit)
  {
    GlobalScope.launch {
      val database = MyDatabase.instance(applicationContext)
      callback.invoke(database?.userDao()?.getAll() ?: emptyList())
    }
  }

  private fun insertUsers(users: List<User>, callback: (List<Long>) -> Unit)
  {
    GlobalScope.launch {
      val database = MyDatabase.instance(applicationContext)
      val ids = database?.userDao()?.insertAll(users)
      callback.invoke(ids ?: emptyList())
    }
  }
}