package com.example.coursal1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyEditTextViewModel : ViewModel()
{
  val result = MutableLiveData<String>()

  fun setResult(newValue: String)
  {
    result.value = newValue + "toto"
  }
}