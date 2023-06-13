package com.example.mykonstitutsiyasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mykonstitutsiyasi.databinding.FragmentSubstanceBinding
import com.example.mykonstitutsiyasi.model.Chap
import com.example.mykonstitutsiyasi.model.Substance
import com.example.mykonstitutsiyasi.model.SubstanceAdapter


class SubstanceFragment : Fragment() {
    lateinit var adapter: SubstanceAdapter
    lateinit var binding:FragmentSubstanceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_substance, container, false)
        binding= FragmentSubstanceBinding.bind(view)

        val a=arguments?.getSerializable("next")as Chap
        adapter= SubstanceAdapter(a.substance,object :SubstanceAdapter.ItemClick{
            override fun root(chap: Substance, position: Int) {
                val bundle=Bundle()
                bundle.putSerializable("data",chap)
                findNavController().navigate(R.id.action_substanceFragment_to_dataFragment,bundle)
            }

        })


        binding.rvSub.adapter=adapter
        binding.leftSub.setOnClickListener {
            findNavController().popBackStack()
        }


        return view
    }


}