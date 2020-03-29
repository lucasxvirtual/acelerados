package com.example.domain.usecase

import com.example.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

class ChangePasswordUseCase @Inject constructor(private val userRepository: UserRepository) {

    sealed class Result {
        object Loading : Result()
        data class Success(val string: String) : Result()
        data class Failure(val throwableList: List<Throwable>) : Result()
    }

    fun execute(oldPassword: String,
                newPassword: String,
                confirmPassword: String,
                token: String) : Observable<Result> {

        return userRepository.changePassword(oldPassword,
            newPassword,
            confirmPassword,
            token).toObservable()
            .map { Result.Success(it) as Result }
            .onErrorReturn { Result.Failure(listOf(it)) }
            .startWith(Result.Loading)

    }


}