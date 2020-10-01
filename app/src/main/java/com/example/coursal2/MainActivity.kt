package com.example.coursal2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.logic_first.*

class MainActivity : AppCompatActivity(), View.OnClickListener
{
  private var myButton2: Button? = null
  private var myButton3: Button? = null

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.logic_first)
    val textView = findViewById<TextView?>(R.id.text)
    val button: Button? = findViewById(R.id.button1)

    textView?.let { Log.d(MainActivity::class.simpleName, it.text.toString()) }
    textView?.text = "Salut les AL2"


    button?.text = "Mon Bouton"
    button?.setOnClickListener {
      Log.d(MainActivity::class.simpleName, "Button was clicked")
    }

    myButton2 = findViewById(R.id.button2)
    myButton2?.setOnClickListener(this)

    myButton3 = findViewById(R.id.button3)
    myButton3?.setOnClickListener(this)

    bottomText?.text = "Modifié"
  }

  override fun onClick(view: View?)
  {
    when (view?.id)
    {
      R.id.button2 -> Log.d(MainActivity::class.simpleName, "Button2 was clicked")
      R.id.button3 -> Log.d(MainActivity::class.simpleName, "Button3 was clicked")
      else -> a()
    }
  }

  private fun a()
  {
    Log.d(MainActivity::class.simpleName, "Something was clicked")
  }

  fun toto(view: View?)
  {
    Log.d(MainActivity::class.simpleName, "Text was clicked")
  }

}