package com.github.torczuk.sandbox.kotlin.repository

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>