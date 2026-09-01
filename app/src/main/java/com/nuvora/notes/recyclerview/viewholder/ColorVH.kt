package com.nuvora.notes.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.nuvora.notes.databinding.RecyclerColorBinding
import com.nuvora.notes.miscellaneous.Operations
import com.nuvora.notes.recyclerview.ItemListener
import com.nuvora.notes.room.Color

class ColorVH(private val binding: RecyclerColorBinding, listener: ItemListener) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            listener.onClick(adapterPosition)
        }
    }

    fun bind(color: Color) {
        val value = Operations.extractColor(color, binding.root.context)
        binding.root.setCardBackgroundColor(value)
    }
}