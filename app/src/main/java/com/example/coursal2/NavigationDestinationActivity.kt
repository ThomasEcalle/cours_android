package com.example.coursal2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_navigation_destination.*

class NavigationDestinationActivity : AppCompatActivity(), View.OnClickListener
{
  companion object
  {
    val RESULT_KEY = "resultKey"

    fun navigateTo(context: Context, age: Int)
    {
      val intent = Intent(context, NavigationDestinationActivity::class.java)
      intent.putExtra("test", age)
      context.startActivity(intent)
    }
  }

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
    resultIntent.putExtra(RESULT_KEY, "SALUT")
    setResult(NavigationBaseActivity.REQUEST_CODE, resultIntent)
    finish()
  }
}