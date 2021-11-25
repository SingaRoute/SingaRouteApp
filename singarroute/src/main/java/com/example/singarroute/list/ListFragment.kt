package com.example.singarroute.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.singarroute.databinding.FragmentListBinding
import com.example.singarroute.model.TouristSite
import com.example.singarroute.model.TouristSiteItem
import com.google.gson.Gson


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var touristSitesAdapter: TouristSitesAdapter
    private lateinit var listTouristSites: ArrayList<TouristSiteItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listBinding = FragmentListBinding.inflate(inflater,container,false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listTouristSites = loadMockTouristSitesFromJson()
        touristSitesAdapter = TouristSitesAdapter(listTouristSites, onItemClicked={onTouristSitesClicked(it)})
        listBinding.touristSitesRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = touristSitesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onTouristSitesClicked(touristsites: TouristSiteItem) {

        findNavController().navigate(ListFragmentDirections.actionListFragment2ToDetailFragment(touristsites = touristsites))
    }

    private fun loadMockTouristSitesFromJson(): ArrayList<TouristSiteItem> {
        val TouristSitesString: String = context?.assets?.open("TouristSites.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val TouristSitesList = gson.fromJson(TouristSitesString, TouristSite::class.java)

        return TouristSitesList
    }

}