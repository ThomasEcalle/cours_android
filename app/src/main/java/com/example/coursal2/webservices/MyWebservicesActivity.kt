package com.example.coursal2.webservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coursal2.R
import org.jetbrains.anko.doAsync
import java.net.URL

class MyWebservicesActivity : AppCompatActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_my_webservices)

    doAsync {
      val apiCall: URL = URL("https://next.json-generator.com/api/json/get/VydTXyeqY?delay=2000")
      val response = apiCall.readText()

      runOnUiThread {
        Log.d("toto", response)
      }
    }
  }
}