package com.grupoandroid.singaroute.list

import com.grupoandroid.singaroute.model.TouristSite
import com.grupoandroid.singaroute.model.TouristSiteItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.grupoandroid.singaroute.databinding.FragmentPlacesListBinding

class PlacesListFragment : Fragment() {

    private lateinit var listBinding: FragmentPlacesListBinding
    private lateinit var sitesAdapter: TouristSitesAdapter
    private lateinit var sitesList: ArrayList<TouristSiteItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentPlacesListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sitesList = loadMockTouristSites()
        sitesAdapter = TouristSitesAdapter(sitesList, onItemClicked = { onSiteClicked(it) })

        listBinding.touristSitesRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = sitesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onSiteClicked(touristsite: TouristSiteItem) {
        findNavController().navigate(PlacesListFragmentDirections.actionPlacesListFragmentToDetailFragment2(place = touristsite))
    }

    private fun loadMockTouristSites(): ArrayList<TouristSiteItem> {
        val touristSiteString: String = context?.assets?.open("TouristSites.json")?.bufferedReader().use { it!!.readText() } //TODO change this code to nullable
        val gson = Gson()
        val data = gson.fromJson(touristSiteString, TouristSite::class.java)
        return data
    }

}