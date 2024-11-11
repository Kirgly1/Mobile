package com.example.lab_1


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), OnboardFragment.OnNavigationListener {

    private val registeredUsers = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigateToFragment(OnboardFragment())
        }
    }

    override fun navigateToSignIn() {
        navigateToFragment(SignInFragment())
    }

    override fun navigateToSignUp() {
        navigateToFragment(SignUpFragment())
    }

    private fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun registerUser(userName: String, email: String, password: String) {
        if (registeredUsers.any { it.email == email }) {
            Toast.makeText(this, "Пользователь с таким email уже существует", Toast.LENGTH_SHORT).show()
        } else {
            val user = User(userName, email, password)
            registeredUsers.add(user)
            Toast.makeText(this, "Пользователь $userName зарегистрирован", Toast.LENGTH_SHORT).show()
            navigateToFragment(SignInFragment())
        }
    }

    fun loginUser(email: String, password: String) {
        val user = registeredUsers.find { it.email == email }
        if (user != null && user.password == password) {
            Toast.makeText(this, "Авторизация успешна!", Toast.LENGTH_SHORT).show()
            navigateToFragment(HomeFragment())
        } else {
            Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
        }
    }
}
