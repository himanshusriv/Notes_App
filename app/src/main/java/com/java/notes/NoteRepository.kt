package com.java.notes

import androidx.lifecycle.LiveData

open class NoteRepository (private val noteDao: NoteDao) {

    val allNotes : LiveData<List<Note>> = noteDao.getAllNotes()
    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }
    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }

}