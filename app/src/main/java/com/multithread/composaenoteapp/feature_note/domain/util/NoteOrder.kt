package com.multithread.composaenoteapp.feature_note.domain.util

/**
 * @author annah
 * Created 6/2/2022 at 8:58 AM
 */
sealed class NoteOrder(val orderType: OrderType){
    class Title(orderType: OrderType) : NoteOrder(orderType)
    class Date(orderType: OrderType) : NoteOrder(orderType)
    class Color(orderType: OrderType) : NoteOrder(orderType)

}
