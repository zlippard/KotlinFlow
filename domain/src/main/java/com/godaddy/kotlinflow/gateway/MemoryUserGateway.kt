package com.godaddy.kotlinflow.gateway

import com.godaddy.kotlinflow.model.Universe.ALTERNATE
import com.godaddy.kotlinflow.model.Universe.PRIMARY
import com.godaddy.kotlinflow.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class MemoryUserGateway : UserGateway {
    private val allUsers = listOf(
        User("Walter", "Bishop", PRIMARY),
        User("Peter", "Bishop", PRIMARY),
        User("Olivia", "Dunham", PRIMARY),
        User("Astrid", "Farnsworth", PRIMARY),
        User("Phillip", "Broyles", PRIMARY),
        User("Walternate", "Bishop", ALTERNATE),
        User("Fauxlivia", "Dunham", ALTERNATE),
        User("Nina", "Sharp", PRIMARY),
        User("David", "Robert Jones", PRIMARY),
        User("Thomas", "Jerome Newton", ALTERNATE)
    )

    override val userFlow = flow {
        while (true) {
            val size = Random(System.nanoTime()).nextInt(1, allUsers.size)
            val usersToEmit = (0..size)
                .shuffled()
                .take(size)
                .map { index ->
                    allUsers[index]
                }
            println("[MemoryUserGateway] Emitting users: $usersToEmit")
            emit(usersToEmit)
            delay(5_000L)
        }
    }
}
