package com.xyron.roomdbwithhiltmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xyron.roomdbwithhiltmvvm.Contact
import com.xyron.roomdbwithhiltmvvm.db.ContactDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
class ContactRepository @Inject constructor(private val contactDb: ContactDatabase) {

    private val _contactResult = MutableStateFlow<List<Contact>>(emptyList())

    val contacts: StateFlow<List<Contact>>
        get() = _contactResult


    suspend fun getContacts(){
        val contactList = contactDb.dao.getContactsOrderByFirstName()
        _contactResult.emit(contactList)
    }

    suspend fun saveContact(contact: Contact){
        contactDb.dao.upsertContact(contact)
    }
    suspend fun deleteContact(contact: Contact){
        contactDb.dao.deleteContact(contact)
    }

}