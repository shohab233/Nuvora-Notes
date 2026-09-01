package com.nuvora.notes

import androidx.lifecycle.MutableLiveData
import com.nuvora.notes.image.Event
import com.nuvora.notes.preferences.BetterLiveData
import com.nuvora.notes.room.BaseNote

class ActionMode {

    val enabled = BetterLiveData(false)
    val count = BetterLiveData(0)
    val selectedNotes = HashMap<Long, BaseNote>()
    val selectedIds = selectedNotes.keys
    val closeListener = MutableLiveData<Event<Set<Long>>>()

    private fun refresh() {
        count.value = selectedNotes.size
        enabled.value = selectedNotes.size != 0
    }

    fun add(id: Long, baseNote: BaseNote) {
        selectedNotes[id] = baseNote
        refresh()
    }

    fun remove(id: Long) {
        selectedNotes.remove(id)
        refresh()
    }

    fun close(notify: Boolean) {
        val previous = HashSet(selectedIds)
        selectedNotes.clear()
        refresh()
        if (notify) {
            closeListener.value = Event(previous)
        }
    }

    fun isEnabled() = enabled.value

    // We assume selectedNotes.size is 1
    fun getFirstNote() = selectedNotes.values.first()
}