package com.example.learningroomdatabase.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NumbersViewModel(private val dao: NumbersDao) : ViewModel(){

     private val _sortType = MutableStateFlow(SortTyp.FIRST_NAME)

    private val _state = MutableStateFlow(NumberState())

    private val _contacts = _sortType.flatMapLatest {
        sortType ->
        when(sortType){
            SortTyp.FIRST_NAME -> dao.getNumberOrderByfName()
            SortTyp.LAST_NAME -> dao.getNumberOrderBylName()
            SortTyp.PHONE_NUMBER -> dao.getNumberOrderBypNumber()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val state = combine(_state, _contacts, _sortType){
        state,contacts,sortType ->
        state.copy(
            numbers = contacts,
            sortTyp = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),NumberState() )

    fun onEvent(event : NumberEvent){
        when(event){
            is NumberEvent.DeleteNumber -> {
                viewModelScope.launch {
                    dao.deleteNumber(event.number)
                }
            }
            NumberEvent.HideDialog -> {
                _state.update {
                    it.copy(
                        isAddingContact = false
                    )
                }
            }
            NumberEvent.SaveNumber -> {
                    val firstName = state.value.fName
                val lastName = state.value.lName
                val phoneNumber = state.value.pNumber

                if(firstName.isBlank() || lastName.isBlank() || phoneNumber.isBlank()){
                    return
                }

                val number = Numbers(
                    fName = firstName,
                    lName = lastName,
                    pNumber = phoneNumber
                )

                viewModelScope.launch {
                    dao.addNumber(number)
                }

                _state.update {
                    it.copy(
                        fName = "",
                        lName = "",
                        pNumber = "",
                        isAddingContact = false
                    )
                }
            }
            is NumberEvent.SetFirstName -> {
                _state.update {
                    it.copy(
                        fName = event.fName
                    )
                }
            }
            is NumberEvent.SetLastName -> {
                _state.update {
                    it.copy(
                        lName = event.lName
                    )
                }
            }
            is NumberEvent.SetPhoneNumber -> {
                _state.update {
                    it.copy(
                        pNumber = event.pNumber
                    )
                }
            }
            NumberEvent.ShowDialog -> {
                _state.update {
                    it.copy(
                        isAddingContact = true
                    )
                }
            }
            is NumberEvent.SortContacts -> {
               _sortType.value = event.sortType
            }
        }
    }

}