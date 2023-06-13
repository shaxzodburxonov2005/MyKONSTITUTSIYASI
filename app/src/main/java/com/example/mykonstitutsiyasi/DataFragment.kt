package com.example.mykonstitutsiyasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mykonstitutsiyasi.databinding.FragmentDataBinding
import com.example.mykonstitutsiyasi.model.Substance


class DataFragment : Fragment() {
    lateinit var binding:FragmentDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_data, container, false)
        binding= FragmentDataBinding.bind(view)
        val n=arguments?.getSerializable("data") as Substance

        binding.nameTv.text=n.nameSubstance
        binding.desc.text=n.about

        binding.leftData.setOnClickListener {
            findNavController().popBackStack()
        }



        return view
    }


}