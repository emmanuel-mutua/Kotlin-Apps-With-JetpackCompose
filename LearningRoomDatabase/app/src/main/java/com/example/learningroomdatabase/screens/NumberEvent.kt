package com.example.learningroomdatabase.screens

import android.app.Activity


sealed interface NumberEvent{
    object SaveNumber: NumberEvent
    data class SetFirstName(val fName: String): NumberEvent
    data class SetLastName(val lName: String) : NumberEvent
    data class SetPhoneNumber(val pNumber: String): NumberEvent
    data class DeleteNumber(val number: Numbers):NumberEvent
    data class SortContacts(val sortType: SortTyp): NumberEvent
    data class CallNumber(val number: String): NumberEvent
    data class MessageNumber(val number: String): NumberEvent
    data class ShareNumber(val number: Numbers): NumberEvent
    object ShowDialog : NumberEvent
    object HideDialog: NumberEvent
}