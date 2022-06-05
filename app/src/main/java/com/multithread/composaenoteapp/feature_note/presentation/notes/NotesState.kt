package com.multithread.composaenoteapp.feature_note.presentation.notes

import com.multithread.composaenoteapp.feature_note.domain.model.Note
import com.multithread.composaenoteapp.feature_note.domain.util.NoteOrder
import com.multithread.composaenoteapp.feature_note.domain.util.OrderType

/**
 * @author annah
 * Created 6/4/2022 at 10:00 PM
 */
data class NotesState(
    val notes : List<Note>  = emptyList(),
    val noteOrder : NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSelectionVisible : Boolean = false
) {
}