package com.multithread.composaenoteapp.feature_note.domain.user_case

/**
 * @author annah
 * Created 6/2/2022 at 9:12 AM
 */
data class NoteUserCases(
    val getNotes : GetNotesUserCase,
    val deleteNote : DeleteNoteUserCase
)
