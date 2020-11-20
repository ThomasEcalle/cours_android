package com.example.coursal2.fragments.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coursal2.R
import kotlinx.android.synthetic.main.fragment_email.*

class EmailFragment : Fragment(), View.OnClickListener
{
  private var onEmailSelectedListener: OnEmailSelectedListener? = null

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View?
  {
    return inflater.inflate(R.layout.fragment_email, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    super.onViewCreated(view, savedInstanceState)
    validateEmail?.setOnClickListener(this)
  }

  override fun onClick(view: View?)
  {
    val emailValue = emailEditText?.text.toString()
    onEmailSelectedListener?.onEmailSelected(emailValue)
  }

  companion object
  {
    @JvmStatic
    fun newInstance(onEmailSelectedListener: OnEmailSelectedListener) =
      EmailFragment().apply {
        this.onEmailSelectedListener = onEmailSelectedListener
      }
  }
}