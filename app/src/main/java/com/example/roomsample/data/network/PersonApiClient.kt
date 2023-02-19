package com.example.roomsample.data.network

import com.example.roomsample.data.model.request.PersonModel
import retrofit2.Response
import retrofit2.http.GET

interface PersonApiClient {
    @GET("/.json")
    suspend fun getAllPerson(): Response<List<PersonModel>>
}