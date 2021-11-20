package com.example.pruebamaquetacion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TouristSitesAdapter(private val TouristSiteList : ArrayList<TouristSite>) : RecyclerView.Adapter<TouristSitesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_lista_de_actividades, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val touristSite = TouristSiteList[position]
        holder.bind(touristSite)
    }

    override fun getItemCount(): Int = TouristSiteList.size

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

        fun bind(touristSite: TouristSite){

        }

    }

}
