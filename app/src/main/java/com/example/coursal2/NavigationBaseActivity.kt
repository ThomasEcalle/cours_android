package com.example.coursal2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_navigation_base.*

class NavigationBaseActivity : AppCompatActivity(), View.OnClickListener
{
  companion object
  {
    val REQUEST_CODE = 32
  }

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_navigation_base)
    button?.setOnClickListener(this)
  }

  override fun onClick(view: View?)
  {
    NavigationDestinationActivity.navigateTo(this, 42)
    /*
    val intent = Intent(this, NavigationDestinationActivity::class.java)
    intent.putExtra("test", 42)
    startActivityForResult(intent, REQUEST_CODE)
    */
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
  {
    super.onActivityResult(requestCode, resultCode, data)
    when (resultCode)
    {
      REQUEST_CODE ->
      {
        val value = data?.getStringExtra(NavigationDestinationActivity.RESULT_KEY)
        button?.text = value
      }
    }
  }
}