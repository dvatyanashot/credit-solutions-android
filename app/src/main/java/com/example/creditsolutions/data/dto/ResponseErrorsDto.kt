package com.example.creditsolutions.data.dto


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseErrorsDto(
    val errors: List<Error?>?,
) {
    @JsonClass(generateAdapter = true)
    data class Error(
        val code: String?,
        val description: String?
    )
}