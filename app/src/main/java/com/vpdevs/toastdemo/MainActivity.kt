package com.vpdevs.toastdemo

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        * launches the toast with default params
        * */
        appCompatButton_default_toast.setOnClickListener {
            Toast.makeText(applicationContext, "Default Toast", Toast.LENGTH_LONG).show()
        }

        /*
        * launches the toast with position
        * */
        appCompatButton_position.setOnClickListener {
            val toast = Toast.makeText(applicationContext, "Toast at custom position ", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP or Gravity.RIGHT, 25, 75)
            toast.show()
        }

        /*
        * launches the toast with custom layout
        * */
        appCompatButton_layout.setOnClickListener {
            /*val container : ViewGroup= findViewById(R.id.layout_custom_root)
            val layout : ViewGroup = layoutInflater.inflate(R.layout.layout_toast , container)*/
            val inflater = layoutInflater
            val layout = inflater.inflate(
                R.layout.layout_toast,
                findViewById<ViewGroup>(R.id.layout_custom_root)
            )
            val textView: TextView = layout.findViewById(R.id.textView_toast)
            textView.text = "This is a custom layout"
            with(Toast(applicationContext)) {
                duration = Toast.LENGTH_SHORT
                setGravity(Gravity.CENTER or Gravity.RIGHT, 25, 0)
                view = layout
                show()
            }
        }
    }
}
