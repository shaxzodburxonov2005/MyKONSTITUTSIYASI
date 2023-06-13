package com.example.mykonstitutsiyasi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mykonstitutsiyasi.adapter.AdapterNews
import com.example.mykonstitutsiyasi.databinding.FragmentInfoBinding
import com.example.mykonstitutsiyasi.model.Chap
import com.example.mykonstitutsiyasi.model.Department


class InfoFragment : Fragment() {
    lateinit var binding:FragmentInfoBinding
    lateinit var adapterNews: AdapterNews
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_info, container, false)
        binding= FragmentInfoBinding.bind(view)

        val bind=arguments?.getSerializable("name") as Department

        adapterNews= AdapterNews(bind.chap,object :AdapterNews.ItemClick{
            override fun root(chap: Chap, position: Int) {
                val bundle=Bundle()
                bundle.putSerializable("next",chap)
                findNavController().navigate(R.id.action_infoFragment_to_substanceFragment,bundle)
            }

        })

        binding.rv.adapter=adapterNews

        binding.texbunde.text=bind.name

        binding.leftInfo.setOnClickListener {
            findNavController().popBackStack()
        }



        return view
    }



}