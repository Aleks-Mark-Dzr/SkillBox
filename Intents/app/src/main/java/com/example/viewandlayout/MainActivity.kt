package com.example.viewandlayout


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
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
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import java.util.zip.CheckedInputStream


class MainActivity : AppCompatActivity() {

    companion object {
        private const val KEY_FORM = "form"
        private var state: FormState = FormState(valid = false, message = "")
    }

    private lateinit var binding: ActivityMainBinding
//    var isEmailValid: Boolean = false


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

        if (savedInstanceState != null) {
            state =
                savedInstanceState.getParcelable<FormState>(KEY_FORM) ?: error("unexpected state")
            if (state.valid) {

            } else {
                Toast.makeText(this@MainActivity, state.message, Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.ANR.setOnClickListener {
            Toast.makeText(this@MainActivity, "Application not responsing", Toast.LENGTH_SHORT)
                .show()
        }

        binding.textEmailAddress.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val isNotBlank = p0?.isNotBlank() ?: false
                val isAt = p0?.contains('@') ?: false
                val isSpace = p0?.contains(' ') ?: false

                if (isNotBlank && isAt && !isSpace) {
                    state.valid = true
                    Toast.makeText(this@MainActivity, "Адрес корректен", Toast.LENGTH_SHORT).show()

                } else {
                    state.message = "адрес некорректен"
                    Toast.makeText(this@MainActivity, state.message, Toast.LENGTH_SHORT).show()
                }
                isRegistrationAvailable()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.textPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isRegistrationAvailable()
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        binding.checkBox.setOnCheckedChangeListener(object :
            CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                isRegistrationAvailable()
            }

        })

        binding.makeLoginButton.setOnClickListener {
            makeLogOperation()
        }

        binding.phoneNumberText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                dialNumberPhone()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    override fun onStart() {
        super.onStart()
        Log.v(tag, "onStart was called")
        Log.d(tag, "onStart was called")
        Log.i(tag, "onStart was called")
        Log.e(tag, "onStart was called")
    }

    override fun onResume() {
        super.onResume()
        Log.v(tag, "onResume was called")
        Log.d(tag, "onResume was called")
        Log.i(tag, "onResume was called")
        Log.e(tag, "onResume was called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_FORM, state)
    }

    override fun onPause() {
        super.onPause()
        Log.v(tag, "onPause was called")
        Log.d(tag, "onPause was called")
        Log.i(tag, "onPause was called")
        Log.e(tag, "onPause was called")
    }

    override fun onStop() {
        super.onStop()
        Log.v(tag, "onStop was called")
        Log.d(tag, "onStop was called")
        Log.i(tag, "onStop was called")
        Log.e(tag, "onStop was called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(tag, "onDestroy was called")
        Log.d(tag, "onDestroy was called")
        Log.i(tag, "onDestroy was called")
        Log.e(tag, "onDestroy was called")
    }

    fun isRegistrationAvailable() {
        var isPasswordValid = binding.textPassword.text.isNotBlank()
        var isChecked = binding.checkBox.isChecked

        binding.makeLoginButton.isEnabled = state.valid && isPasswordValid && isChecked


    }

    private fun makeLogOperation() {
        binding.loginProgress.visibility = View.VISIBLE
        binding.makeLoginButton.isEnabled = false

        Handler().postDelayed({
            binding.loginProgress.visibility = View.GONE
            binding.makeLoginButton.isEnabled = true
            Toast.makeText(this@MainActivity, R.string.operation_complete, Toast.LENGTH_SHORT)
        }, 2000)
    }

    fun dialNumberPhone() {
        binding.dialButton.setOnClickListener {
            val phoneNumber = binding.phoneNumberText.text.toString()
            val dialNumberIntent = Intent(Intent.ACTION_DIAL).apply {

            }
            if (dialNumberIntent.resolveActivity(packageManager) != null) {
                startActivity(dialNumberIntent)
            } else {
                Toast.makeText(this@MainActivity, "No component to handle intent", Toast.LENGTH_SHORT).show()
            }
        }
    }
}