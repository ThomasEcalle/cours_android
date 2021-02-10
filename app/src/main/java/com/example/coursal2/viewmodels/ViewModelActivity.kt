package com.example.coursal2.viewmodels

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.coursal2.R
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_view_model)

    val myViewModel: MyViewModel by viewModels()

    myViewModel.loadUsers()
    myViewModel.usersModel.observe(this, Observer<UsersModel> { usersModel ->
      when (usersModel.status)
      {
        Status.LOADING -> result.text = "LOADING"
        Status.ERROR -> result.text = "ERROR"
        Status.SUCCESS ->
        {
          val users = usersModel.users
          result.text = users.toString()
        }
      }
    })

  }
}