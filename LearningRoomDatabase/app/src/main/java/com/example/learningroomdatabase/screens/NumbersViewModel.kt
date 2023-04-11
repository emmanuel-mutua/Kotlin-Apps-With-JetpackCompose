package com.example.learningroomdatabase.screens

import android.Manifest
import android.R.attr
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class NumbersViewModel(private val dao: NumbersDao, private val activity: Activity) : ViewModel(){

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


    /**
     * Flow basically provides live data
     * passing the latest values of _state, _contact, _sortType to state, then copy the latest values to state
     * state flow is basically a flow that can be observed by multiple consumers/ similar to livedata
     */
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
            is NumberEvent.CallNumber -> {
                val phoneNumber = event.number
                initiatePhoneCall(phoneNumber)
            }
            is NumberEvent.MessageNumber -> {
                val number = event.number
                initiateSendMessage(number)
            }
            is NumberEvent.ShareNumber -> {
                val phoneNumber = event.number.pNumber
                val fName = event.number.fName
                val lName = event.number.lName

                val contact = "Name : $fName $lName , Tel: $phoneNumber"
                shareNumber(contact)
            }
            else -> {}
        }
    }


        private fun initiateSendMessage(phoneNumber: String) {
            val REQUEST_CODE_SEND_SMS_PERMISSION = 1
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("smsto:$phoneNumber")
            val permission = Manifest.permission.SEND_SMS
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, arrayOf(permission), REQUEST_CODE_SEND_SMS_PERMISSION)
            } else {
                // Permission already granted, initiate sending SMS
                activity.startActivity(Intent.createChooser(intent, "Msg Via"))
            }
        }

    private fun shareNumber(phoneNumber: String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, phoneNumber)
        activity.startActivity(Intent.createChooser(intent, "Share Via"))
    }


    // Function to initiate a phone call
    private fun initiatePhoneCall(phoneNumber: String) {
        val REQUEST_CODE_CALL_PHONE_PERMISSION = 1
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$phoneNumber")
        val permission = Manifest.permission.CALL_PHONE
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, arrayOf(permission), REQUEST_CODE_CALL_PHONE_PERMISSION)
        } else {
            // Permission already granted, initiate phone call
            activity.startActivity(Intent.createChooser(intent, "Call Via"))
        }
    }


}

