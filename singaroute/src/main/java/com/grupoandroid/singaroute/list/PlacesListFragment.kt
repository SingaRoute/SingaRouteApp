package com.grupoandroid.singaroute.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grupoandroid.singaroute.R
import com.grupoandroid.singaroute.databinding.FragmentPlacesListBinding

class PlacesListFragment : Fragment() {

    private lateinit var listBinding: FragmentPlacesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentPlacesListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

}