package com.nuvora.notes.recyclerview.viewholder

import android.text.format.DateUtils
import androidx.recyclerview.widget.RecyclerView
import com.nuvora.notes.databinding.RecyclerAudioBinding
import com.nuvora.notes.room.Audio
import java.text.DateFormat

class AudioVH(private val binding: RecyclerAudioBinding, onClick: (Int) -> Unit, private val formatter: DateFormat) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener { onClick(adapterPosition) }
    }

    fun bind(audio: Audio) {
        binding.Date.text = formatter.format(audio.timestamp)
        binding.Length.text = DateUtils.formatElapsedTime(audio.duration / 1000)
    }
}