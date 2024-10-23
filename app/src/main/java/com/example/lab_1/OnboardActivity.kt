package com.example.lab_1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class OnboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)

        val imageView = findViewById<ImageView>(R.id.gifImageView)
        Glide.with(this)
            .asGif()
            .load(R.drawable.onboard_image)
            .into(imageView)
        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}
