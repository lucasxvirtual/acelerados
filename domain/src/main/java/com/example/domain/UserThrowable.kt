package com.example.domain

class EmailThrowable: Throwable("invalid email")

class Phone1Throwable: Throwable("invalid phone1")

class Phone2Throwable: Throwable("invalid phone2")

class CnpjThrowable: Throwable("invalid cnpj")

class PostalThrowable: Throwable("invalid postal code")

class PasswordTooSmallThrowable: Throwable("password too small")

class PasswordDoesNotMatchThrowable: Throwable("password does not match")