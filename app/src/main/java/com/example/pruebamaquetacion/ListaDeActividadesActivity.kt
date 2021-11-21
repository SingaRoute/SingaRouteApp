package com.example.pruebamaquetacion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListaDeActividadesActivity: AppCompatActivity() {

    private lateinit var touristSitesList: ArrayList<TouristSiteItem>
    private lateinit var touristSitesAdapter: TouristSitesAdapter
    private lateinit var touristSitesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_actividades)

        touristSitesRecyclerView = findViewById(R.id.tourist_sites_recycler_view)

        touristSitesList = loadMockTouristSites()
        touristSitesAdapter = TouristSitesAdapter(touristSitesList)

        touristSitesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = touristSitesAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockTouristSites(): ArrayList<TouristSiteItem> {
        val touristSiteString: String =
            applicationContext.assets.open("TouristSites.json").bufferedReader()
                .use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(touristSiteString, TouristSite::class.java)
        return data
    }
}