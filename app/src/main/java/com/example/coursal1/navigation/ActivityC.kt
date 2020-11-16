package com.example.coursal1.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal1.R
import kotlinx.android.synthetic.main.activity_c.*

class ActivityC : AppCompatActivity()
{

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_c)

    validate?.setOnClickListener {
      val intent = Intent()
      intent.putExtra("name", editText?.text.toString())
      setResult(32, intent)
      finish()
    }
  }
}