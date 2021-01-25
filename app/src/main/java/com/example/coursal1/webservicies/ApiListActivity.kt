package com.example.coursal1.webservicies

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coursal1.R
import kotlinx.android.synthetic.main.activity_api_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiListActivity : AppCompatActivity(), View.OnClickListener, Callback<List<User>>,
  UserViewHolder.OnUserClickedListener
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_api_list)

    launchButton?.setOnClickListener(this)
  }

  override fun onClick(p0: View?)
  {
    launchButton?.visibility = View.GONE
    loader?.visibility = View.VISIBLE
    MyApi.retrieveAllUsers(this)
  }

  override fun onFailure(call: Call<List<User>>, t: Throwable)
  {
    loader?.visibility = View.GONE
    launchButton?.visibility = View.VISIBLE
    errorText?.visibility = View.VISIBLE

    errorText?.text = "ERROR: $t"
  }

  override fun onResponse(call: Call<List<User>>, response: Response<List<User>>)
  {
    val users = response.body()

    usersRecyclerView?.apply {
      adapter = UserAdapter(users ?: emptyList(), this@ApiListActivity)
      layoutManager = LinearLayoutManager(this@ApiListActivity)
    }

    loader?.visibility = View.GONE
    usersRecyclerView?.visibility = View.VISIBLE
  }

  override fun onUserClicked(user: User?)
  {
    TODO("Not yet implemented")
  }
}