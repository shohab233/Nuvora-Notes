package com.nuvora.notes.recyclerview

interface ItemListener {

    fun onClick(position: Int)

    fun onLongClick(position: Int)
}