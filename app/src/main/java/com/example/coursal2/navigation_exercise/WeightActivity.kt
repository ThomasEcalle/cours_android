package com.example.coursal2.navigation_exercise

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal2.R
import kotlinx.android.synthetic.main.activity_weight.*

class WeightActivity : AppCompatActivity(), View.OnClickListener
{
  companion object
  {
    val NAME_PARAMETER_KEY = "nameParameterKey"
    val RESULT_KEY = "resultKey"
  }

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_weight)

    intent?.getStringExtra(NAME_PARAMETER_KEY)?.let {
      nameTextView?.text = it
    }

    validateWeight?.setOnClickListener(this)
  }

  override fun onClick(p0: View?)
  {
    val weight = weightEditText?.text.toString()
    val resultIntent = Intent()
    resultIntent.putExtra(RESULT_KEY, weight)
    setResult(NameActivity.REQUEST_CODE, resultIntent)
    finish()
  }
}