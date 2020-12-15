package com.example.coursal2.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
  private val users: List<User>,
  private val onUserClicked: OnUserClicked
) : RecyclerView.Adapter<UserViewHolder>()
{
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder
  {
    val inflater = LayoutInflater.from(parent.context)

    return UserViewHolder(inflater, parent)
  }

  override fun getItemCount(): Int = users.size

  override fun onBindViewHolder(holder: UserViewHolder, position: Int)
  {
    val user = users[position]
    holder.bind(user, onUserClicked)
  }
}