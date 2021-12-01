package com.grupoandroid.singaroute.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.grupoandroid.singaroute.databinding.FragmentDetailBinding
import com.grupoandroid.singaroute.main.MainActivity
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        (activity as MainActivity?)?.showIcon()

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
        }
    }

}