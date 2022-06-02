package com.multithread.composaenoteapp.feature_note.data.data_source

import androidx.room.Database
import com.multithread.composaenoteapp.feature_note.domain.model.Note

/**
 * @author annah
 * Created 6/2/2022 at 8:46 AM
 */
@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase{
    abstract val noteDao : NoteDao
}