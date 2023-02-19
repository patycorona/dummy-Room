package com.example.roomsample.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.roomsample.domain.model.Person

@Entity(tableName = "person_table")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age:Int = 0,
    @ColumnInfo(name = "address") val address: String
)

fun Person.toDataBase() = PersonEntity(name = name, address = address)