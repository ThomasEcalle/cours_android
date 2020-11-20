package com.example.coursal2.fragments.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coursal2.R
import kotlinx.android.synthetic.main.fragment_email_displayer.*

private const val ARG_EMAIL = "email"

class EmailDisplayerFragment : Fragment()
{
  private var email: String? = null

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    arguments?.let {
      email = it.getString(ARG_EMAIL)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View?
  {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_email_displayer, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    super.onViewCreated(view, savedInstanceState)
    emailTextView?.text = email
  }

  companion object
  {
    @JvmStatic
    fun newInstance(email: String) =
      EmailDisplayerFragment().apply {
        arguments = Bundle().apply {
          putString(ARG_EMAIL, email)
        }
      }
  }
}