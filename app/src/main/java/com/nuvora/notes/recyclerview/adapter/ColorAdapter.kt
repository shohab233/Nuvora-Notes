package com.nuvora.notes.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nuvora.notes.databinding.RecyclerColorBinding
import com.nuvora.notes.recyclerview.ItemListener
import com.nuvora.notes.recyclerview.viewholder.ColorVH
import com.nuvora.notes.room.Color

class ColorAdapter(private val listener: ItemListener) : RecyclerView.Adapter<ColorVH>() {

    private val colors = Color.entries

    override fun getItemCount() = colors.size

    override fun onBindViewHolder(holder: ColorVH, position: Int) {
        val color = colors[position]
        holder.bind(color)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerColorBinding.inflate(inflater, parent, false)
        return ColorVH(binding, listener)
    }
}