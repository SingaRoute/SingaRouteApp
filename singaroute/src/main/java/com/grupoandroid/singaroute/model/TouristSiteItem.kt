package com.grupoandroid.singaroute.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TouristSiteItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("likes")
    val likes: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("schedule")
    val schedule: String,
    @SerializedName("tittle")
    val tittle: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("latitud")
    val latitud: String,
    @SerializedName("longitud")
    val longitud: String
) : Serializable