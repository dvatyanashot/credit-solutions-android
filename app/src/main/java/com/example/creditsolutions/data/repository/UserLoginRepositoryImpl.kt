package com.example.creditsolutions.data.repository

import com.example.creditsolutions.common.ResponseModel
import com.example.creditsolutions.data.api.UserApi
import com.example.creditsolutions.data.dto.SendResetPasswordCodeDto
import com.example.creditsolutions.data.dto.UserLoginDto
import com.example.creditsolutions.data.dto.ErrorBodyResponseDto
import com.example.creditsolutions.data.dto.RegistrationResponseDto
import com.example.creditsolutions.domain.models.RegistrationModel
import com.example.creditsolutions.domain.models.authmodels.ChangePasswordRequestModel
import com.example.creditsolutions.domain.models.authmodels.ConfirmEmailRequestModel
import com.example.creditsolutions.domain.models.authmodels.LoginRequestModel
import com.example.creditsolutions.domain.models.authmodels.ResetPasswordSendCodeRequestModel
import com.example.creditsolutions.domain.repository.UserLoginRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserLoginRepositoryImpl @Inject constructor(private val api: UserApi) : UserLoginRepository {

    override suspend fun login(model: LoginRequestModel): Flow<ResponseModel<UserLoginDto>> = flow {
        emit(ResponseModel.Loading())
        val response = api.login(model)
        val result = response.body()
        val errorResponse = response.errorBody()
        if (response.isSuccessful && result != null) {
            emit(ResponseModel.Success(result))

        } else if (errorResponse != null) {
            val errorBodyString = errorResponse.charStream().readText()
            val errorBody = Gson().fromJson(errorBodyString, ErrorBodyResponseDto::class.java)
            val message = if (errorBody.errors?.email != null) {
                errorBody.errors.email.firstOrNull()
            } else {
                errorBody.errors?.password?.firstOrNull()
            }
            emit(ResponseModel.Error(message))
        }
    }.catch {
        emit(ResponseModel.Error("Something Wrong"))

    }

    override suspend fun registration(model: String): Flow<ResponseModel<RegistrationResponseDto>> =
        flow {

            emit(ResponseModel.Loading())
            val response = api.register(model)
            val result = response.body()
            val errorResponse = response.errorBody()
            if (response.isSuccessful && result != null) {
                emit(ResponseModel.Success(result))

            } else if (errorResponse != null) {

            }
        }


    override suspend fun logout() {
        TODO("Not yet implemented")
    }

    override suspend fun sendConfirmationCode(userId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun confirmEmail(model: ConfirmEmailRequestModel) {
        TODO("Not yet implemented")
    }

    override suspend fun sendResetPasswordCode(model: ResetPasswordSendCodeRequestModel): SendResetPasswordCodeDto {
        TODO("Not yet implemented")
    }

    override suspend fun resetPassword(map: MutableMap<String, Any>) {
        TODO("Not yet implemented")
    }

    override suspend fun changePassword(model: ChangePasswordRequestModel) {
        TODO("Not yet implemented")
    }
}