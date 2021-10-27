package com.markov.skillboxkotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dynamic.*
import kotlinx.android.synthetic.main.item_text.view.*
import kotlin.random.Random

class DynamicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic)

        addButton.setOnClickListener {
            val textToAdd = textInput.text.toString()
            val view = layoutInflater.inflate(R.layout.item_text, container, false)
            view.apply {
                textView.text = textToAdd
                deleteButton.setOnClickListener {
                    container.removeView(this)
                }
            }

            container.addView(view)
        }
    }
}