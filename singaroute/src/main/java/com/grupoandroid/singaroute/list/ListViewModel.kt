package com.grupoandroid.singaroute.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.grupoandroid.singaroute.model.TouristSite
import com.grupoandroid.singaroute.model.TouristSiteItem
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var touristsitesLoad: MutableLiveData<ArrayList<TouristSiteItem>> = MutableLiveData()
    val onTouristsitesLoaded: LiveData<ArrayList<TouristSiteItem>> = touristsitesLoad

    fun loadMockTouristSitesFromJson(touristSitesString: InputStream?) {
        val touristSitesString = touristSitesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        touristsitesLoad.value = gson.fromJson(touristSitesString, TouristSite::class.java)
    }
}