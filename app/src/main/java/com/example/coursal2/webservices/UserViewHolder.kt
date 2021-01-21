package com.example.coursal2.webservices

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coursal2.R

class UserViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
  RecyclerView.ViewHolder(inflater.inflate(R.layout.user_item, parent, false)), View.OnClickListener
{
  private var fullNameTextView: TextView? = null
  private var addressTextView: TextView? = null
  private var user: User? = null
  private var onUserClicked: OnUserClicked? = null

  init
  {
    fullNameTextView = itemView.findViewById(R.id.fullName)
    addressTextView = itemView.findViewById(R.id.address)
  }

  fun bind(user: User, onUserClicked: OnUserClicked)
  {
    this.user = user
    this.onUserClicked = onUserClicked

    fullNameTextView?.text = "${user.firstName} ${user.lastName}"
    addressTextView?.text = user.address
    itemView?.setOnClickListener(this)
  }

  override fun onClick(p0: View?)
  {
    onUserClicked?.onUserClicked(user)
  }
}