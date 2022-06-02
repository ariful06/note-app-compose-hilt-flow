package com.multithread.composaenoteapp.feature_note.domain.util

import androidx.room.FtsOptions

/**
 * @author annah
 * Created 6/2/2022 at 8:57 AM
 */
sealed class OrderType{
    object Ascending : OrderType()
    object Descending : OrderType()
}
