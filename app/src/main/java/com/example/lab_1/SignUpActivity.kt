//С серилизацией
package com.example.lab_1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val userNameEditText = findViewById<EditText>(R.id.userNameEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        val submitButton: Button = findViewById(R.id.submitButton)
        submitButton.setOnClickListener {
            val userName = userNameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (userName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                val user = User(userName, email, password)

                val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                with(sharedPreferences.edit()) {
                    putString("userName", user.name)
                    putString("email", user.email)
                    putString("password", user.password)
                    apply()
                }

                val resultIntent = Intent()
                resultIntent.putExtra("user", user)
                setResult(RESULT_OK, resultIntent)

                val homeIntent = Intent(this, HomeActivity::class.java)
                startActivity(homeIntent)
                finish()
            } else {
                Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
// Без серилизации
//package com.example.lab_1
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//class SignUpActivity : AppCompatActivity() {
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sign_up)
//
//        val userNameEditText = findViewById<EditText>(R.id.userNameEditText)
//        val emailEditText = findViewById<EditText>(R.id.emailEditText)
//        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
//
//        val submitButton: Button = findViewById(R.id.submitButton)
//        submitButton.setOnClickListener {
//            val userName = userNameEditText.text.toString()
//            val email = emailEditText.text.toString()
//            val password = passwordEditText.text.toString()
//
//            if (userName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
//                val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
//                with(sharedPreferences.edit()) {
//                    putString("userName", userName)
//                    putString("email", email)
//                    putString("password", password)
//                    apply()
//                }
//
//                val resultIntent = Intent()
//                resultIntent.putExtra("userName", userName)
//                resultIntent.putExtra("email", email)
//                resultIntent.putExtra("password", password)
//                setResult(RESULT_OK, resultIntent)
//
//                val homeIntent = Intent(this, HomeActivity::class.java)
//                startActivity(homeIntent)
//                finish()
//            } else {
//                Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}


