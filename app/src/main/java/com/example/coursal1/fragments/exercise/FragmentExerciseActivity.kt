package com.example.coursal1.fragments.exercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal1.R

class FragmentExerciseActivity : AppCompatActivity(), OnNameSelected
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_fragment_exercise)
    supportFragmentManager
      .beginTransaction()
      .replace(R.id.bottomContainer, NameFragment.newInstance(this))
      .commitNow()
  }

  override fun onNameSelected(value: String)
  {
    supportFragmentManager
      .beginTransaction()
      .replace(R.id.topContainer, NameDisplayerFragment.newInstance(value))
      .commitNow()
  }
}