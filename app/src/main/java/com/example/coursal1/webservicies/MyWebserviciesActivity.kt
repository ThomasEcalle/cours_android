package com.example.coursal1.webservicies

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal1.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_my_webservicies.*
import org.jetbrains.anko.doAsync
import java.net.URL

class MyWebserviciesActivity : AppCompatActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_my_webservicies)

    myTextView?.text = "Je load"

    doAsync {
      val apiCall = URL("https://next.json-generator.com/api/json/get/VydTXyeqY?delay=2000")
      val response = apiCall.readText()

      runOnUiThread {
        Log.d("toto", response)
        val user = Gson().fromJson(response, User::class.java)
        myTextView?.text = user.firstName
      }
    }

  }
}