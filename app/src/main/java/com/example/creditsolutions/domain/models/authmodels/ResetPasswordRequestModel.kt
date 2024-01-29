package com.example.creditsolutions.domain.models.authmodels

class ResetPasswordRequestModel(
    private val userId: String,
    private val token: String,
    private  val newPassword: String)
