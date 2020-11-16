package com.example.coursal2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_navigation_base.*

class NavigationBaseActivity : AppCompatActivity(), View.OnClickListener
{

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_navigation_base)
    button?.setOnClickListener(this)
  }

  override fun onClick(view: View?)
  {
    val intent = Intent(this, NavigationDestinationActivity::class.java)
    intent.putExtra("test", 42)
    startActivityForResult(intent, 32)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
  {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == 32)
    {
      val result = data?.extras?.get("some_key") as String?
      titleView?.text = result
    }
  }
}