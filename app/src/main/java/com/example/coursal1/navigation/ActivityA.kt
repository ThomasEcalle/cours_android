package com.example.coursal1.navigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal1.R
import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_a)

    button?.setOnClickListener {
      ActivityB.navigateTo(this, 42)
    }

    buttonC?.setOnClickListener {
      val intent = Intent(this, ActivityC::class.java)
      startActivityForResult(intent, 32)
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
  {
    super.onActivityResult(requestCode, resultCode, data)
    when (requestCode)
    {
      32 ->
      {
        val name = data?.getStringExtra(ActivityC.RESULT_KEY)
        buttonC?.text = name
      }
    }
  }
}