package com.diego.conoceeldestino.dto

import java.io.Serializable
import java.time.Instant
import javax.persistence.*

data class UserDto(
    val id: Long? = null,
    val name: String? = null,
    val lastName: String? = null,
    val username: String? = null,
    val password: String? = null,
    val createdAt: Instant? = null,
    val email: String? = null,
    val phone: Long? = null
) : Serializable
