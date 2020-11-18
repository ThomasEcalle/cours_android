package com.example.coursal2.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal2.R

class FirstFragmentActivity : AppCompatActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_first_fragment)
    supportFragmentManager
      .beginTransaction()
      .replace(R.id.container, BlankFragment.newInstance("toto", "tata"))
      .commitNow()
  }
}