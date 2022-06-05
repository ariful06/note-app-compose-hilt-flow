package com.multithread.composaenoteapp.feature_note.presentation.notes.components

import android.graphics.Canvas
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.multithread.composaenoteapp.feature_note.domain.model.Note


/**
 * @author annah
 * Created 6/5/2022 at 8:15 AM
 */

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    onDeleteClick: () -> Unit
) {
    Box(modifier = Modifier) {
        Canvas(
            modifier = Modifier.matchParentSize()
        ) {
            val path  = Path().apply {
                lineTo(size.width - cutCornerSize.toPx(),0f)
                lineTo(size.width,  cutCornerSize.toPx())
                lineTo(size.width,size.height)
                lineTo(0f,size.height)
                close()
            }

        }
    }

}