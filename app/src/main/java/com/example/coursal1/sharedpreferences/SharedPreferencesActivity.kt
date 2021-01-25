package com.example.coursal1.sharedpreferences

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal1.R
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity()
{
  companion object
  {
    const val PREFERENCES_FILE_NAME = "PREFERENCES_FILE_NAME"
    const val LAST_VALUE_KEY = "lastValueKey"
  }

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_shared_preferences)

    val lastValue = getLastValue()

    lastValue?.let {
      myEditText?.setText(it)
    }

    validate?.setOnClickListener {
      storeValue(myEditText?.text.toString())
    }
  }

  private fun storeValue(value: String)
  {
    getMyPreferences().edit().putString(LAST_VALUE_KEY, value).apply()
  }

  private fun getLastValue() = getMyPreferences().getString(LAST_VALUE_KEY, null)

  private fun getMyPreferences() = getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
}