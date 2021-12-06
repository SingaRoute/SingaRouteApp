package com.grupoandroid.singaroute.data

import com.grupoandroid.singaroute.model.TouristSite
import retrofit2.http.GET


interface ApiService {

    @GET("SingaRoute/SingaRouteApp/touristsites")
    suspend fun getTouristSites(): TouristSite
}

