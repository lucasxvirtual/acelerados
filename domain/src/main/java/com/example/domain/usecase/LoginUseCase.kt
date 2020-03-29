package com.example.domain.usecase

import com.example.domain.model.Auth
import com.example.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val userRepository: UserRepository) {

    sealed class Result {
        object Loading : Result()
        data class Success(val auth: Auth) : Result()
        data class Failure(val throwableList: List<Throwable>) : Result()
    }

    fun execute(username: String, password: String): Observable<Result> {

        return userRepository.login(username, password).toObservable()
            .map { Result.Success(it) as Result }
            .onErrorReturn { Result.Failure(listOf(it)) }
            .startWith(Result.Loading)

    }

}