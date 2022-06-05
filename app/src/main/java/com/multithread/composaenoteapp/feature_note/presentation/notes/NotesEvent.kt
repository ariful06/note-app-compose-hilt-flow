package com.multithread.composaenoteapp.feature_note.presentation.notes

import com.multithread.composaenoteapp.feature_note.domain.model.Note
import com.multithread.composaenoteapp.feature_note.domain.util.NoteOrder

/**
 * @author annah
 * Created 6/4/2022 at 10:03 PM
 */
sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
