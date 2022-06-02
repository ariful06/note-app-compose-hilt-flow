package com.multithread.composaenoteapp.feature_note.domain.repository

import com.multithread.composaenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * @author annah
 * Created 6/2/2022 at 8:48 AM
 */
interface NoteRepository {

    fun getNotes () : Flow<List<Note>>

    suspend fun getNoteById(id: Int) : Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}