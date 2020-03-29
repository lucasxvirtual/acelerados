package com.example.domain.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val gender: String,
    val facebookId: String,
    val addressPostal: String,
    val addressState: String,
    val addressCity: String,
    val addressStreet: String,
    val addressNumber: Int,
    val addressComplement: String,
    val cnpj: String,
    val phone1: String,
    val phone2: String,
    val profileImageUrl: String,
    val status: Int,
    val type: Int,
    val info: String,
    val token: String,
    val admin: Boolean,
    val createdAt: String,
    val updatedAt: String
)