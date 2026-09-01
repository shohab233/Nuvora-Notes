package com.nuvora.notes.preferences

import androidx.lifecycle.MutableLiveData

class BetterLiveData<T>(private val defaultValue: T) : MutableLiveData<T>(defaultValue) {

    override fun getValue(): T {
        return super.getValue() ?: defaultValue
    }
}