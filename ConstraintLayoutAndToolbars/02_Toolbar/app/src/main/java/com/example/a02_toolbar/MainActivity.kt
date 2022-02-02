package com.example.a02_toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a02_toolbar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initToolbar()
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun initToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            toast("Navigation clicked")
        }

        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_1 -> {
                    toast("action 1 clicked")
                    true
                }
                R.id.action_2 -> {
                    toast("action 2 clicked")
                    true
                }
                else -> false
            }
        }
    }
}