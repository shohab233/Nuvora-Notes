package com.nuvora.notes.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nuvora.notes.databinding.RecyclerLabelBinding
import com.nuvora.notes.recyclerview.ItemListener
import com.nuvora.notes.recyclerview.StringDiffCallback
import com.nuvora.notes.recyclerview.viewholder.LabelVH

class LabelAdapter(private val listener: ItemListener) : ListAdapter<String, LabelVH>(StringDiffCallback()) {

    override fun onBindViewHolder(holder: LabelVH, position: Int) {
        val label = getItem(position)
        holder.bind(label)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LabelVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerLabelBinding.inflate(inflater, parent, false)
        return LabelVH(binding, listener)
    }
}