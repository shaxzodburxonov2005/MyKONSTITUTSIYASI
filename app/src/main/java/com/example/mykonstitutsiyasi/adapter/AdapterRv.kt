package com.example.mykonstitutsiyasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mykonstitutsiyasi.databinding.ItemDepartmentBinding
import com.example.mykonstitutsiyasi.model.Department


class AdapterRv(

    var clickItem: itemClick
):
    ListAdapter<Department, AdapterRv.PostViewHolder>(
        DiffCallBack()
    ) {


    class DiffCallBack : DiffUtil.ItemCallback<Department>() {
        override fun areItemsTheSame(oldItem: Department, newItem: Department): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Department, newItem: Department): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ItemDepartmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class PostViewHolder(val binding: ItemDepartmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(department: Department, position: Int) {
            binding.let { view ->
                view.textDepartment.text = department.name
                view.root.setOnClickListener {
                    clickItem.root(department,position)
                }
            }
        }
    }

    interface itemClick {
        fun root(department: Department,position: Int)
    }

}
