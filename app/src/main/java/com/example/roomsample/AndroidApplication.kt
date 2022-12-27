package com.example.roomsample

import android.app.Application
import androidx.room.Room
import com.example.roomsample.data.database.database.PeopleDb
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class AndroidApplication: Application() {
    val room = Room
        .databaseBuilder(this,PeopleDb::class.java,"PersonEntity")
        .build()
}