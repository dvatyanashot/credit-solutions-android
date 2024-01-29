package com.example.creditsolutions.presentation.authorization.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.creditsolutions.common.ResponseModel
import com.example.creditsolutions.data.dto.toLoginModel
import com.example.creditsolutions.domain.models.UserLoginModel
import com.example.creditsolutions.domain.models.authmodels.LoginRequestModel
import com.example.creditsolutions.domain.repository.UserLoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UserLoginRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<LoginState>(LoginState.InitialState)
    val state
        get() = _state.asStateFlow()

    suspend fun onEnterButtonClick(model: LoginRequestModel) {
        _state.value = LoginState.Loading
        repository.login(model).onEach {
            when (it) {
                is ResponseModel.Error -> _state.value = LoginState.Error(it.message?:"")
                is ResponseModel.Success -> _state.value =
                    LoginState.Success(it.data!!.toLoginModel())

                is ResponseModel.Loading -> _state.value = LoginState.Loading
            }

        }.launchIn(viewModelScope)
    }


}