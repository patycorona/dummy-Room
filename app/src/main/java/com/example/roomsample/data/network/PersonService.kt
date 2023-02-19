package com.example.roomsample.data.network

import com.example.roomsample.data.model.request.PersonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PersonService @Inject constructor(private val api:PersonApiClient)  {

    suspend fun getPerson(): List<PersonModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPerson()
            response.body() ?: emptyList()
        }
    }
}