package com.example.roomdatatoturial.data.viewModel

import androidx.lifecycle.ViewModel
import com.example.roomdatatoturial.data.repo.Repository
import com.example.roomdatatoturial.data.response.AppResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ContactViewModel @Inject constructor(val repository: Repository):ViewModel() {

    private val _state= MutableStateFlow<AppResponse>(AppResponse())
     var state=_state.asStateFlow()

}