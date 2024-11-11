package com.example.lab_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailEditText = view.findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordEditText)
        val signInButton = view.findViewById<Button>(R.id.signInButton)

        val registeredUser = arguments?.getSerializable("user") as? User

        if (emailEditText == null || passwordEditText == null || signInButton == null) {
            Toast.makeText(requireContext(), "Ошибка: не удалось найти элементы UI", Toast.LENGTH_SHORT).show()
            return
        }

        signInButton.setOnClickListener {
            val inputEmail = emailEditText.text.toString()
            val inputPassword = passwordEditText.text.toString()

            if (registeredUser != null && inputEmail == registeredUser.email && inputPassword == registeredUser.password) {
                val homeFragment = HomeFragment()

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, homeFragment)
                    .commit()
            } else {
                Toast.makeText(requireContext(), "Неверное имя пользователя или пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
