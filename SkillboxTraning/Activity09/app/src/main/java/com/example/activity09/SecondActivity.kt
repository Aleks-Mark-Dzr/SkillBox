package com.example.activity09

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.activity09.databinding.ActivityMainBinding
import com.example.activity09.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(R.layout.activity_second) {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        val message = intent.getStringExtra(KEY_MESSAGE)
        binding.messageTextView.text = message
    }

    companion object {
        const val KEY_MESSAGE = "message key"

        fun getIntent(context: Context, message: String?): Intent{
            return Intent(context,SecondActivity::class.java)
                .putExtra(KEY_MESSAGE, message)
        }
    }
}