package com.example.coursal1.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal1.R
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : AppCompatActivity()
{

  companion object
  {
    fun navigateTo(context: Context, id: Int)
    {
      val intent = Intent(context, ActivityB::class.java)
      intent.putExtra("toto", id)
      context.startActivity(intent)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_b)

    val id = intent?.getIntExtra("toto", 30)
    textView?.text = "ID = $id"

    backButton?.setOnClickListener {
      finish()
    }
  }
}