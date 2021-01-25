package com.example.coursal1.webservicies

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.coursal1.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_my_webservicies.*
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URL

class MyWebserviciesActivity : AppCompatActivity(), View.OnClickListener, Callback<User>
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_my_webservicies)

    myButton?.setOnClickListener(this)
  }

  override fun onClick(p0: View?)
  {
    MyApi.retrieveUser(this)
  }

  override fun onFailure(call: Call<User>, t: Throwable)
  {
    myTextView?.text = "ERROR $t"
  }

  override fun onResponse(call: Call<User>, response: Response<User>)
  {
    myTextView.text = "${response.code()} ${response.body()}"
  }

  private fun isNetworkConnected(): Boolean
  {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
    {
      val activeNetwork =  connectivityManager.activeNetwork
      val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
      networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
    else
    {
      TODO("VERSION.SDK_INT < M")
      true
    }
  }

  private fun oldWebservicesCalls()
  {
    if (isNetworkConnected())
    {
      doAsync {
        val apiCall = URL("https://next.json-generator.com/api/json/get/VkFy1Vfyq?delay=2000")
        val response = apiCall.readText()

        runOnUiThread {
          Log.d("toto", response)
          val user = Gson().fromJson(response, User::class.java)
          myTextView?.text = user.firstName
        }
      }
    } else
    {
      myTextView?.text = "No network !"
    }
  }
}