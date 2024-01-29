package com.example.creditsolutions.domain.models.authmodels

data class ConfirmEmailRequestModel(
    private val code: String,
    private val userId: String,
    private val token: String)