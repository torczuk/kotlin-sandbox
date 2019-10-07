package com.github.torczuk.sandbox.kotlin.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class Users(@Autowired val userRepository: UserRepository) {

    operator fun plus(user: User) = userRepository.save(user)

    operator fun minus(user: User) = userRepository.delete(user)

    operator fun get(id: Long?): User? = userRepository.findById(id!!).orElse(null)

    operator fun contains(saved: User): Boolean = userRepository.findAll().contains(saved)

    operator fun iterator(): Iterator<User> = userRepository.findAll().iterator()

    fun filter(predicate: (User) -> Boolean): List<User> = userRepository.findAll().filter(predicate)
}