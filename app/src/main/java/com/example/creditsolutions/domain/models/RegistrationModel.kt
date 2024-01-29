package com.example.creditsolutions.domain.models

data class RegistrationModel(
    val succeed: Boolean,
    val confirmationToken: String?,
    val userId: String?,
    val errors: Map<String, String>?
)