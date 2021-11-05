package com.example.viewandlayout

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View.inflate
import android.widget.Toast
import com.example.viewandlayout.databinding.ActivityMainBinding
import com.example.viewandlayout.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textEmailAddress.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var emailValid = false
                val isNotBlank = p0?.isNotBlank()?:false
                val at = p0?.contains('@')?:false
                val space = p0?.contains(' ')?:false

                if (isNotBlank && at && !space) {
                    emailValid = true
                    Toast.makeText(view.context, "Адрес корректен", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(view.context, "Адрес некорректен", Toast.LENGTH_SHORT).show()
                }
            }

            override fun afterTextChanged(p0: Editable?) {}

        })




//        binding.textEmailAddress.setOnClickListener {
//            Toast.makeText(this, "Введите email", Toast.LENGTH_SHORT).show()
//
//        }
    }
}
