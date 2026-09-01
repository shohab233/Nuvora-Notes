package com.nuvora.notes.fragments

import androidx.lifecycle.LiveData
import com.nuvora.notes.R
import com.nuvora.notes.miscellaneous.Constants
import com.nuvora.notes.room.Item

class DisplayLabel : NotallyFragment() {

    override fun getBackground() = R.drawable.label

    override fun getObservable(): LiveData<List<Item>> {
        val label = requireNotNull(requireArguments().getString(Constants.SelectedLabel))
        return model.getNotesByLabel(label)
    }
}