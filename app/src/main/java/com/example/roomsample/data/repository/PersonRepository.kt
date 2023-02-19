package com.example.roomsample.data.repository

import com.example.roomsample.data.database.dao.PersonDao
import com.example.roomsample.data.database.entities.PersonEntity
import com.example.roomsample.data.model.request.PersonModel
import com.example.roomsample.data.network.PersonService
import com.example.roomsample.domain.model.Person
import com.example.roomsample.domain.model.toDomain
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private var api: PersonService,
    private  val personDao:PersonDao
    ) {

    suspend fun getAllPersonFromApi(): List<Person> {
        val response: List<PersonModel> = api.getPerson()
        return response.map { it.toDomain() }
    }

    suspend fun getAllPersonFromDatabase():List<Person>{
        val response: List<PersonEntity> = personDao.getAllPerson()
        return response.map { it.toDomain() }
    }

    suspend fun insertPerson(persons: List<PersonEntity>){
        personDao.insertPerson(persons)
    }

    suspend fun clearPerson(){
        personDao.deleteAllPerson()
    }

}