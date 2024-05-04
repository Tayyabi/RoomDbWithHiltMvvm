package com.xyron.roomdbwithhiltmvvm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xyron.roomdbwithhiltmvvm.Contact
import com.xyron.roomdbwithhiltmvvm.db.ContactDao
import com.xyron.roomdbwithhiltmvvm.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val repository: ContactRepository) : ViewModel() {


    val contacts : StateFlow<List<Contact>>
        get() = repository.contacts


    init {
        viewModelScope.launch {
            repository.getContacts()
        }
    }

    fun saveContact(firstName: String, lastName: String, phoneNumber: String) {
        viewModelScope.launch {
            repository.saveContact(contact = Contact(firstName, lastName, phoneNumber))
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch {
            repository.deleteContact(contact = contact)
        }
    }



}