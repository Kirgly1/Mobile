package com.example.lab_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val signInButton: Button = findViewById(R.id.signInButton)

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email == "test@mail.com" && password == "password") {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Неправильный email или пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
