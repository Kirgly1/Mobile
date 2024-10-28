// С серилизацией
package com.example.lab_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    private val SIGN_UP_REQUEST_CODE = 1
    private val TAG = "SignInActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        setContentView(R.layout.activity_sign_in)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val signInButton: Button = findViewById(R.id.signInButton)
        val signUpButton: Button = findViewById(R.id.signUpButton)

        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, 1)
        }

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val savedEmail = sharedPreferences.getString("email", "")
            val savedPassword = sharedPreferences.getString("password", "")

            if (email == savedEmail && password == savedPassword) {
                val homeIntent = Intent(this, HomeActivity::class.java)
                startActivity(homeIntent)
                finish()
            } else {
                Toast.makeText(this, "Неверные учетные данные", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}

// Без серилизации
//package com.example.lab_1
//
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//class SignInActivity : AppCompatActivity() {
//    private val SIGN_UP_REQUEST_CODE = 1
//    private val TAG = "SignInActivity"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        Log.d(TAG, "onCreate called")
//        setContentView(R.layout.activity_sign_in)
//
//        val emailEditText = findViewById<EditText>(R.id.emailEditText)
//        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
//        val signInButton: Button = findViewById(R.id.signInButton)
//        val signUpButton: Button = findViewById(R.id.signUpButton)
//
//        signUpButton.setOnClickListener {
//            val intent = Intent(this, SignUpActivity::class.java)
//            startActivityForResult(intent, SIGN_UP_REQUEST_CODE)
//        }
//
//        signInButton.setOnClickListener {
//            val email = emailEditText.text.toString()
//            val password = passwordEditText.text.toString()
//            val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
//
//            val savedEmail = sharedPreferences.getString("email", "")
//            val savedPassword = sharedPreferences.getString("password", "")
//
//            Log.d(TAG, "Saved Email: $savedEmail, Entered Email: $email")
//            Log.d(TAG, "Saved Password: $savedPassword, Entered Password: $password")
//
//            if (email == savedEmail && password == savedPassword) {
//                val homeIntent = Intent(this, HomeActivity::class.java)
//                startActivity(homeIntent)
//                finish()
//            } else {
//                Toast.makeText(this, "Неверные учетные данные", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == SIGN_UP_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
//            val userName = data.getStringExtra("userName")
//            val email = data.getStringExtra("email")
//
//            findViewById<EditText>(R.id.emailEditText).setText(email)
//            findViewById<TextView>(R.id.nameTextView).text = userName
//        }
//    }
//
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
