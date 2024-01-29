package com.example.creditsolutions.presentation.authorization.login

import com.example.creditsolutions.domain.models.UserLoginModel

sealed class LoginState {
    data object InitialState : LoginState()
    data class Success(val data: UserLoginModel) : LoginState()
    data object Loading : LoginState()
    data class Error(val message : String) : LoginState()

}
