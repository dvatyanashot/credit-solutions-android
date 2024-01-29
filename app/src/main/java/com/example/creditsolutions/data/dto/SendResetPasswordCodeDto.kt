package com.example.creditsolutions.data.dto

import com.example.creditsolutions.domain.models.SendResetPasswordCodeModel

class SendResetPasswordCodeDto(
    val email: String
)

fun SendResetPasswordCodeDto.toSendResetPasswordCodeModel(): SendResetPasswordCodeModel {
    return SendResetPasswordCodeModel(
        email = email
    )
}