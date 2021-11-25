package com.example.pruebamaquetacion.list

import TouristSiteItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebamaquetacion.R
import com.squareup.picasso.Picasso

class TouristSitesAdapter(
    private val touristSiteList: ArrayList<TouristSiteItem>,
    private val onItemClicked: (TouristSiteItem) -> Unit ) :
    RecyclerView.Adapter<TouristSitesAdapter.TouristSiteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TouristSiteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_tourist_site_card_view, parent, false)

        return TouristSiteViewHolder(view)
    }

    override fun onBindViewHolder(holder: TouristSiteViewHolder, position: Int) {
        val touristSite = touristSiteList[position]
        holder.itemView.setOnClickListener{onItemClicked(touristSiteList[position])}
        holder.bind(touristSite)
    }

    override fun getItemCount(): Int = touristSiteList.size

    class TouristSiteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var siteImage: ImageView = itemView.findViewById(R.id.site_card_image_view)
        private var tittle: TextView = itemView.findViewById(R.id.tittle_card_text_view)
        private var likes: TextView = itemView.findViewById(R.id.likes_text_view)

        fun bind(touristSite: TouristSiteItem) {
            tittle.text = touristSite.tittle
            likes.text = touristSite.likes
            Picasso.get().load(touristSite.urlPicture).into(siteImage)
        }

    }

}
