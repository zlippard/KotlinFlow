package com.godaddy.kotlinflow.repository

import com.godaddy.kotlinflow.gateway.UserGateway

class UserRepository(userGateway: UserGateway) {
    val userFlow = userGateway.userFlow
}
