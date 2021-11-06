package com.example.viewandlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.CheckBox
import android.widget.Toast
import com.example.viewandlayout.databinding.ActivityMainBinding
import android.widget.CompoundButton
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var isEmailValid: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textEmailAddress.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                var isEmailValid = false
                val isNotBlank = p0?.isNotBlank() ?: false
                val isAt = p0?.contains('@') ?: false
                val isSpace = p0?.contains(' ') ?: false

                if (isNotBlank && isAt && !isSpace) {
                    isEmailValid = true
                    Toast.makeText(this@MainActivity, "Адрес корректен", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(this@MainActivity, "Адрес некорректен", Toast.LENGTH_SHORT)
                        .show()
                }
                registrationEvailable()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

    }
    fun registrationEvailable() {
        var isPasswordValid = binding.textPassword.text.isNotBlank()
        var isChecked = binding.checkBox.isChecked

        if (isEmailValid && isPasswordValid && isChecked) {
            binding.makeLoginButton.isEnabled = true
        }
    }

}
