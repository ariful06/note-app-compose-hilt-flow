package com.multithread.composaenoteapp.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.multithread.composaenoteapp.feature_note.domain.model.Note
import com.multithread.composaenoteapp.feature_note.domain.user_case.NoteUserCases
import com.multithread.composaenoteapp.feature_note.domain.util.NoteOrder
import com.multithread.composaenoteapp.feature_note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author annah
 * Created 6/4/2022 at 9:59 PM
 */
@HiltViewModel
class NotesViewModel @Inject constructor(private val noteUserCase: NoteUserCases) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var recentlyDeletedNote: Note? = null
    private var getNotesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class && state.value.noteOrder.orderType == event.noteOrder.orderType) {
                    return
                }
                getNotes(event.noteOrder)
            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUserCase.deleteNote(event.note)
                }
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUserCase.addNote(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSelectionVisible = !state.value.isOrderSelectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = noteUserCase.getNotes(noteOrder).onEach { notes ->
            _state.value = state.value.copy(notes = notes, noteOrder = noteOrder)
        }.launchIn(viewModelScope)
    }
}