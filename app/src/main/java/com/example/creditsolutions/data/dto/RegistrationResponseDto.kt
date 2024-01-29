package com.example.creditsolutions.data.dto


import com.example.creditsolutions.domain.models.RegistrationModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegistrationResponseDto(
    val succeeded: Boolean,
    val errors: List<ResponseErrorsDto?>?,
    val data: Data?
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        val confirmationToken: String?,
        val userId: String?
    )
}

fun RegistrationResponseDto.toRegistrationModel(): RegistrationModel{
    val map = mutableMapOf<String, String>()
    errors?.forEach {responseErrors ->
        responseErrors?.errors?.forEach {
            map["code"] = it?.code.toString()
            map["description"] = it?.description.toString()
        }
    }
    return RegistrationModel(
        succeed = succeeded,
        confirmationToken = data?.confirmationToken.toString(),
        userId = data?.userId.toString(),
        errors = map.toMap()
    )
}