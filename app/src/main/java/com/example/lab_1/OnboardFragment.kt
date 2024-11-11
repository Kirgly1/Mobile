package com.example.lab_1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.lab_1.R

class OnboardFragment() : Fragment() {

    interface OnNavigationListener {
        fun navigateToSignIn()
        fun navigateToSignUp()
    }

    private var navigationListener: OnNavigationListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnNavigationListener) {
            navigationListener = context
        } else {
            throw RuntimeException("$context must implement OnNavigationListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        navigationListener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboard, container, false)

        val signInButton: Button = view.findViewById(R.id.signInButton)
        val signUpButton: Button = view.findViewById(R.id.signUpButton)

        signInButton.setOnClickListener {
            navigationListener?.navigateToSignIn()
        }

        signUpButton.setOnClickListener {
            navigationListener?.navigateToSignUp()
        }
        return view
    }
}
