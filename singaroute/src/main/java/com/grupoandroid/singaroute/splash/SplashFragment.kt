package com.grupoandroid.singaroute.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.grupoandroid.singaroute.R
import com.grupoandroid.singaroute.databinding.FragmentSplashBinding
import java.util.*
import kotlin.concurrent.thread
import kotlin.concurrent.timerTask

class SplashFragment : Fragment() {
    private lateinit var splashBinding: FragmentSplashBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        splashBinding = FragmentSplashBinding.inflate(inflater, container, false)

        return splashBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Thread.sleep(2000)
        goToPlacesListFragment()
    }

    private fun goToPlacesListFragment(){
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToNavigationList())
    }
}