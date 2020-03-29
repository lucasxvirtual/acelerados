package com.example.domain.usecase

import com.example.domain.*
import com.example.domain.ext.isAddressPostal
import com.example.domain.ext.isCnpj
import com.example.domain.ext.isEmail
import com.example.domain.ext.isPhone
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(private val userRepository: UserRepository) {

    sealed class Result {
        object Loading : Result()
        data class Success(val user: User) : Result()
        data class Failure(val throwableList: List<Throwable>) : Result()
    }

    fun execute(token: String,
                name: String?,
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
                cnpj: String?,
                addressNeighborhood: String?,
                password: String?): Observable<Result> {

        val throwableList = arrayListOf<Throwable>()

        if(phone1 != null && !phone1.isPhone())
            throwableList.add(Phone1Throwable())

        if(phone2 != null && !phone2.isPhone())
            throwableList.add(Phone2Throwable())

        if(cnpj != null && !cnpj.isCnpj())
            throwableList.add(CnpjThrowable())

        if(addressPostal != null && !addressPostal.isAddressPostal())
            throwableList.add(PostalThrowable())

        if(throwableList.isNotEmpty()){
            return Observable.defer { Observable.just(Result.Failure(throwableList)) }
        }

        return userRepository.createUser(name,
            email,
            phone1,
            phone2,
            cnpj,
            addressPostal,
            addressNumber,
            addressNeighborhood,
            password)
            .toObservable()
            .map { Result.Success(it) as Result }
            .onErrorReturn { Result.Failure(listOf(it)) }
            .startWith(Result.Loading)
    }

}