package com.example.coursal1.fragments.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coursal1.R
import kotlinx.android.synthetic.main.fragment_name.*

class NameFragment : Fragment()
{
  private var onNameSelected: OnNameSelected? = null

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View?
  {
    return inflater.inflate(R.layout.fragment_name, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    super.onViewCreated(view, savedInstanceState)
    validate?.setOnClickListener {
      onNameSelected?.onNameSelected(nameEditText?.text?.toString() ?: "")
    }
  }

  companion object
  {
    @JvmStatic
    fun newInstance(onNameSelected: OnNameSelected) = NameFragment().apply {
      this.onNameSelected = onNameSelected
    }
  }
}