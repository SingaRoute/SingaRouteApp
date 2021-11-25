package com.example.pruebamaquetacion.detail

import TouristSiteItem
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebamaquetacion.databinding.ActivitySingapourBinding
import com.squareup.picasso.Picasso
import java.io.Serializable

class SingapourActivity : AppCompatActivity() {

    private lateinit var detailBinding : ActivitySingapourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivitySingapourBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val place: TouristSiteItem = intent.extras?.getSerializable("touristsite") as TouristSiteItem

        with(detailBinding){
            tittleTextView.text = place.tittle
            descriptionTextView.text = place.description
            scheduleTextView.text = place.schedule
            locationTextView.text = place.location
            Picasso.get().load(place.urlPicture).into(locationImageView)
        }


    }
}