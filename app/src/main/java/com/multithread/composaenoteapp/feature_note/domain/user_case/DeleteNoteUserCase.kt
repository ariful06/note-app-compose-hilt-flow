package com.multithread.composaenoteapp.feature_note.domain.user_case

import com.multithread.composaenoteapp.feature_note.domain.model.Note
import com.multithread.composaenoteapp.feature_note.domain.repository.NoteRepository

/**
 * @author annah
 * Created 6/2/2022 at 9:10 AM
 */
class DeleteNoteUserCase(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}