package com.example.roomdatatoturial.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatatoturial.data.entity.Contact
import com.example.roomdatatoturial.data.repo.Repository
import com.example.roomdatatoturial.data.response.AppResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(val repository: Repository):ViewModel() {

    private val _state= MutableStateFlow<AppResponse>(AppResponse())
     var state=_state.asStateFlow()

    fun insertContact(){
        val contact= Contact(
            name = state.value.name.value,
            email = state.value.email.value,
            phone = state.value.mobileNumber.value
        )
        viewModelScope.launch {
            repository.insertContact(contact)
        }
        state.value.name.value=""
        state.value.email.value=""
        state.value.mobileNumber.value=""
    }
}