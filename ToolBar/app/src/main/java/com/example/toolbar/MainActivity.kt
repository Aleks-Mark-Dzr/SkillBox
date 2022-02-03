package com.example.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.toolbar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val users = listOf(
        "User1",
        "User2",
        "Unknown"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        initToolbar()
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

//    private fun initToolbar() {
//        binding.toolbar.setNavigationOnClickListener {
//            toast("Navigation clicked")
//        }
//
//        binding.toolbar.setOnMenuItemClickListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.action_1 -> {
//                    toast("action 1 clicked")
//                    true
//                }
//                R.id.action_2 -> {
//                    toast("action 2 clicked")
//                    true
//                }
//                else -> false
//            }
//        }
//
//        val searchItem = binding.toolbar.menu.findItem(R.id.action_search)
//        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
//            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
//                binding.expandTextView.text = "search expanded"
//                return true
//            }
//
//            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
//                binding.expandTextView.text = "search collapse"
//                return true
//            }
//
//        })
//
//        (searchItem.actionView as SearchView).setOnQueryTextListener(object :
//            SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                users.filter { it.contains(newText ?: "", true) }
//                    .joinToString()
//                    .let {
//                        binding.searchResaltTextView.text = it
//                    }
//                return true
//            }
//
//        })
//    }
}