package com.example.pruebamaquetacion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaDeActividadesActivity: AppCompatActivity() {

    private lateinit var touristSitesAdapter: TouristSitesAdapter
    private lateinit var touristSitesRecyclewView: RecyclerView
    private lateinit var touristSitesList: ArrayList<TouristSite>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_actividades)

        touristSitesRecyclewView = findViewById(R.id.tourist_sites_recycler_view)

        touristSitesList = loadMockTouristSites()
        touristSitesAdapter = TouristSitesAdapter(touristSitesList)

        touristSitesRecyclewView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = touristSitesAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockTouristSites(): ArrayList<TouristSite> {
        var touristSiteString: String = applicationContext.assets.open("TouristSites.json").bufferedReader().use { it.readText() }
    }
}