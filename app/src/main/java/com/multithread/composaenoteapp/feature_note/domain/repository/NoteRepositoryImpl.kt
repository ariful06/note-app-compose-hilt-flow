package com.multithread.composaenoteapp.feature_note.domain.repository

import com.multithread.composaenoteapp.feature_note.data.data_source.NoteDao
import com.multithread.composaenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * @author annah
 * Created 6/2/2022 at 8:50 AM
 */
class NoteRepositoryImpl(private val dao : NoteDao) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }

}