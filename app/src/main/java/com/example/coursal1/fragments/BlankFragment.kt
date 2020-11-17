package com.example.coursal1.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coursal1.R
import kotlinx.android.synthetic.main.fragment_blank.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BlankFragment : Fragment()
{
  private var param1: String? = null
  private var param2: String? = null
  private var dummyInterface: DummyInterface? = null

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
    param1TextView?.text = param1
    param1TextView?.setOnClickListener {
      dummyInterface?.myDummyMethod("SALUT LES NOOB")
    }
  }

  companion object
  {
    @JvmStatic
    fun newInstance(param1: String, param2: String, dummyInterface: DummyInterface) =
      BlankFragment().apply {
        arguments = Bundle().apply {
          putString(ARG_PARAM1, param1)
          putString(ARG_PARAM2, param2)
        }

        this.dummyInterface = dummyInterface
      }
  }
}