package com.example.singarroute.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.singarroute.R
import com.example.singarroute.databinding.FragmentDetailBinding
import com.example.singarroute.model.TouristSite


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val touristsites = args.touristsites

        with(detailBinding){
            tittleTextView.text = touristsites.tittle
            descriptionTextView.text = touristsites.description
            locationTextView.text = touristsites.location
            likesTextView.text = touristsites.likes
            com.squareup.picasso.Picasso.get().load(touristsites.urlPicture).into(pictureImageView)
        }
    }




}