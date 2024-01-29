package com.example.creditsolutions.domain.models

import com.example.creditsolutions.data.dto.UserLoginDto

data class UserLoginModel(
    val succeeded: Boolean?,
    val errors: Map<String, String>,
    )
