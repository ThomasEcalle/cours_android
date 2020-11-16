package com.example.coursal2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_navigation_destination.*

class NavigationDestinationActivity : AppCompatActivity(), View.OnClickListener
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_navigation_destination)
    back?.setOnClickListener(this)

    val receivedValue = intent?.getIntExtra("test", 20)
    titleView?.text = "$receivedValue"
  }

  override fun onClick(p0: View?)
  {
    val resultIntent = Intent()
    resultIntent.putExtra("some_key", "Mon résultat")
    setResult(32, resultIntent)
    finish()
  }
}