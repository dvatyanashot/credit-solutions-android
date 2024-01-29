package com.example.creditsolutions.data.dto

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorBodyResponseDto(
    val type: String?,
    val title: String?,
    val status: Int?,
    val traceId: String?,
    val errors: Errors?
)


@JsonClass(generateAdapter = true)
data class Errors(
    @SerializedName("Email")
    val email: List<String?>?,
    @SerializedName("Password")
    val password: List<String?>?
)