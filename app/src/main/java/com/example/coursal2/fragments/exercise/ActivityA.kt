package com.example.coursal2.fragments.exercise

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal2.R

class ActivityA : AppCompatActivity(), OnEmailSelectedListener
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_a)

    supportFragmentManager
      .beginTransaction()
      .replace(R.id.fragment2, EmailFragment.newInstance(this))
      .commitNow()
  }

  override fun onEmailSelected(email: String)
  {
    Log.d("toto", email)
    supportFragmentManager
      .beginTransaction()
      .replace(R.id.fragment1, EmailDisplayerFragment.newInstance(email))
      .commitNow()
  }
}