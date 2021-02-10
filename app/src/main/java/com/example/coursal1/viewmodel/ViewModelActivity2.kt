package com.example.coursal1.viewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.coursal1.R
import kotlinx.android.synthetic.main.activity_view_model2.*

class ViewModelActivity2 : AppCompatActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_view_model2)

    val myEditTextViewModel: MyEditTextViewModel by viewModels()

    myEditTextViewModel.result.observe(this, Observer<String> { newValue ->
      result.text = newValue
    })

    validate?.setOnClickListener {
      myEditTextViewModel.setResult(myEditText.text.toString())
    }
  }
}