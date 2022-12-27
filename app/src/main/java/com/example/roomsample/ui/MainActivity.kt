package com.example.roomsample.ui

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.roomsample.AndroidApplication
import com.example.roomsample.R
import com.example.roomsample.data.database.database.PeopleDb
import com.example.roomsample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val app = applicationContext as AndroidApplication
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch{
            val people = app.room.personDao().getAllPerson()

             Log.d(TAG,"onCreate: ${people} people ")
        }
    }
}