package com.example.activity_09

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.example.activity_09.databinding.ActivityMainBinding
import com.example.activity_09.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity(R.layout.activity_second) {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        val message: String? = intent.getStringExtra(KEY_MESSAGE)
        binding.messageTextView.text = message
    }

    companion object {
        private const val KEY_MESSAGE = "message key"

        fun getIntent(context: Context, message: String?): Intent {
            return Intent(context,SecondActivity::class.java)
                .putExtra(KEY_MESSAGE, message)
        }
    }
}