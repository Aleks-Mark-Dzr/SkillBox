package com.example.activity_09

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.activity_09.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("LifecycleTest", "SecondActivity_onCreate_${hashCode()}")

        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        val message: String? = intent.getStringExtra(KEY_MESSAGE)
        Log.d("tag", message ?: "")
        binding.messageTextView.setText(message)
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifecycleTest", "SecondActivity_onStart_${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifecycleTest", "SecondActivity_onResume_${hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifecycleTest", "SecondActivity_onPause_${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifecycleTest", "SecondActivity_onStop_${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifecycleTest", "SecondActivity_onDestroy_${hashCode()}")
    }

    companion object {
        private const val KEY_MESSAGE = "message key"

        fun getIntent(context: Context, message: String?): Intent {
            return Intent(context, SecondActivity::class.java)
                .putExtra(KEY_MESSAGE, message)
        }
    }
}