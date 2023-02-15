package com.example.activity_09

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.activity_09.databinding.ActivityEmailBinding

class EmailActivity : AppCompatActivity(R.layout.activity_email) {

    private lateinit var binding: ActivityEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEmailParamsFromIntent()
    }

    private fun setEmailParamsFromIntent(){
        val address = intent.getStringArrayExtra(Intent.EXTRA_EMAIL)
        val subject = intent.getStringExtra(Intent.EXTRA_SUBJECT)

        binding.addressTextView.text = address?.toString() ?: "Email address is not set"
        binding.subjectTextView.text = subject ?: "Subject is not set"
    }
}