package com.example.roomsample.domain.usecase

import com.example.roomsample.data.database.entities.toDataBase
import com.example.roomsample.data.repository.PersonRepository
import com.example.roomsample.domain.model.Person
import javax.inject.Inject

class PersonUseCase @Inject constructor(private val personRepository: PersonRepository) {
    suspend operator fun invoke():List<Person>{
        val persons = personRepository.getAllPersonFromApi()

        return if(persons.isNotEmpty()){
            personRepository.clearPerson()
            personRepository.insertPerson(persons.map{it.toDataBase()})
            persons
        }else{
            personRepository.getAllPersonFromDatabase()
        }
    }
}