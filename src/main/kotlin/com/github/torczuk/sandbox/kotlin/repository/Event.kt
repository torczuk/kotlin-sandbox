package com.github.torczuk.sandbox.kotlin.repository

class Event(val id: Long, val email: String) {

    val name: String
        get() = email.substringBeforeLast("@")
}