package com.example.coursal1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_logic_exercise.*

class LogicExerciseActivity : AppCompatActivity(), TextWatcher
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_logic_exercise)
    validateButton?.setOnClickListener {
      result?.text = editText?.text
      houdini?.isVisible?.let { isVisible -> houdini?.isVisible = !isVisible }
    }

    editText?.addTextChangedListener(this)
  }

  override fun afterTextChanged(editable: Editable?)
  {
    Log.d(LogicExerciseActivity::class.simpleName, "afterTextChanged: $editable")
    //result?.text = editable
  }

  override fun beforeTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int)
  {
    Log.d(LogicExerciseActivity::class.simpleName, "beforeTextChanged: $text")
  }

  override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int)
  {
    Log.d(LogicExerciseActivity::class.simpleName, "onTextChanged: $text")
  }
}