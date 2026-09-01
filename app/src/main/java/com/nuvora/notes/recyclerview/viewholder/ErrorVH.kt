package com.nuvora.notes.recyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.nuvora.notes.databinding.ErrorBinding
import com.nuvora.notes.image.ImageError

class ErrorVH(private val binding: ErrorBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(error: ImageError) {
        binding.Name.text = error.name
        binding.Description.text = error.description
    }
}