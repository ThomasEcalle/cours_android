package com.example.coursal1.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coursal1.R
import kotlinx.android.synthetic.main.activity_my_recycler.*

class MyRecyclerActivity : AppCompatActivity()
{
  private val users = listOf(
    User("John", "Cena", "Lorem ipsum"),
    User("Homer", "Simpson", "Lorem ipsum"),
    User("Bob", "Dylan", "Lorem ipsum"),
    User("Rick", "Morty", "Lorem ipsum"),
    User("Marcel", "Pagnol", "Lorem ipsum"),
    User("Asterix", "& Obelix", "Lorem ipsum"),
    User("Kaaris", "Sevran", "Lorem ipsum"),
    User("Provençal", "Le Gaullois", "Lorem ipsum")
  )

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_my_recycler)

    recyclerView?.apply {
      layoutManager = LinearLayoutManager(this@MyRecyclerActivity)
      adapter = UserAdapter(users)
    }
  }
}