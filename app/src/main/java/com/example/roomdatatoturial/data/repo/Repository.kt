package com.example.roomdatatoturial.data.repo

import com.example.roomdatatoturial.data.database.ContractDAO
import com.example.roomdatatoturial.data.entity.Contact

class Repository(val contractDAO: ContractDAO) {

    fun insertContact(contact: Contact)=contractDAO.insertUser(contact)

    fun updateContact(contact: Contact)=contractDAO.updateUser(contact)

    fun deleteContact(contact: Contact)=contractDAO.deleteUser(contact)

    fun getAllContacts()=contractDAO.getAllUsers()
}