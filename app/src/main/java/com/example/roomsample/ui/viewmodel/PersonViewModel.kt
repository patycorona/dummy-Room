package com.example.roomsample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomsample.domain.model.Person
import com.example.roomsample.domain.usecase.PersonUseCase
import com.example.roomsample.domain.usecase.RandomPersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val personUseCase: PersonUseCase,
    private val RandomPersonalUseCase: RandomPersonUseCase
) : ViewModel() {

    val personModel = MutableLiveData<Person>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = personUseCase()

            if (!result.isNullOrEmpty()) {
                personModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomPerson() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val person = RandomPersonalUseCase()
            if (person != null) {
                personModel.value = person
            }
            isLoading.postValue(false)
        }
    }
}