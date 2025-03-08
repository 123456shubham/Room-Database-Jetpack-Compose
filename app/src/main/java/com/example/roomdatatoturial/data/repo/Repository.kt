package com.example.roomdatatoturial.data.repo

import com.example.roomdatatoturial.data.database.ContractDAO
import com.example.roomdatatoturial.data.entity.Contact

class Repository(val contractDAO: ContractDAO) {

    suspend fun insertContact(contact: Contact)=contractDAO.insertUser(contact)

    suspend fun updateContact(contact: Contact)=contractDAO.updateUser(contact)

   suspend fun deleteContact(contact: Contact)=contractDAO.deleteUser(contact)

    suspend fun getAllContacts()=contractDAO.getAllUsers()
}