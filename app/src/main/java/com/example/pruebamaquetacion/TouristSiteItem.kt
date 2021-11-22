package com.example.pruebamaquetacion


import com.google.gson.annotations.SerializedName

data class TouristSiteItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("tittle")
    val tittle: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("likes")
    val likes: String
)