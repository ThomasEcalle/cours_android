package com.example.coursal2

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

    validate?.setOnClickListener {
      result?.text = editText?.text
      random?.isVisible?.let { isVisible -> random?.isVisible = !isVisible }
    }

    editText?.addTextChangedListener(this)
  }

  override fun afterTextChanged(editable: Editable?)
  {
    Log.d(LogicExerciseActivity::class.simpleName, "afterTextChanged : ${editable?.toString()}")
    //result?.text = editable?.toString()
  }

  override fun beforeTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int)
  {
    Log.d(LogicExerciseActivity::class.simpleName, "beforeTextChanged : ${charSequence.toString()}")
  }

  override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int)
  {
    Log.d(LogicExerciseActivity::class.simpleName, "onTextChanged : ${charSequence.toString()}")

  }
}