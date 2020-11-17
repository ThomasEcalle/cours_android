package com.example.coursal1.navigation.exercise

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal1.R
import kotlinx.android.synthetic.main.activity_weight.*

class WeightActivity : AppCompatActivity()
{
  companion object
  {
    val NAME_KEY = "nameKey"
    val WEIGHT_KEY = "weightKey"
  }

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_weight)

    intent?.getStringExtra(NAME_KEY)?.let {
      name?.text = it
    }

    validateWeight?.setOnClickListener {
      val resultIntent = Intent()
      resultIntent.putExtra(WEIGHT_KEY, weightEditText?.text?.toString())
      setResult(NameActivity.WEIGHT_RESULT_CODE, resultIntent)
      finish()
    }
  }
}