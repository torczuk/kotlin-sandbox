package com.github.torczuk.sandbox.kotlin.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UsesDemoTest(
    @Autowired val users: Users
) {

    @Test
    fun name() {
        val user1 = users + User(name = "user1", email = "user1@email.com")
        val user2 = users + User(name = "user2", email = "user2@email.com")
        val user3 = users + User(name = "user3", email = "user3@email.com")

        for (user in users) {
            println(user)
        }
//        User(id=1, name=user1, email=user1@email.com)
//        User(id=2, name=user2, email=user2@email.com)
//        User(id=3, name=user3, email=user3@email.com)

        users - user1
        val exist = user1 in users
        println(exist)
//        false

        for (user in users) {
            println(user)
        }
//        User(id=2, name=user2, email=user2@email.com)
//        User(id=3, name=user3, email=user3@email.com)

        val user = users[user2.id]
        val updated = user?.copy(name = "user3")

        if (updated != null) {
            users + updated
        }

        val list = users.filter { it.name == "user3" }

        println(list)
//        [User(id=2, name=user3, email=user2@email.com), User(id=3, name=user3, email=user3@email.com)]
    }
}