package com.gdsciitbhu.android.phonebook

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val contactList = MutableLiveData(emptyList<Contact>())

    fun saveContact(contact: Contact) {
        contactList.value = contactList.value!! + contact
    }

}