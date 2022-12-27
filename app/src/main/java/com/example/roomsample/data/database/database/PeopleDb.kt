package com.example.roomsample.data.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomsample.data.database.dao.PersonDao
import com.example.roomsample.data.database.entities.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class PeopleDb: RoomDatabase() {
    abstract fun personDao(): PersonDao
}