package com.github.torczuk.sandbox.kotlin.repository

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id

@Entity
data class User(
    @GeneratedValue(strategy = IDENTITY) @Id val id: Long? = null,
    val name: String? = null,
    val email: String? = null
)