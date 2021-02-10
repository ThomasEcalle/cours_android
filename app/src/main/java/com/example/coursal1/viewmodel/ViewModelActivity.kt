package com.example.coursal1.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.coursal1.R
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
        Status.LOADING -> myTextView.text = "LOADING"
        Status.ERROR -> myTextView.text = "ERROR"
        Status.SUCCESS ->
        {
          val users = usersModel.users
          myTextView.text = users.toString()
        }
      }
    })

  }
}