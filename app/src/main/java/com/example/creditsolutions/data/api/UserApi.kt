package com.example.creditsolutions.data.api

import com.example.creditsolutions.common.ResponseModel
import com.example.creditsolutions.data.dto.RegistrationResponseDto
import com.example.creditsolutions.data.dto.UserLoginDto
import com.example.creditsolutions.data.dto.SendResetPasswordCodeDto
import com.example.creditsolutions.domain.models.authmodels.ChangePasswordRequestModel
import com.example.creditsolutions.domain.models.authmodels.ConfirmEmailRequestModel
import com.example.creditsolutions.domain.models.authmodels.LoginRequestModel
import com.example.creditsolutions.domain.models.authmodels.RegistrationRequestModel
import com.example.creditsolutions.domain.models.authmodels.ResetPasswordSendCodeRequestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface UserApi {

    @POST("/api/User/login")
    suspend fun login(@Body model: LoginRequestModel): Response<UserLoginDto>

    @POST("/api/User/logout")
    suspend fun logout(): Response<ResponseModel<Any>>

    @POST("/api/User/register")
    suspend fun register(@Body model: String): Response<RegistrationResponseDto>

    @POST("/api/User/send-confirmation-code")
    suspend fun sendConfirmationCode(@Query("userId") userId: String): Response<ResponseModel<Any>>

    @POST("/api/User/confirm-email")
    suspend fun confirmEmail(@Body model: ConfirmEmailRequestModel): Response<ResponseModel<Any>>

    @POST("/api/User/send-reset-password-code")
    suspend fun sendResetPasswordCode(@QueryMap model: ResetPasswordSendCodeRequestModel): Response<SendResetPasswordCodeDto>

    @POST("/api/User/reset-password")
    suspend fun resetPassword(@QueryMap map: MutableMap<String, Any>): Response<ResponseModel<Any>>

    @POST("/api/User/change-password")
    suspend fun changePassword(@Body model: ChangePasswordRequestModel): Response<ResponseModel<Any>>


}