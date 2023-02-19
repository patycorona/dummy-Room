package com.example.roomsample.ui.view

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.roomsample.AndroidApplication
import com.example.roomsample.R
import com.example.roomsample.data.database.database.PeopleDb
import com.example.roomsample.databinding.ActivityMainBinding
import com.example.roomsample.ui.viewmodel.PersonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val personViewModel: PersonViewModel by viewModels()

    val app = applicationContext as AndroidApplication
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        personViewModel.onCreate()

        personViewModel.personModel.observe(this, Observer {
            binding.tvName.text = it.name
            binding.tvAddress.text = it.address
        })
        personViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        binding.viewContainer.setOnClickListener { personViewModel.randomPerson() }

        lifecycleScope.launch{
            val people = app.room.personDao().getAllPerson()

             Log.d(TAG,"onCreate: ${people} people ")
        }
    }

}
