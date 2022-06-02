package com.multithread.composaenoteapp.feature_note.domain.user_case

import com.multithread.composaenoteapp.feature_note.domain.model.Note
import com.multithread.composaenoteapp.feature_note.domain.repository.NoteRepository
import com.multithread.composaenoteapp.feature_note.domain.util.NoteOrder
import com.multithread.composaenoteapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * @author annah
 * Created 6/2/2022 at 8:55 AM
 */
class GetNotesUserCase(private val repository: NoteRepository) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ) : Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when(noteOrder.orderType){
                is OrderType.Ascending -> {
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending ->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending  { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending  { it.color }
                    }
                }
            }


        }
    }
}