package com.example.coursal1.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coursal1.R

class UserViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
  RecyclerView.ViewHolder(inflater.inflate(R.layout.user_item, parent, false)), View.OnClickListener
{
  private var fullNameTextView: TextView? = null
  private var addressTextView: TextView? = null
  private var user: User? = null
  private var onUserClickedListener: OnUserClickedListener? = null

  init
  {
    fullNameTextView = itemView.findViewById(R.id.fullNameTextView)
    addressTextView = itemView.findViewById(R.id.addressTextView)
  }

  fun bind(user: User, onUserClickedListener: OnUserClickedListener)
  {
    this.user = user
    this.onUserClickedListener = onUserClickedListener
    fullNameTextView?.text = "${user.firstName} ${user.lastName}"
    addressTextView?.text = user.address

    itemView.setOnClickListener(this)
  }

  override fun onClick(p0: View?)
  {
    onUserClickedListener?.onUserClicked(user)
  }
}