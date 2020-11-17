package com.example.coursal1.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal1.R

class SimpleFragmentActivity : AppCompatActivity(), DummyInterface
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_simple_fragment)
    supportFragmentManager
      .beginTransaction()
      .replace(R.id.container, BlankFragment.newInstance("param 1", "param 2", this))
      .commitNow()
  }

  override fun myDummyMethod(value: String?)
  {
    supportFragmentManager
        .beginTransaction()
      .replace(R.id.container, BFragment.newInstance())
      .commitNow()
  }
}