package com.example.coursal1.fragments.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coursal1.R
import kotlinx.android.synthetic.main.fragment_name_displayer.*

private const val NAME_PARAM = "nameParam"

class NameDisplayerFragment : Fragment()
{

  private var name: String? = null

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    arguments?.let {
      name = it.getString(NAME_PARAM)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View?
  {
    return inflater.inflate(R.layout.fragment_name_displayer, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    super.onViewCreated(view, savedInstanceState)
    nameTextView?.text = name
  }

  companion object
  {
    @JvmStatic
    fun newInstance(name: String) =
      NameDisplayerFragment().apply {
        arguments = Bundle().apply {
          putString(NAME_PARAM, name)
        }
      }
  }
}