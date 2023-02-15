package com.example.activity_09

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.activity_09.databinding.ActivityCourseBinding
import com.example.activity_09.databinding.ActivityMainBinding

class CourseActivity : AppCompatActivity(R.layout.activity_course) {

    private lateinit var binding: ActivityCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntentData()

        binding = ActivityCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    //    https://skillbox.ru/course/profession-android-developer-2021/

    private fun handleIntentData() {
        intent.data?.lastPathSegment?.let { courseName ->
            binding.courseNameTextView.text = courseName
        }
    }
}