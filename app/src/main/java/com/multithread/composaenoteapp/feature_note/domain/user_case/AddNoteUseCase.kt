package com.multithread.composaenoteapp.feature_note.domain.user_case

import com.multithread.composaenoteapp.feature_note.domain.model.InvalidNoteException
import com.multithread.composaenoteapp.feature_note.domain.model.Note
import com.multithread.composaenoteapp.feature_note.domain.repository.NoteRepository

/**
 * @author annah
 * Created 6/4/2022 at 10:10 PM
 */
class AddNoteUseCase (private val repository: NoteRepository){

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note : Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}