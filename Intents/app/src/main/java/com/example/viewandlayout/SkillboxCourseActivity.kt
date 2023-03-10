package com.example.viewandlayout

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.viewandlayout.databinding.ActivityCourseBinding

class SkillboxCourseActivity: AppCompatActivity(R.layout.activity_course) {

    private lateinit var binding: ActivityCourseBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        handleIntentData()

        binding = ActivityCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

//    https://go.skillbox.ru/profession/profession-android-developer-new/android-dev-1/5e069f51-0613-4402-9737-c807cb103cde/homework

    private fun handleIntentData(){
        intent.data?.pathSegments?.let { courseName ->
            binding.courseTextView.text = courseName
        }
    }
}