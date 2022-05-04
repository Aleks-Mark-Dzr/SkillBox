package com.example.viewandlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.transition.ChangeTransform
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.Checkable
import android.widget.Toast
import com.example.viewandlayout.databinding.ActivityMainBinding
import android.widget.CompoundButton
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import java.util.zip.CheckedInputStream


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var isEmailValid: Boolean = false

    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.v(tag, "onCreate was called")
        Log.d(tag, "onCreate was called")
        Log.i(tag, "onCreate was called")
        Log.e(tag, "onCreate was called")

        binding.textEmailAddress.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
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
                isRegistrationAvailable()
                Log.v(tag, "onTextChenged was called")
                Log.d(tag, "onTextChenged was called")
                Log.i(tag, "onTextChenged was called")
                Log.e(tag, "onTextChenged was called")
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.textPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isRegistrationAvailable()

                Log.v(tag, "textPassword was called")
                Log.d(tag, "textPassword was called")
                Log.i(tag, "textPassword was called")
                Log.e(tag, "textPassword was called")
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        binding.checkBox.setOnCheckedChangeListener(object :
            CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                isRegistrationAvailable()

                Log.v(tag, "checkBox was called")
                Log.d(tag, "checkBox was called")
                Log.i(tag, "checkBox was called")
                Log.e(tag, "checkBox was called")
            }

        }

        )

    }

    fun isRegistrationAvailable() {
        var isPasswordValid = binding.textPassword.text.isNotBlank()
        var isChecked = binding.checkBox.isChecked

        binding.makeLoginButton.isEnabled = isEmailValid && isPasswordValid && isChecked

        binding.makeLoginButton.setOnClickListener {
            makeLogOperation()
        }
    }

    private fun makeLogOperation() {
        binding.loginProgress.visibility = View.VISIBLE
        binding.makeLoginButton.isEnabled = false

        Handler().postDelayed({
            binding.loginProgress.visibility = View.GONE
            binding.makeLoginButton.isEnabled = true
            Toast.makeText(this@MainActivity,R.string.operation_complete, Toast.LENGTH_SHORT)
        }, 2000)

    }
}
