package com.example.pruebamaquetacion.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebamaquetacion.R
import com.example.pruebamaquetacion.model.TouristSite
import com.example.pruebamaquetacion.model.TouristSiteItem
import com.google.gson.Gson

class ListaDeActividadesActivity: AppCompatActivity() {

    private lateinit var sitesList: ArrayList<TouristSiteItem>
    private lateinit var sitesAdapter: TouristSitesAdapter
    private lateinit var sitesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_actividades)

        sitesRecyclerView = findViewById(R.id.tourist_sites_recycler_view)

        sitesList = loadMockTouristSites()
        sitesAdapter = TouristSitesAdapter(sitesList)

        sitesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = sitesAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockTouristSites(): ArrayList<TouristSiteItem> {
        val touristSiteString: String = applicationContext.assets.open("TouristSites.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(touristSiteString, TouristSite::class.java )
        return data
    }
}