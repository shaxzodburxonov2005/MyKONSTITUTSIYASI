package com.example.mykonstitutsiyasi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.mykonstitutsiyasi.R
import com.example.mykonstitutsiyasi.databinding.ItemChildBinding
import com.example.mykonstitutsiyasi.model.Category

class ExpAdapter(val listCity:ArrayList<String>,
                 var listWord:HashMap<String,ArrayList<Category>>
                 ) :BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return listCity.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return listWord[listCity[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return listCity[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Category {
        return listWord[listCity[groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemView: View = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item_parent, parent, false)
        val bind=ItemChildBinding.bind(itemView)
        val parentdata=getGroup(groupPosition)
        bind.child.text= parentdata.toString()

        return itemView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemView: View = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item_child, parent, false)
        val bind=ItemChildBinding.bind(itemView)
        val childData=getChild(groupPosition,childPosition)
        bind.child.text= childData.name

        return itemView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}