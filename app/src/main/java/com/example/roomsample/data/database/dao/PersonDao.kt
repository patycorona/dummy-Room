package com.example.roomsample.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.roomsample.data.database.entities.PersonEntity

@Dao
interface PersonDao {

    @Query("SELECT * FROM person_table ORDER BY name DESC")
    suspend fun getAllPerson(): List<PersonEntity>
    //para hacer que nos responda de forma reactiva utilizamos live data
    //fun getAllPerson(): LiveData<List<PersonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(people : List<PersonEntity>)

    //    @Query("SELECT * FROM person_table WHERE id = :Id")
    //    utilizamos suspend para trabajar con corutinas y
    //    que no se ejecuten en el hilo principal.
    //    suspend fun getByIdPerson(Id: Int): PersonEntity

    @Update// esto no lo explica no se bien como escribirlo preguntar a marco
    suspend fun upDatePerson(personEntity: PersonEntity)

    @Query("DELETE FROM person_table")
    suspend fun deleteAllPerson()


}