package com.multithread.composaenoteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.multithread.composaenoteapp.ui.theme.*

/**
 * @author annah
 * Created 6/2/2022 at 8:34 AM
 */
@Entity
data class Note(
    val title : String,
    val content : String,
    val timestamp : Long,
    val color : Int,
    @PrimaryKey val id : Int? = null
){
    companion object{
        val noteColors = listOf(RedOrange, RedPink, Blue, Violet, LightGreen)
    }
}
