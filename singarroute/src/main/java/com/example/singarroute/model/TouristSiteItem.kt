package com.example.singarroute.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
) :Serializable