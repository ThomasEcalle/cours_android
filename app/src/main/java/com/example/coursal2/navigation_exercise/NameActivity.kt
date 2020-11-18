package com.example.coursal2.navigation_exercise

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal2.R
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity(), View.OnClickListener
{
  companion object
  {
    val REQUEST_CODE = 32
  }

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_name)
    validateName?.setOnClickListener(this)
  }

  override fun onClick(view: View?)
  {
    val name = nameEditText?.text.toString()
    val intent = Intent(this, WeightActivity::class.java)
    intent.putExtra(WeightActivity.NAME_PARAMETER_KEY, name)
    startActivityForResult(intent, REQUEST_CODE)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
  {
    super.onActivityResult(requestCode, resultCode, data)
    when (resultCode)
    {
      REQUEST_CODE ->
      {
        val weight = data?.getStringExtra(WeightActivity.RESULT_KEY)
        validateName?.text = weight
      }
    }
  }
}