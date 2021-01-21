package com.example.coursal2.webservices

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coursal2.R
import kotlinx.android.synthetic.main.activity_my_webservices.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyWebservicesActivity : AppCompatActivity(), View.OnClickListener, Callback<List<User>>, OnUserClicked
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_my_webservices)

    buttonWebservices?.setOnClickListener(this)
  }

  override fun onClick(view: View?)
  {
    if (isNetworkConnected())
    {
      // textView?.text = "Loading"

      loader?.visibility = View.VISIBLE
      buttonWebservices?.visibility = View.GONE
      errorText?.visibility = View.GONE
      MyApi.retrieveAllUsers(this)
    }
    else
    {
      errorText?.text = "NO NETWORK !"
      errorText?.visibility = View.VISIBLE
      //textView?.text = "NO INTERNET"
    }
  }

  override fun onFailure(call: Call<List<User>>, t: Throwable)
  {
    loader?.visibility = View.GONE
    buttonWebservices?.visibility = View.VISIBLE
    errorText?.text = "ERRROR $t"
    errorText?.visibility = View.VISIBLE
    //textView?.text = "Error : $t"
  }

  override fun onResponse(call: Call<List<User>>, response: Response<List<User>>)
  {
    val users = response.body()

    users?.let {
      usersRecyclerView?.apply {
        layoutManager = LinearLayoutManager(this@MyWebservicesActivity)
        adapter = UserAdapter(it, this@MyWebservicesActivity)
      }

      usersRecyclerView?.visibility = View.VISIBLE
      loader?.visibility = View.GONE
    }

    //textView?.text = "${response.code()} $user"
  }

  private fun isNetworkConnected(): Boolean
  {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
    {
      val activeNetwork = connectivityManager.activeNetwork
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
//    doAsync {
//      val apiCall: URL = URL("https://next.json-generator.com/api/json/get/VkFy1Vfyq?delay=2000")
//      val response = apiCall.readText()
//
//      val user = Gson().fromJson(response, User::class.java)
//
//      uiThread {
//        Log.d("toto", response)
//        textView?.text = user.toString()
//      }
//    }
  }

  override fun onUserClicked(user: User?)
  {
    Log.d("toto", "$user")
  }
}