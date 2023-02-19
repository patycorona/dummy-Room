package com.example.roomsample.domain.usecase

import com.example.roomsample.data.repository.PersonRepository
import com.example.roomsample.domain.model.Person
import javax.inject.Inject

class RandomPersonUseCase @Inject constructor(private val repository: PersonRepository) {

    suspend operator fun invoke(): Person? {
        val persons = repository.getAllPersonFromDatabase()
        if (!persons.isNullOrEmpty()) {
            val randomNumber = (persons.indices).random()
            return persons[randomNumber]
        }
        return null
    }
}