package com.nuvora.notes.fragments

import com.nuvora.notes.R

class Archived : NotallyFragment() {

    override fun getBackground() = R.drawable.archive

    override fun getObservable() = model.archivedNotes
}