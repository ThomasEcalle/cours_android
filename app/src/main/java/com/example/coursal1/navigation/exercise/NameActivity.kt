package com.example.coursal1.navigation.exercise

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal1.R
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity()
{
  companion object
  {
    val WEIGHT_RESULT_CODE = 32
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
  {
    super.onActivityResult(requestCode, resultCode, data)
    when(requestCode)
    {
      WEIGHT_RESULT_CODE ->
      {
        val weight = data?.getStringExtra(WeightActivity.WEIGHT_KEY)
        Log.d("toto", weight)
        validateName?.text = weight
      }
    }
  }

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_name)

    validateName?.setOnClickListener {
      val intent = Intent(this, WeightActivity::class.java)
      intent.putExtra(WeightActivity.NAME_KEY, nameEditText?.text?.toString())
      startActivityForResult(intent, WEIGHT_RESULT_CODE)
    }
  }
}