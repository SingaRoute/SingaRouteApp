package com.grupoandroid.singaroute.list

import com.grupoandroid.singaroute.model.TouristSiteItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.grupoandroid.singaroute.databinding.FragmentPlacesListBinding
import com.grupoandroid.singaroute.main.MainActivity

class PlacesListFragment : Fragment() {

    private lateinit var listBinding: FragmentPlacesListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var sitesAdapter: TouristSitesAdapter
    private var sitesList: ArrayList<TouristSiteItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentPlacesListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listViewModel.loadMockTouristSitesFromJson(context?.assets?.open("TouristSites.json"))

        listViewModel.onTouristsitesLoaded.observe(viewLifecycleOwner, { result ->
            onTouristsitesLoadedSubscribe(result)
        })

        sitesAdapter = TouristSitesAdapter(sitesList, onItemClicked = { onSiteClicked(it) })

        listBinding.touristSitesRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = sitesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onTouristsitesLoadedSubscribe(result: ArrayList<TouristSiteItem>?) {
        result?.let { listTouristSites ->
            sitesAdapter.appendItems(listTouristSites)
            /*
            // TODO: revisar feedback
            this.listSuperheroes = listSuperheroes
            superHeroesAdapter.notifyDataSetChanged()
            */
        }
    }

    private fun onSiteClicked(touristsite: TouristSiteItem) {
        findNavController().navigate(PlacesListFragmentDirections.actionNavigationListToNavigationDetail( place = touristsite ))
    }

}