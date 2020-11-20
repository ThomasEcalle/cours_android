package com.example.coursal2.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coursal2.R
import kotlinx.android.synthetic.main.fragment_blank.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BlankFragment : Fragment(), View.OnClickListener
{
  private var param1: String? = null
  private var param2: String? = null
  private var blankFragmentListener: BlankFragmentListener? = null

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    arguments?.let {
      param1 = it.getString(ARG_PARAM1)
      param2 = it.getString(ARG_PARAM2)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View?
  {
    return inflater.inflate(R.layout.fragment_blank, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    super.onViewCreated(view, savedInstanceState)
    param2TextView.text = param2
    param2TextView?.setOnClickListener(this)
  }

  /*
  override fun onAttach(context: Context)
  {
    super.onAttach(context)
    try
    {
      blankFragmentListener = activity as BlankFragmentListener
    } catch (exception: ClassCastException)
    {
      Log.e("error", "${activity?.packageName} must implement BlankFragmentListener")
    }
  }
  */

  override fun onClick(view: View?)
  {
    blankFragmentListener?.onNumberRetrieved(42)
  }

  companion object
  {
    @JvmStatic
    fun newInstance(param1: String, param2: String, blankFragmentListener: BlankFragmentListener) =
      BlankFragment().apply {
        arguments = Bundle().apply {
          putString(ARG_PARAM1, param1)
          putString(ARG_PARAM2, param2)
        }
        this.blankFragmentListener = blankFragmentListener
      }
  }
}