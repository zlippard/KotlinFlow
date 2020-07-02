package com.godaddy.kotlinflow.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.godaddy.kotlinflow.gateway.MemoryUserGateway
import com.godaddy.kotlinflow.repository.UserRepository

class MainViewModel : ViewModel() {
    private val userRepository = UserRepository(MemoryUserGateway()) // Inject

    val usersLiveData= userRepository.userFlow.asLiveData()
    val userCountLiveData = usersLiveData.switchMap { liveData { emit(it.size) } }
}
