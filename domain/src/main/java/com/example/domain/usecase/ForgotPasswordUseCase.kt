package com.example.domain.usecase

import com.example.domain.EmailThrowable
import com.example.domain.ext.isEmail
import com.example.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

class ForgotPasswordUseCase @Inject constructor(private val userRepository: UserRepository) {

    sealed class Result {
        object Loading : Result()
        data class Success(val string: String) : Result()
        data class Failure(val throwableList: List<Throwable>) : Result()
    }

    fun execute(email: String): Observable<Result> {

        if(!email.isEmail()){
            return Observable.defer { Observable.just(Result.Failure(listOf(EmailThrowable()))) }
        }

        return userRepository.forgotPassword(email).toObservable()
            .map { Result.Success(it) as Result }
            .onErrorReturn { Result.Failure(listOf(it)) }
            .startWith(Result.Loading)

    }

}