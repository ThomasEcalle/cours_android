package com.example.coursal1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.logic_first.*


class MainActivity : AppCompatActivity(), View.OnClickListener
{
  /*
  C'est juste pour l'exemple
  PERSONNE ne fait ça
  on utilise les Koltin extensions
   */
  private var textView: TextView? = null
  private var myButton: Button? = null

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.logic_first)

    /*
    Exemple de click listener en mode "this"
     */
    textView = findViewById(R.id.text)
    textView?.let { Log.d("toto", it.text.toString()) }
    textView?.text = "toto"
    textView?.setOnClickListener(this)

    /*
    Exemple de click listener en mode "lambda"
     */
    myButton = findViewById(R.id.button1)
    myButton?.text = "babar"
    myButton?.setOnClickListener {
      Log.d(MainActivity::class.simpleName, "Button clicked")
      textView?.text = "toto2"
    }

    /*
    Kotlin extensions : la mort du findViewById
     */
    myAwesomeTextView?.text = "C'est trop bien !"
    myAwesomeTextView?.setOnClickListener(this)
  }

  override fun onClick(view: View?)
  {
    when (view?.id)
    {
      R.id.text -> Log.d(MainActivity::class.simpleName, "TextView clicked")
      R.id.myAwesomeTextView -> Log.d(MainActivity::class.simpleName, "AwesomeTextView clicked")
      else ->
      {
        Log.d(MainActivity::class.simpleName, "Something has been clicked")
      }
    }
  }

  fun toto(view: View?)
  {
    Log.d(MainActivity::class.simpleName, "TOTO")
    myAwesomeTextView?.text = "toto a été cliqué"
  }
}