package com.example.lab_1

import java.io.Serializable

data class User(
    val userName: String,
    val email: String,
    val password: String)
    : Serializable
