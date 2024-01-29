package com.example.creditsolutions.common

sealed class ResponseModel<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T? = null) : ResponseModel<T>(data)
    class Error<T>(message: String? = null, data : T? = null) : ResponseModel<T>(data, message)
    class Loading<T> : ResponseModel<T>()
}