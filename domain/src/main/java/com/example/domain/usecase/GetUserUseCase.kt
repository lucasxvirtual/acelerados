package com.example.domain.usecase

import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    sealed class Result {
        object Loading : Result()
        data class Success(val auth: User) : Result()
        data class Failure(val throwableList: List<Throwable>) : Result()
    }

    fun execute(token: String): Observable<Result>{

        return userRepository.getUser(token).toObservable()
            .map { Result.Success(it) as Result }
            .onErrorReturn { Result.Failure(listOf(it)) }
            .startWith(Result.Loading)

    }

}