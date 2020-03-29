package com.example.domain.repository

import com.example.domain.model.Auth
import com.example.domain.model.User
import io.reactivex.Single

interface UserRepository {

    fun createUser(name: String,
                   email: String,
                   phone1: String,
                   phone2: String,
                   cnpj: String,
                   addressPostal: String,
                   addressNumber: Int,
                   addressNeighborhood: String,
                   password: String): Single<User>

    fun login(username: String,
              password: String): Single<Auth>

    fun getUser(token: String): Single<User>

    fun updateUser(token: String,
                   name: String?,
                   email: String?,
                   gender: String?,
                   facebookId: String?,
                   addressState: String?,
                   addressCity: String?,
                   addressStreet: String?,
                   addressPostal: String?,
                   addressNumber: Int?,
                   addressComplement: String?,
                   phone1: String?,
                   phone2: String?,
                   profileImageUrl: String?,
                   status: Int?,
                   type: Int?,
                   info: String?,
                   cnpj: String?,
                   addressNeighborhood: String?,
                   password: String?): Single<User>

    fun forgotPassword(email: String): Single<String>

    fun changePassword(oldPassword: String,
                       newPassword: String,
                       confirmPassword: String,
                       token: String): Single<String>

}