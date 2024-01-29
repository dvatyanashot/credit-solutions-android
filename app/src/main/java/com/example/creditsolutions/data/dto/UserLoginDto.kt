package com.example.creditsolutions.data.dto


import com.example.creditsolutions.domain.models.UserLoginModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserLoginDto(
    val data: Data?,
    val errors: List<ResponseErrorsDto?>?,
    val succeeded: Boolean?
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        val basePhone: String?,
        val birthDate: String?,
        val confirmationToken: String?,
        val coverUrl: String?,
        val email: String?,
        val id: Int?,
        val name: String?,
        val profileUrl: String?,
        val surname: String?,
        val userId: String?,
        val userName: String?,
        val userRoleId: Int?
    )

}

fun UserLoginDto.toLoginModel(): UserLoginModel {
    val map = mutableMapOf<String, String>()
    errors?.forEach {responseErrors ->
        responseErrors?.errors?.forEach {
            map["code"] = it?.code.toString()
            map["description"] = it?.description.toString()
        }
    }
    return UserLoginModel(
        succeeded = succeeded,
        errors = map.toMap(),
    )

}