package com.godaddy.kotlinflow.gateway

import com.godaddy.kotlinflow.model.User
import kotlinx.coroutines.flow.Flow

interface UserGateway {
    val userFlow: Flow<List<User>>
}
