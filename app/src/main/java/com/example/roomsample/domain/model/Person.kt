package com.example.roomsample.domain.model

import com.example.roomsample.data.database.entities.PersonEntity
import com.example.roomsample.data.model.request.PersonModel

data class Person(val name:String, val address:String)

fun PersonModel.toDomain() = Person(name, address)
fun PersonEntity.toDomain() = Person(name, address)