package com.example.learningroomdatabase.screens


sealed interface NumberEvent{
    object SaveNumber: NumberEvent
    data class SetFirstName(val fName: String): NumberEvent
    data class SetLastName(val lName: String) : NumberEvent
    data class SetPhoneNumber(val pNumber: String): NumberEvent
    data class DeleteNumber(val number: Numbers):NumberEvent
    data class SortContacts(val sortType: SortTyp): NumberEvent
    object ShowDialog : NumberEvent
    object HideDialog: NumberEvent
}