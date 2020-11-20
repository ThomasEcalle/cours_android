package com.example.coursal2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coursal2.R

class FragmentB : Fragment()
{
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View?
  {
    return inflater.inflate(R.layout.fragment_b, container, false)
  }

  companion object
  {
    @JvmStatic
    fun newInstance() = FragmentB()
  }
}