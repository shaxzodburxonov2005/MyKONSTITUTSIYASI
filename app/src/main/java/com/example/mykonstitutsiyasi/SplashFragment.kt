package com.example.mykonstitutsiyasi

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.mykonstitutsiyasi.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    lateinit var binding:FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_splash, container, false)
        binding= FragmentSplashBinding.bind(view)

        Handler(Looper.myLooper()!!).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
        },5000)
        val animTop= AnimationUtils.loadAnimation(view.context, R.anim.from_top)
        val animBottom= AnimationUtils.loadAnimation(view.context, R.anim.from_bottom)
        binding.kons.animation=animTop
        binding.konstext.animation=animBottom


        return view
    }


}