package com.multithread.composaenoteapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.multithread.composaenoteapp.feature_note.domain.model.Note

/**
 * @author annah
 * Created 6/2/2022 at 8:46 AM
 */
@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase(){
    abstract val noteDao : NoteDao

    companion object{
        const val DATABASE_NAME = "notes_db"
    }
}