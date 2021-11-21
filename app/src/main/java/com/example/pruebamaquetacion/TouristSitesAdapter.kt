package com.example.pruebamaquetacion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class TouristSitesAdapter(private val TouristSiteList: ArrayList<TouristSite>) :
    RecyclerView.Adapter<TouristSitesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_lista_de_actividades, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val touristSite = TouristSiteList[position]
        holder.bind(touristSite)
    }

    override fun getItemCount(): Int = TouristSiteList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var siteImage: ImageView = itemView.findViewById(R.id.site_image_view)
        private var tittle: TextView = itemView.findViewById(R.id.tittle_text_view)

        fun bind(touristSite: TouristSite) {
            tittle.text = touristSite.tittle
            Picasso.get().load(touristSite.urlPicture).into(siteImage)
        }

    }

}
