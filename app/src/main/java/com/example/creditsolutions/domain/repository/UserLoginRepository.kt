package com.example.creditsolutions.domain.repository

import com.example.creditsolutions.common.ResponseModel
import com.example.creditsolutions.data.dto.UserLoginDto
import com.example.creditsolutions.data.dto.RegistrationResponseDto
import com.example.creditsolutions.data.dto.SendResetPasswordCodeDto
import com.example.creditsolutions.domain.models.RegistrationModel
import com.example.creditsolutions.domain.models.authmodels.ChangePasswordRequestModel
import com.example.creditsolutions.domain.models.authmodels.ConfirmEmailRequestModel
import com.example.creditsolutions.domain.models.authmodels.LoginRequestModel
import com.example.creditsolutions.domain.models.authmodels.ResetPasswordSendCodeRequestModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface UserLoginRepository {
    suspend fun login(model : LoginRequestModel): Flow<ResponseModel<UserLoginDto>>
    suspend fun registration(model: String): Flow<ResponseModel<RegistrationResponseDto>>
    suspend fun logout()
    suspend fun sendConfirmationCode(userId: String)
    suspend fun confirmEmail(model: ConfirmEmailRequestModel)
    suspend fun sendResetPasswordCode(model: ResetPasswordSendCodeRequestModel): SendResetPasswordCodeDto
    suspend fun resetPassword(map: MutableMap<String, Any>)
    suspend fun changePassword(model: ChangePasswordRequestModel)
}