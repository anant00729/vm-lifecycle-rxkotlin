package com.an2t.mnsapp.auth

data class LoginRes(
    val message: String,
    val pass: String,
    val status: Boolean,
    val username: String
)