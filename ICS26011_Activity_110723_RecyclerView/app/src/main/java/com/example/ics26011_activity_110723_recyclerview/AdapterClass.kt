package com.example.ics26011_activity_110723_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(val dataList : ArrayList<DataClass>) : RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        var currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text = currentItem.dataTitle
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rvImage : ImageView = itemView.findViewById(R.id.recyclerImage)
        var rvTitle : TextView = itemView.findViewById(R.id.txtTitle)
    }
}