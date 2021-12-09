package com.grupoandroid.singaroute.ui.main.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.navigation.fragment.findNavController
import com.grupoandroid.singaroute.databinding.FragmentDetailBinding
import com.grupoandroid.singaroute.model.TouristSiteItem
import com.grupoandroid.singaroute.ui.main.main.MainActivity
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return  detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val place = args.place

        with(detailBinding){
            tittleTextView.text = place.tittle
            descriptionTextView.text = place.description
            scheduleTextView.text = place.schedule
            locationTextView.text = place.location
            Picasso.get().load(place.urlPicture).into(locationImageView)

            mapButton.setOnClickListener{
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment(
                    lat = place.latitud, lon = place.longitud
                ))
            }
        }
    }

}