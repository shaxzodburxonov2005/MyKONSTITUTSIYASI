package com.example.mykonstitutsiyasi.adapter

import android.util.Log
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykonstitutsiyasi.databinding.ItemDepartmentBinding
import com.example.mykonstitutsiyasi.model.Chap
import com.example.mykonstitutsiyasi.model.Department


class AdapterNews(val list: ArrayList<Chap>,var itemclick:ItemClick) :
    RecyclerView.Adapter<AdapterNews.LastViewHolder>() {

    inner class LastViewHolder(val binding: ItemDepartmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Chap, position: Int) {
            Log.d("AAAA", "bind:$position $article ")
            binding.let {
                it.textDepartment.text=article.nameSt
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
        fun root(chap: Chap,position: Int)
    }
}

