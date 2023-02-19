package com.example.roomsample.platform.di.module

import android.content.Context
import androidx.room.Room
import com.example.roomsample.data.database.dao.PersonDao
import com.example.roomsample.data.database.database.PeopleDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val PEOPLE_DATABASE_NAME ="people_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext contex :Context) =
        Room.databaseBuilder(contex, PeopleDb::class.java, PEOPLE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun providePersonDao(db: PeopleDb) = db.personDao()

}