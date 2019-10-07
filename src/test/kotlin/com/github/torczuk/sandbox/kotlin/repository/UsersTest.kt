package com.github.torczuk.sandbox.kotlin.repository

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UsersTest(
    @Autowired val users: Users,
    @Autowired val userRepository: UserRepository
) {

    @Test
    fun `should save new user`() {
        val newUser = User(name = "admin", email = "admin@app.com")

        val saved = users + newUser

        assertThat(saved).isEqualTo(userRepository.findById(saved.id!!).get())
    }

    @Test
    fun `should get new user by id`() {
        val saved = userRepository.save(User(name = "admin", email = "admin@app.com"))
        val saveId = saved.id!!

        val persisted = users[saveId]

        assertThat(persisted).isEqualTo(persisted)
    }

    @Test
    fun `should delete user`() {
        val saved = userRepository.save(User(name = "admin", email = "admin@app.com"))
        val saveId = saved.id!!

        val persisted = users[saveId]

        assertThat(persisted).isEqualTo(persisted)

        users - saved

        assertThat(userRepository.findById(saveId)).isNotPresent
    }

    @Test
    fun `should check if user has been persisted`() {
        val saved = userRepository.save(User(name = "admin", email = "admin@app.com"))

        val isPersisted = saved in users

        assertThat(isPersisted).isTrue()
    }

    @Test
    fun `should find user by predicate`() {
        val admin1 = users + User(name = "admin", email = "admin1@app.com")
        val admin2 = users + User(name = "admin", email = "admin2@app.com")

        val result = users.filter { user -> user.name == "admin" }

        Assertions.assertThat(result).containsExactly(admin1, admin2)
    }
}