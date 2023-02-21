package com.example.activity_09

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
//import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
//import androidx.navigation.findNavController
import com.example.activity_09.databinding.ActivityMainBinding

//import androidx.navigation.ui.navigateUp
//import androidx.navigation.ui.setupActionBarWithNavController
//import android.view.Menu
//import android.view.MenuItem


@Suppress("DEPRECATION", "UNUSED_VARIABLE")
class MainActivity : AppCompatActivity() {

    //https://skillbox.ru/course/profission-android-developer/
    //https://skillbox.ru/course/weblayout/

    //    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val cameraLauncher: Unit =
        prepareCall(ActivityResultContracts.TakePicture()) { bitmap ->
            bitmap ?: toast("Photo capture was cancelled")
            binding.resultPhotoImageView.setImageBitmap(bitmap)
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("LifecycleTest", "MainActivity_onCreate_${hashCode()}")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startExplicitButton.setOnClickListener {

            val messageText = binding.messageEditText.text.toString()
//            Log.d("tag", messageText)
            startActivity(SecondActivity.getIntent(this, messageText))
        }

        binding.takePhotoButton.setOnClickListener {
            dispatchTakePictureIntent()
        }

        binding.sendEmailButton.setOnClickListener {
            val emailAddress = binding.emailAddressEditText.text.toString()
            val emailSubject = binding.subjectEditText.text.toString()

            val isEmailValid: Boolean = Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()

            if (!isEmailValid) {
                toast("Enter valid email address")
            } else {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress))
                    putExtra(Intent.EXTRA_SUBJECT, emailSubject)
                }
                if (emailIntent.resolveActivity(packageManager) != null) {
                    startActivity(emailIntent)
                } else {
                    toast("No component to handle intent")
                }
            }
        }
    }

    private fun prepareCall(
        takePicture: ActivityResultContracts.TakePicture,
        function: (Bitmap?) -> Unit
    ): Unit = Unit

    private fun dispatchTakePictureIntent() {

        val isCameraPermissionGranted = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

        if (!isCameraPermissionGranted) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA),
                14
            )
        } else {
            cameraLauncher
        }
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode == PHOTO_REQUEST_CODE) {
//            if (resultCode == Activity.RESULT_OK) {
//                val previewBitmap = data?.getParcelableExtra("data") as? Bitmap
//                binding.resultPhotoImageView.setImageBitmap(previewBitmap)
//            } else {
//                toast("Photo capture was cancelled")
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }

    override fun onStart() {
        super.onStart()
        Log.d("LifecycleTest", "MainActivity / onStart / ${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifecycleTest", "MainActivity / onResume / ${hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifecycleTest", "MainActivity / onPause / ${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifecycleTest", "MainActivity / onStop / ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifecycleTest", "MainActivity / onDestroy / ${hashCode()}")
    }

    companion object {
        private const val PHOTO_REQUEST_CODE = 123
    }
}