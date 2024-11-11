package com.example.lab_1.old//package com.example.lab_1
//
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import android.widget.Button
//import android.widget.ImageView
//import com.bumptech.glide.Glide
//
//class OnboardActivity : AppCompatActivity() {
//    private val TAG = "OnboardActivity"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Log.d(TAG, "onCreate called")
//        setContentView(R.layout.activity_onboard)
//
//        val imageView = findViewById<ImageView>(R.id.gifImageView)
//        Glide.with(this)
//            .asGif()
//            .load(R.drawable.onboard_image)
//            .into(imageView)
//        val nextButton: Button = findViewById(R.id.nextButton)
//        nextButton.setOnClickListener {
//            val intent = Intent(this, SignInActivity::class.java)
//            startActivity(intent)
//        }
//    }
//    override fun onStart() {
//        super.onStart()
//        Log.d(TAG, "onStart called")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d(TAG, "onResume called")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d(TAG, "onPause called")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d(TAG, "onStop called")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(TAG, "onDestroy called")
//    }
//}
