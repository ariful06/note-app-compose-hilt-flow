package com.multithread.composaenoteapp.di

import android.app.Application
import androidx.room.Room
import com.multithread.composaenoteapp.feature_note.data.data_source.NoteDao
import com.multithread.composaenoteapp.feature_note.data.data_source.NoteDatabase
import com.multithread.composaenoteapp.feature_note.domain.repository.NoteRepository
import com.multithread.composaenoteapp.feature_note.domain.repository.NoteRepositoryImpl
import com.multithread.composaenoteapp.feature_note.domain.user_case.AddNoteUseCase
import com.multithread.composaenoteapp.feature_note.domain.user_case.DeleteNoteUserCase
import com.multithread.composaenoteapp.feature_note.domain.user_case.GetNotesUserCase
import com.multithread.composaenoteapp.feature_note.domain.user_case.NoteUserCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author annah
 * Created 6/4/2022 at 9:49 PM
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application) : NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db : NoteDatabase) : NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUserCases(repository: NoteRepository) : NoteUserCases{
        return  NoteUserCases(
            getNotes = GetNotesUserCase(repository),
            deleteNote = DeleteNoteUserCase(repository),
            addNote = AddNoteUseCase(repository)
        )
    }

}