package com.example.mykonstitutsiyasi.model

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykonstitutsiyasi.adapter.AdapterNews
import com.example.mykonstitutsiyasi.databinding.ItemDepartmentBinding

data class SubstanceAdapter(val list: ArrayList<Substance>,var itemclick:ItemClick) :
    RecyclerView.Adapter<SubstanceAdapter.LastViewHolder>() {

    inner class LastViewHolder(val binding: ItemDepartmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Substance, position: Int) {
            Log.d("AAAA", "bind:$position $article ")
            binding.let {
                it.textDepartment.text=article.nameSubstance
                it.root.setOnClickListener {
                    itemclick.root(article,position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastViewHolder {
        return LastViewHolder(
            ItemDepartmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LastViewHolder, position: Int) {
        holder.bind(list[position], position)
    }
    interface ItemClick{
        fun root(chap: Substance,position: Int)
    }
}
