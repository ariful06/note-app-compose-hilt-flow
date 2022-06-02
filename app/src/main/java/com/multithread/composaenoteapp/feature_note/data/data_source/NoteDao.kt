package com.multithread.composaenoteapp.feature_note.data.data_source

import androidx.room.*
import com.multithread.composaenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

/**
 * @author annah
 * Created 6/2/2022 at 8:43 AM
 */
@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes() : Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id : Int) : Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note : Note)

    @Delete
    suspend fun deleteNote(note : Note)
}