package com.example.coursal2

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_life_cycle.*

class LifeCycleActivity : AppCompatActivity(), View.OnClickListener
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_life_cycle)
    Log.d(LifeCycleActivity::class.simpleName, "onCreate")
    validate?.setOnClickListener(this)

    savedInstanceState?.getString("toto")?.let { resultLastValue ->
      result?.text = resultLastValue
    }
  }

  override fun onStart()
  {
    super.onStart()
    Log.d(LifeCycleActivity::class.simpleName, "onStart")
  }

  override fun onResume()
  {
    super.onResume()
    Log.d(LifeCycleActivity::class.simpleName, "onResume")
  }

  override fun onPause()
  {
    super.onPause()
    Log.d(LifeCycleActivity::class.simpleName, "onPause")
  }

  override fun onStop()
  {
    super.onStop()
    Log.d(LifeCycleActivity::class.simpleName, "onStop")
  }

  override fun onSaveInstanceState(outState: Bundle)
  {
    outState.putString("toto", result?.text?.toString())
    super.onSaveInstanceState(outState)
  }

  override fun onDestroy()
  {
    super.onDestroy()
    Log.d(LifeCycleActivity::class.simpleName, "onDestroy")
  }

  override fun onClick(view: View?)
  {
    result?.text = editText?.text
  }
}