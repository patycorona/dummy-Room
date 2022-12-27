package com.example.roomsample.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomsample.data.database.entities.PersonEntity

interface PersonDao {

    @Query("SELECT * FROM PersonEntity")
    //para hacer que nos responda de forma reactiva utilizamos live data
    //fun getAllPerson(): LiveData<List<PersonEntity>>
    suspend fun getAllPerson(): LiveData<List<PersonEntity>>

    @Query("SELECT * FROM PersonEntity WHERE id = :Id")
    //utilizamos suspend para trabajar con corutinas y
    // que no se ejecuten en el hilo principal.
    suspend fun getByIdPerson(Id: Int): PersonEntity

    @Update
    suspend fun upDatePerson(personEntity: PersonEntity)

    @Insert
    suspend fun insertPerson(people : List<PersonEntity>)

    @Delete
    suspend fun deletePerson(personEntity: PersonEntity)


}