package com.example.coursal2.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal2.R
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity()
{

  companion object
  {
    val RESULT_KEY = "resultKey"
    val PREFERENCES_FILE_NAME = "preferencestoto"
  }

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_shared_preferences)

    val previousResult = getPreviousResult()
    if (previousResult != null)
    {
      myEditText?.setText(previousResult)
    }

    validate?.setOnClickListener {
      storeResult(myEditText?.text.toString())
    }

  }

  private fun getPreviousResult(): String?
  {
    val preferences = getMyPreferences()
    return preferences.getString(RESULT_KEY, null)
  }

  private fun storeResult(value: String)
  {
    val preferences = getMyPreferences()
    preferences.edit().putString(RESULT_KEY, value).apply()
  }

  private fun getMyPreferences() = getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
}