package com.grupoandroid.singaroute.data

class TouristSiteRepository {
    suspend fun getTouristSites() = ApiFactory.retrofit.getTouristSites()
}