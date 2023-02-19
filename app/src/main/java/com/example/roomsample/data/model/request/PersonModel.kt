package com.example.roomsample.data.model.request

import com.google.gson.annotations.SerializedName

data class PersonModel(
    @SerializedName("Name") val name: String,
    @SerializedName("age") val age: String,
    @SerializedName("address") val address: String
)
